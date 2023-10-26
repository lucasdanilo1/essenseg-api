package sistema.essenseg.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import sistema.essenseg.dto.empresaDTO.DadosEmpresaDTO;
import sistema.essenseg.dto.empresaDTO.DadosEmpresaDetalhada;
import sistema.essenseg.service.EmpresaService;

@RestController
@RequestMapping("empresa")
public class EmpresaController {

    @Autowired
    EmpresaService service;

    @GetMapping("cadastro")
    public ResponseEntity<?> formulario() {
        return ResponseEntity.ok().build();
    }

    @Transactional
    @PostMapping("cadastro/save")
    public ResponseEntity<DadosEmpresaDetalhada> cadastro(@Valid @RequestBody DadosEmpresaDTO dados, UriComponentsBuilder uriBuilder) {
        return service.cadastrar(dados, uriBuilder);
    }

}