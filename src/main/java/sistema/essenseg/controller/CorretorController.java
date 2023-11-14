package sistema.essenseg.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sistema.essenseg.dto.corretor.DadosAtualizaCorretorDTO;
import sistema.essenseg.dto.corretor.DadosCadastroCorretorDTO;
import sistema.essenseg.dto.corretor.DadosCorretorDetalhadoDTO;
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
    public ResponseEntity<DadosCorretorDetalhadoDTO> cadastro(@Valid @RequestBody DadosCadastroCorretorDTO dados){
        return service.cadastrar(dados);
    }

    @Transactional
    @PutMapping("{id}/update")
    public ResponseEntity<DadosCorretorDetalhadoDTO> atualizar(@PathVariable Long id, @RequestBody DadosAtualizaCorretorDTO dados){
        return service.atualizar(id, dados);
    }

}
