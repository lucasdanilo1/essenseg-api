package sistema.essenseg.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import sistema.essenseg.dto.corretor.DadosAtualizaCorretorDTO;
import sistema.essenseg.dto.corretor.DadosCadastroCorretorDTO;
import sistema.essenseg.dto.corretor.DadosCorretorDetalhadoDTO;
import sistema.essenseg.model.Corretor;
import sistema.essenseg.service.CorretorService;

import java.util.List;

@RestController
@RequestMapping("corretor")
public class CorretorController {

    @Autowired
    CorretorService service;

    @Transactional
    @PostMapping("cadastro/save")
    public ResponseEntity<DadosCorretorDetalhadoDTO> cadastro(@Valid @RequestBody DadosCadastroCorretorDTO dados){
        return ResponseEntity.created(
                ServletUriComponentsBuilder.fromCurrentRequest()
                        .replacePath("listagem/corretores")
                        .build().toUri()
        ).body(service.cadastrar(dados));
    }

    @GetMapping("lista")
    public ResponseEntity<List<Corretor>> corretores() {
        return ResponseEntity.ok().body(service.listar());
    }


    @Transactional
    @PutMapping("{id}/update")
    public ResponseEntity<DadosCorretorDetalhadoDTO> atualizar(@PathVariable Long id, @RequestBody DadosAtualizaCorretorDTO dados){
        return ResponseEntity.ok().body(service.atualizar(id, dados));
    }

}
