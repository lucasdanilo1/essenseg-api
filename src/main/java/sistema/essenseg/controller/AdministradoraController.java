package sistema.essenseg.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sistema.essenseg.dto.administradora.DadosAdministradoraDTO;
import sistema.essenseg.service.AdministradoraService;

@RestController
@RequestMapping("administradora")
public class AdministradoraController {

    @Autowired
    AdministradoraService service;

    @GetMapping("cadastro")
    public ResponseEntity<?> formulario() {
        return ResponseEntity.ok().build();
    }

    @Transactional
    @PostMapping("cadastro/save")
    public ResponseEntity<String> cadastro(@Valid @RequestBody DadosAdministradoraDTO dados) {
        return service.cadastrar(dados);
    }

}