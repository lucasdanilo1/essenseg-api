package sistema.essenseg.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import sistema.essenseg.dto.cliente.*;
import sistema.essenseg.model.cliente.Cliente;
import sistema.essenseg.service.ClienteService;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    ClienteService service;

    @Transactional
    @PostMapping("cadastro/save")
    public ResponseEntity<DadosClienteDetalhadoDTO> cadastrar(@Valid @RequestBody DadosCadastroClienteDTO dados, UriComponentsBuilder uriBuilder){
        Cliente cliente = service.cadastrar(dados);
        return ResponseEntity.created(
                uriBuilder.path("cliente/{id}")
                        .buildAndExpand(cliente.getId())
                        .toUri()
        ).body(new DadosClienteDetalhadoDTO(cliente));
    }

    @GetMapping("lista")
    public ResponseEntity<Page<DadosListagemCliente>> clientes(@PageableDefault(size = 30) Pageable page) {
        return ResponseEntity.ok().body(service.listar(page));
    }

    @Transactional
    @PostMapping("lista/filtrada")
    public ResponseEntity<Page<DadosListagemCliente>> clientesFiltrados(@RequestBody FiltrosClienteDTO filtros, Pageable page) {
        return ResponseEntity.ok().body(service.listarFiltrados(filtros, page));
    }

    @GetMapping("{id}")
    public ResponseEntity<DadosClienteDetalhadoDTO> detalhar(@PathVariable Long id){
        return ResponseEntity.ok().body(service.detalhar(id));
    }

    @Transactional
    @PutMapping("{id}/atualizar")
    public ResponseEntity<DadosClienteDetalhadoDTO> atualizar(@PathVariable Long id, @Valid @RequestBody AtualizaDadosClienteDTO dados){
        return ResponseEntity.ok().body(service.atualizar(id, dados));
    }

    @Transactional
    @DeleteMapping("inativar/{id}")
    public ResponseEntity<DadosClienteDetalhadoDTO> inativar(@PathVariable Long id){
        return ResponseEntity.ok().body(service.inativar(id));
    }

}
