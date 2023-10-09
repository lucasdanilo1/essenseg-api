package sistema.essenseg.controller;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sistema.essenseg.dto.administradoraDTO.DadosAdministradoraDTO;
import sistema.essenseg.service.AdministradoraService;

@Controller
@RequestMapping("administradora")
public class AdministradoraController {

    @Autowired
    AdministradoraService service;

    @GetMapping("cadastro")
    public ModelAndView formulario(DadosAdministradoraDTO dados) {
        return new ModelAndView("formularioAdministradora");
    }

    @Transactional
    @PostMapping("cadastro/save")
    public ModelAndView cadastro(DadosAdministradoraDTO dados) {
        return service.cadastrarAdministradora(dados);
    }

}