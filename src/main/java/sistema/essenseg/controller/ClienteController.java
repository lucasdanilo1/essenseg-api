package sistema.essenseg.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import sistema.essenseg.dto.clienteDTO.DadosAtualizaClienteDTO;
import sistema.essenseg.dto.clienteDTO.DadosClienteDTO;
import sistema.essenseg.dto.clienteDTO.DadosClienteDetalhado;
import sistema.essenseg.service.AnexoService;
import sistema.essenseg.service.ClienteService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    ClienteService service;
    @Autowired
    AnexoService anexoService;

    @GetMapping("cadastro")
    public ResponseEntity<Map<String, List<?>>> formulario(DadosClienteDTO dados){
        return service.obterOperadorasEAdministradoras();
    }

    @Transactional
    @PostMapping("cadastro/save")
    public ResponseEntity<DadosClienteDetalhado> cadastrar(@Valid @RequestBody DadosClienteDTO dados, UriComponentsBuilder uriBuilder){
        return service.cadastrar(dados, uriBuilder);
    }

    @GetMapping("{id}")
    public ResponseEntity<DadosClienteDetalhado> cliente(@PathVariable Long id){
        return service.detalhar(id);
    }

    @Transactional
    @PutMapping("{id}/update")
    public ResponseEntity<DadosClienteDetalhado> atualizar(@PathVariable Long id, @RequestBody DadosAtualizaClienteDTO dados){
        return service.atualizar(id, dados);
    }

    @GetMapping("/{clienteId}/anexo/{anexoId}")
    public ResponseEntity<Resource> downloadAnexos(@PathVariable Long clienteId, @PathVariable Long anexoId)  {
        return anexoService.downloadAnexos(clienteId, anexoId);
    }

}
