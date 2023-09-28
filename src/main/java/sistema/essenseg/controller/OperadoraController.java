package sistema.essenseg.controller;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sistema.essenseg.DTO.DadosOperadoraDTO;
import sistema.essenseg.service.OperadoraService;


@Controller
@RequestMapping("operadoras")
public class OperadoraController {

    @Autowired
    OperadoraService service;

    @GetMapping("cadastro")
    public String formPlano(DadosOperadoraDTO dados){
        return "formularioPlano";
    }

    @Transactional
    @PostMapping("cadastro/save")
    public String cadastrarOperadora(DadosOperadoraDTO dados){
        service.cadastrarOperadora(dados);
        return "redirect:/operadoras/cadastro";
    }

}
