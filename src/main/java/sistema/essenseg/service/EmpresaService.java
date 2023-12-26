package sistema.essenseg.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sistema.essenseg.dto.empresa.*;
import sistema.essenseg.model.exception.ObjectNotFoundException;
import sistema.essenseg.model.empresa.Empresa;
import sistema.essenseg.repository.EmpresaRepository;
import sistema.essenseg.util.SeguradoServiceUtil;

@Service
public class EmpresaService {

    @Autowired
    EmpresaRepository repository;
    @Autowired
    SeguradoServiceUtil seguradoServiceUtil;

    @Transactional
    public Empresa cadastrar(DadosCadastroEmpresaDTO dados) {

        if(dados.dadosEspecificosCadastroEmpresaDTO() != null){
            if(repository.existsByDadosEspecificosEmpresaCnpj(dados.dadosEspecificosCadastroEmpresaDTO().cnpj())){
                throw new DataIntegrityViolationException("CNPJ já cadastrado");
            }
        }

        var empresa = new Empresa(dados);

        seguradoServiceUtil.defineOperadoraPorId(empresa, dados.dadosParaContratacaoSeguradoDTO().operadoraId());
        seguradoServiceUtil.defineAdministradoraPorId(empresa, dados.dadosParaContratacaoSeguradoDTO().administradoraId());
        seguradoServiceUtil.defineCorretorPorId(empresa, dados.dadosParaContratacaoSeguradoDTO().corretorId());
        seguradoServiceUtil.definePlanoPorId(empresa, dados.dadosParaContratacaoSeguradoDTO().planoId());

        repository.save(empresa);
        return empresa;
    }

    public Page<DadosListagemEmpresa> listar(Pageable page){
        return repository.findAll(page).map(DadosListagemEmpresa::new);
    }

    public Page<DadosListagemEmpresa> listarFiltrados(FiltrosEmpresaDTO filtros, Pageable page){
        return repository.findAll(filtros, page).map(DadosListagemEmpresa::new);
    }

    public DadosEmpresaDetalhadaDTO detalhar(Long id) {
        return new DadosEmpresaDetalhadaDTO(repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Segurado não encontrado")));
    }

    public DadosEmpresaDetalhadaDTO atualizar(Long id, AtualizaDadosEmpresaDTO dados) {

        var empresa = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Segurado não encontrado"));

        seguradoServiceUtil.defineOperadoraPorId(empresa, dados.atualizaDadosSeguradoDTO().operadoraId());
        seguradoServiceUtil.defineAdministradoraPorId(empresa, dados.atualizaDadosSeguradoDTO().administradoraId());
        seguradoServiceUtil.definePlanoPorId(empresa, dados.atualizaDadosSeguradoDTO().planoId());

        empresa.atualizarInformacoes(dados);

        return new DadosEmpresaDetalhadaDTO(empresa);
    }

    public DadosEmpresaDetalhadaDTO inativar(Long id) {
        var empresa = repository.getReferenceById(id);
        empresa.setAtivo(false);
        return new DadosEmpresaDetalhadaDTO(empresa);
    }
}
