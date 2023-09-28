package sistema.essenseg.controller;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sistema.essenseg.DTO.DadosAdministradoraDTO;
import sistema.essenseg.service.AdministradoraService;

@Controller
@RequestMapping("administradoras")
public class AdministradoraController {

    @Autowired
    AdministradoraService service;

    @GetMapping("cadastro")
    public String formulario(DadosAdministradoraDTO dados){
        return "formularioAdministradora";
    }

    @Transactional
    @PostMapping("cadastro/save")
    public String cadastro(DadosAdministradoraDTO dados){
        service.cadastrarAdministradora(dados);
        return "redirect:/administradoras/cadastro";
    }

}
