package sistema.essenseg.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import sistema.essenseg.dto.cliente.AtualizaDadosClienteDTO;
import sistema.essenseg.dto.cliente.*;
import sistema.essenseg.model.Administradora;
import sistema.essenseg.model.Operadora;
import sistema.essenseg.model.cliente.Cliente;
import sistema.essenseg.repository.AdministradoraRepository;
import sistema.essenseg.repository.ClienteRepository;
import sistema.essenseg.repository.OperadoraRepository;
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
    @Autowired
    private OperadoraRepository operadoraRepository;
    @Autowired
    private AdministradoraRepository administradoraRepository;

    @Transactional
    public ResponseEntity<DadosClienteDetalhadoDTO> cadastrar(DadosCadastroClienteDTO dados, UriComponentsBuilder uriBuilder) {
        var cliente = new Cliente(dados);
        Operadora operadora = operadoraRepository.getReferenceById(dados.dadosParaContratacaoSeguradoDTO().operadoraId());
        Administradora administradora = administradoraRepository.getReferenceById(dados.dadosParaContratacaoSeguradoDTO().administradoraId());
        cliente.getDadosContratacaoSegurado().setOperadora(operadora);
        cliente.getDadosContratacaoSegurado().setAdministradora(administradora);

        clienteRepository.save(cliente);
        var uri = uriBuilder.path("cliente/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosClienteDetalhadoDTO(cliente));
    }

    public ResponseEntity<DadosClienteDetalhadoDTO> atualizar(Long id, AtualizaDadosClienteDTO dados) {

        var cliente = clienteRepository.getReferenceById(id);

        if(dados.atualizaDadosSeguradoDTO() != null){
            if(dados.atualizaDadosSeguradoDTO().operadoraId() != null){
                var operadora = operadoraRepository.getReferenceById(dados.atualizaDadosSeguradoDTO().operadoraId());
                cliente.getDadosContratacaoSegurado().setOperadora(operadora);
            } else if (dados.atualizaDadosSeguradoDTO().administradoraId() != null) {
                var administradora = administradoraRepository.getReferenceById(dados.atualizaDadosSeguradoDTO().administradoraId());
                cliente.getDadosContratacaoSegurado().setAdministradora(administradora);
            }
        }

        cliente.atualizarInformacoes(dados);
        return ResponseEntity.ok().body(new DadosClienteDetalhadoDTO(cliente));
    }

    public ResponseEntity<DadosClienteDetalhadoDTO> detalhar(Long id){
        return ResponseEntity.ok(new DadosClienteDetalhadoDTO(clienteRepository.getReferenceById(id)));
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
