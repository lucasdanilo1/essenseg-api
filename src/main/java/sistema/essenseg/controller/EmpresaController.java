package sistema.essenseg.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import sistema.essenseg.dto.empresa.AtualizaDadosEmpresaDTO;
import sistema.essenseg.dto.empresa.DadosCadastroEmpresaDTO;
import sistema.essenseg.dto.empresa.DadosEmpresaDetalhadaDTO;
import sistema.essenseg.service.EmpresaService;

@RestController
@RequestMapping("empresa")
public class EmpresaController {

    @Autowired
    EmpresaService service;

    @Transactional
    @PostMapping("cadastro/save")
    public ResponseEntity<DadosEmpresaDetalhadaDTO> cadastro(@Valid @RequestBody DadosCadastroEmpresaDTO dados, UriComponentsBuilder uriBuilder) {
        return service.cadastrar(dados, uriBuilder);
    }

    @GetMapping("{id}")
    public ResponseEntity<DadosEmpresaDetalhadaDTO> detalhar(@PathVariable Long id){
        return service.detalhar(id);
    }

    @Transactional
    @PutMapping("{id}/atualizar")
    public ResponseEntity<DadosEmpresaDetalhadaDTO> atualizar(@PathVariable Long id, @Valid @RequestBody AtualizaDadosEmpresaDTO dados){
        return service.atualizar(id, dados);
    }

    @Transactional
    @DeleteMapping("inativar/{id}")
    public ResponseEntity<DadosEmpresaDetalhadaDTO> inativar(@PathVariable Long id){
        return service.inativar(id);
    }
}