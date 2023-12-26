package sistema.essenseg.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import sistema.essenseg.dto.plano.DadosDetalhamentoPlano;
import sistema.essenseg.dto.plano.DadosPlanoDTO;
import sistema.essenseg.service.PlanoService;

import java.util.List;

@RestController
@RequestMapping("plano")
public class PlanoController {

    @Autowired
    PlanoService service;

    @Transactional
    @PostMapping("cadastro/save")
    public ResponseEntity<DadosDetalhamentoPlano> cadastro(@Valid @RequestBody DadosPlanoDTO dados) {
        return ResponseEntity.created(
                ServletUriComponentsBuilder.fromCurrentRequest()
                        .replacePath("listagem/planos")
                        .build().toUri()
        ).body(service.cadastrar(dados));
    }

    @GetMapping("listagem/operadora/{id}")
    public ResponseEntity<List<DadosDetalhamentoPlano>> planosDaOperadora(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.listaDePlanosPorOperadora(id));
    }

    @GetMapping("{id}")
    public ResponseEntity<DadosDetalhamentoPlano> plano(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.plano(id));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deletarPlano(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.ok().build();
    }


}