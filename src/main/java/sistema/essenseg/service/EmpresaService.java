package sistema.essenseg.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
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
    public ResponseEntity<DadosEmpresaDetalhadaDTO> cadastrar(DadosCadastroEmpresaDTO dados, UriComponentsBuilder uriBuilder) {

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
        var uri = uriBuilder.path("empresa/{id}").buildAndExpand(empresa.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosEmpresaDetalhadaDTO(empresa));
    }

    public ResponseEntity<Page<DadosListagemEmpresa>> listar(Pageable page){
        return ResponseEntity.ok().body(repository.findAll(page).map(DadosListagemEmpresa::new));
    }

    public ResponseEntity<Page<DadosListagemEmpresa>> listarFiltrados(FiltrosEmpresaDTO filtros, Pageable page){
        return ResponseEntity.ok().body(repository.findAll(filtros, page).map(DadosListagemEmpresa::new));
    }

    public ResponseEntity<DadosEmpresaDetalhadaDTO> detalhar(Long id) {
        return ResponseEntity.ok(new DadosEmpresaDetalhadaDTO(repository.getReferenceById(id)));
    }

    public ResponseEntity<DadosEmpresaDetalhadaDTO> atualizar(Long id, AtualizaDadosEmpresaDTO dados) {

        if(repository.existsByDadosEspecificosEmpresaCnpj(dados.atualizaDadosEspecificosEmpresaDTO().cnpj())){
            throw new ClienteJaCadastradoException();
        }

        var empresa = repository.getReferenceById(id);

        seguradoServiceUtil.atualizaOperadoraOuAdministradora(empresa, dados.atualizaDadosSeguradoDTO());

        empresa.atualizarInformacoes(dados);
        return ResponseEntity.ok().body(new DadosEmpresaDetalhadaDTO(empresa));
    }

    public ResponseEntity<DadosEmpresaDetalhadaDTO> inativar(Long id) {
        var empresa = repository.getReferenceById(id);
        empresa.setAtivo(false);
        return ResponseEntity.ok(new DadosEmpresaDetalhadaDTO(empresa));
    }
}
