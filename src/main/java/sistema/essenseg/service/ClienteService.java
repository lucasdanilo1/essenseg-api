package sistema.essenseg.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import sistema.essenseg.dto.cliente.*;
import sistema.essenseg.infra.Exception.ClienteJaCadastradoException;
import sistema.essenseg.model.cliente.Cliente;
import sistema.essenseg.repository.ClienteRepository;
import sistema.essenseg.util.SeguradoServiceUtil;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;
    @Autowired
    private AnexoService anexoService;
    @Autowired
    private SeguradoServiceUtil seguradoServiceUtil;

    @Transactional
    public ResponseEntity<DadosClienteDetalhadoDTO> cadastrar(DadosCadastroClienteDTO dados, UriComponentsBuilder uriBuilder) {

        if(repository.existsByDadosEspecificosClienteCpf(dados.dadosEspecificosCadastroClienteDTO().cpf())){
            throw new ClienteJaCadastradoException();
        }

        var cliente = new Cliente(dados);

        seguradoServiceUtil.defineOperadora(cliente, dados.dadosParaContratacaoSeguradoDTO().operadoraId());
        seguradoServiceUtil.defineAdministradora(cliente, dados.dadosParaContratacaoSeguradoDTO().administradoraId());
        seguradoServiceUtil.defineCorretor(cliente, dados.dadosParaContratacaoSeguradoDTO().corretorId());

        repository.save(cliente);
        var uri = uriBuilder.path("cliente/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosClienteDetalhadoDTO(cliente));
    }

    public ResponseEntity<DadosClienteDetalhadoDTO> atualizar(Long id, AtualizaDadosClienteDTO dados) {

        if(repository.existsByDadosEspecificosClienteCpf(dados.atualizaDadosEspecificosClienteDTO().cpf())){
            throw new ClienteJaCadastradoException();
        }

        var cliente = repository.getReferenceById(id);

        seguradoServiceUtil.atualizaOperadoraOuAdministradora(cliente, dados.atualizaDadosSeguradoDTO());

        cliente.atualizarInformacoes(dados);
        return ResponseEntity.ok().body(new DadosClienteDetalhadoDTO(cliente));
    }

    public ResponseEntity<DadosClienteDetalhadoDTO> detalhar(Long id){
        return ResponseEntity.ok(new DadosClienteDetalhadoDTO(repository.getReferenceById(id)));
    }

    public ResponseEntity<Page<DadosListagemCliente>> listar(Pageable page){
        return ResponseEntity.ok().body(repository.findAll(page).map(DadosListagemCliente::new));
    }

    public ResponseEntity<Page<DadosListagemCliente>> listarFiltrados(FiltrosClienteDTO filtros, Pageable page){
        return ResponseEntity.ok().body(repository.findAll(filtros, page).map(DadosListagemCliente::new));
    }

    public ResponseEntity<DadosClienteDetalhadoDTO> inativar(Long id) {
        var cliente = repository.getReferenceById(id);
        cliente.setAtivo(false);
        return ResponseEntity.ok(new DadosClienteDetalhadoDTO(cliente));
    }
}
