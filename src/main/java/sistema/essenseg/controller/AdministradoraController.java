package sistema.essenseg.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import sistema.essenseg.dto.administradora.DadosAdministradoraDTO;
import sistema.essenseg.dto.administradora.DadosListagemAdministradoraDTO;
import sistema.essenseg.service.AdministradoraService;

import java.util.List;

@RestController
@RequestMapping("administradora")
public class AdministradoraController {

    @Autowired
    AdministradoraService service;

    @Transactional
    @PostMapping("cadastro/save")
    public ResponseEntity<String> cadastro(@Valid @RequestBody DadosAdministradoraDTO dados) {
        return ResponseEntity.created(
                ServletUriComponentsBuilder.fromCurrentRequest()
                        .replacePath("listagem/administradoras")
                        .build().toUri()
        ).body(service.cadastrar(dados).getNome());
    }

    @GetMapping("lista")
    public ResponseEntity<List<DadosListagemAdministradoraDTO>> administradoras() {
        return ResponseEntity.ok().body(service.listar());
    }



}