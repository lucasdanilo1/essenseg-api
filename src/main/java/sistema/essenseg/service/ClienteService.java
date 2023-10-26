package sistema.essenseg.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import sistema.essenseg.dto.clienteDTO.*;
import sistema.essenseg.repository.ClienteRepository;
import sistema.essenseg.util.ClienteServiceUtil;

import java.util.List;
import java.util.Map;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private AnexoService anexoService;
    @Autowired
    private ClienteServiceUtil clienteServiceUtil;

    @Transactional
    public ResponseEntity<DadosClienteDetalhado> cadastrar(DadosClienteDTO dados, UriComponentsBuilder uriBuilder) {

        var cliente = clienteServiceUtil.novoObjCliente(dados);

        clienteRepository.save(cliente);
        var uri = uriBuilder.path("cliente/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosClienteDetalhado(cliente));
    }

    public ResponseEntity<DadosClienteDetalhado> detalhar(Long id){
        return ResponseEntity.ok(new DadosClienteDetalhado(clienteRepository.getReferenceById(id)));
    }

    public ResponseEntity<DadosClienteDetalhado> atualizar(Long id, DadosAtualizaClienteDTO dados) {
        var cliente = clienteRepository.getReferenceById(id);
        cliente.atualizarInformacoes(dados);
        return ResponseEntity.ok().body(new DadosClienteDetalhado(cliente));
    }

    public ResponseEntity<Page<DadosListagemCliente>> listar(Pageable page){
        return ResponseEntity.ok().body(clienteRepository.findAll(page).map(DadosListagemCliente::new));
    }

    public ResponseEntity<Page<DadosListagemCliente>> listarFiltrados(FiltrosClienteDTO filtros, Pageable page){
        return ResponseEntity.ok().body(clienteRepository.findAll(filtros, page).map(DadosListagemCliente::new));
    }

    public ResponseEntity<Map<String, List<?>>> obterOperadorasEAdministradoras(){
        Map<String, List<?>> listas = clienteServiceUtil.listasParaFiltragem();
        return ResponseEntity.ok().body(listas);
    }

}
