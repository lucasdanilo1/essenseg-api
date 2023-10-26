package sistema.essenseg.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sistema.essenseg.dto.corretorDTO.DadosAtualizaCorretor;
import sistema.essenseg.dto.corretorDTO.DadosCorretorDTO;
import sistema.essenseg.dto.corretorDTO.DadosCorretorDetalhado;
import sistema.essenseg.service.CorretorService;

@RestController
@RequestMapping("corretor")
public class CorretorController {

    @Autowired
    CorretorService service;

    @GetMapping("cadastro")
    public ResponseEntity<?> formulario(){
        return ResponseEntity.ok().build();
    }

    @Transactional
    @PostMapping("cadastro/save")
    public ResponseEntity<DadosCorretorDetalhado> cadastro(@Valid @RequestBody DadosCorretorDTO dados){
        return service.cadastrar(dados);
    }

    @Transactional
    @PutMapping("{id}/update")
    public ResponseEntity<DadosCorretorDetalhado> atualizar(@PathVariable Long id, @RequestBody DadosAtualizaCorretor dados){
        return service.atualizar(id, dados);
    }

}
