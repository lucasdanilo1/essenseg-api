package sistema.essenseg.controller;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sistema.essenseg.dto.dependente.DadosAtualizaDependenteDTO;
import sistema.essenseg.dto.dependente.DadosCadastroDependenteDTO;
import sistema.essenseg.model.dependente.Dependente;
import sistema.essenseg.service.DependenteService;

import java.util.List;

@RestController
@RequestMapping("dependente")
public class DependenteController {

    @Autowired
    DependenteService service;

    @Transactional
    @PostMapping("/segurado/{seguradoId}/addDependente")
    public ResponseEntity<?> cadastroDepentente(@RequestBody DadosCadastroDependenteDTO dados, @PathVariable Long seguradoId){
        return ResponseEntity.ok().body(service.cadastrar(dados, seguradoId));
    }

    @GetMapping("lista")
    public ResponseEntity<List<Dependente>> dependentes(){
        return ResponseEntity.ok().body(service.listar());
    }

    @Transactional
    @PutMapping("{id}/update")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody DadosAtualizaDependenteDTO dados) {
        return ResponseEntity.ok().body(service.atualizar(id, dados));
    }

}
