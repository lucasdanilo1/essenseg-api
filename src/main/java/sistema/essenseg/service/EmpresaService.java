package sistema.essenseg.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sistema.essenseg.dto.empresa.*;
import sistema.essenseg.infra.Exception.ClienteJaCadastradoException;
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
                throw new ClienteJaCadastradoException();
            }
        }

        var empresa = new Empresa(dados);

        seguradoServiceUtil.defineOperadora(empresa, dados.dadosParaContratacaoSeguradoDTO().operadoraId());
        seguradoServiceUtil.defineAdministradora(empresa, dados.dadosParaContratacaoSeguradoDTO().administradoraId());
        seguradoServiceUtil.defineCorretor(empresa, dados.dadosParaContratacaoSeguradoDTO().corretorId());

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
        return new DadosEmpresaDetalhadaDTO(repository.getReferenceById(id));
    }

    public DadosEmpresaDetalhadaDTO atualizar(Long id, AtualizaDadosEmpresaDTO dados) {
        var empresa = repository.getReferenceById(id);

        seguradoServiceUtil.atualizaOperadoraOuAdministradora(empresa, dados.atualizaDadosSeguradoDTO());

        empresa.atualizarInformacoes(dados);
        return new DadosEmpresaDetalhadaDTO(empresa);
    }

    public DadosEmpresaDetalhadaDTO inativar(Long id) {
        var empresa = repository.getReferenceById(id);
        empresa.setAtivo(false);
        return new DadosEmpresaDetalhadaDTO(empresa);
    }
}
