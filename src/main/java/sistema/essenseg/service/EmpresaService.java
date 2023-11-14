package sistema.essenseg.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import sistema.essenseg.dto.empresa.*;
import sistema.essenseg.model.Administradora;
import sistema.essenseg.model.Operadora;
import sistema.essenseg.model.empresa.Empresa;
import sistema.essenseg.repository.AdministradoraRepository;
import sistema.essenseg.repository.EmpresaRepository;
import sistema.essenseg.repository.OperadoraRepository;

@Service
public class EmpresaService {

    @Autowired
    EmpresaRepository repository;
    @Autowired
    OperadoraRepository operadoraRepository;
    @Autowired
    AdministradoraRepository administradoraRepository;

    @Transactional
    public ResponseEntity<DadosEmpresaDetalhadaDTO> cadastrar(DadosCadastroEmpresaDTO dados, UriComponentsBuilder uriBuilder) {
        var empresa = new Empresa(dados);

        Operadora operadora = operadoraRepository.getReferenceById(dados.dadosParaContratacaoSeguradoDTO().operadoraId());
        Administradora administradora = administradoraRepository.getReferenceById(dados.dadosParaContratacaoSeguradoDTO().administradoraId());
        empresa.getDadosContratacaoSegurado().setOperadora(operadora);
        empresa.getDadosContratacaoSegurado().setAdministradora(administradora);

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

        var empresa = repository.getReferenceById(id);

        if(dados.atualizaDadosSeguradoDTO() != null){
            if(dados.atualizaDadosSeguradoDTO().operadoraId() != null){
                var operadora = operadoraRepository.getReferenceById(dados.atualizaDadosSeguradoDTO().operadoraId());
                empresa.getDadosContratacaoSegurado().setOperadora(operadora);
            } else if (dados.atualizaDadosSeguradoDTO().administradoraId() != null) {
                var administradora = administradoraRepository.getReferenceById(dados.atualizaDadosSeguradoDTO().administradoraId());
                empresa.getDadosContratacaoSegurado().setAdministradora(administradora);
            }
        }

        empresa.atualizarInformacoes(dados);
        return ResponseEntity.ok().body(new DadosEmpresaDetalhadaDTO(empresa));
    }
}
