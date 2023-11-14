package sistema.essenseg.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import sistema.essenseg.dto.cliente.AtualizaDadosClienteDTO;
import sistema.essenseg.dto.cliente.DadosCadastroClienteDTO;
import sistema.essenseg.dto.cliente.DadosClienteDetalhadoDTO;
import sistema.essenseg.service.AnexoService;
import sistema.essenseg.service.ClienteService;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    ClienteService service;
    @Autowired
    AnexoService anexoService;

    @Transactional
    @PostMapping("cadastro/save")
    public ResponseEntity<DadosClienteDetalhadoDTO> cadastrar(@Valid @RequestBody DadosCadastroClienteDTO dados, UriComponentsBuilder uriBuilder){
        return service.cadastrar(dados, uriBuilder);
    }

    @GetMapping("{id}")
    public ResponseEntity<DadosClienteDetalhadoDTO> detalhar(@PathVariable Long id){
        return service.detalhar(id);
    }

    @Transactional
    @PutMapping("{id}/update")
    public ResponseEntity<DadosClienteDetalhadoDTO> atualizar(@PathVariable Long id, @Valid @RequestBody AtualizaDadosClienteDTO dados){
        return service.atualizar(id, dados);
    }

    @GetMapping("/{clienteId}/anexo/{anexoId}")
    public ResponseEntity<Resource> downloadAnexos(@PathVariable Long clienteId, @PathVariable Long anexoId)  {
        return anexoService.downloadAnexos(clienteId, anexoId);
    }

}
