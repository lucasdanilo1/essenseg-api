package sistema.essenseg.controller;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sistema.essenseg.dto.administradora.DadosListagemAdministradoraDTO;
import sistema.essenseg.dto.relacionamento.DadosRelacionamentoDTO;
import sistema.essenseg.service.RelacionamentoService;

import java.util.List;

@Controller
@RequestMapping("relacao")
public class RelacionamentoController {

    @Autowired
    RelacionamentoService service;

    @PostMapping("administradora-operadora/cadastrar")
    @Transactional
    public ResponseEntity<?> relacionar(@RequestBody DadosRelacionamentoDTO dados){
        return service.relacionar(dados);
    }

    @GetMapping("/administradora/lista/operadora/{id}")
    @Transactional
    public ResponseEntity<List<DadosListagemAdministradoraDTO>> relacionar(@PathVariable Long id){
        return service.listaAdministradoraPorOperadoraId(id);
    }
}
