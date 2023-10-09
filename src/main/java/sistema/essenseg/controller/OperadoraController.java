package sistema.essenseg.controller;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sistema.essenseg.dto.operadoraDTO.DadosOperadoraDTO;
import sistema.essenseg.service.OperadoraService;

@Controller
@RequestMapping("operadora")
public class OperadoraController {

    @Autowired
    OperadoraService service;

    @GetMapping("cadastro")
    public ModelAndView formulario(DadosOperadoraDTO dados){
        return new ModelAndView("formularioPlano");
    }

    @Transactional
    @PostMapping("cadastro/save")
    public ModelAndView cadastro(DadosOperadoraDTO dados){
        return service.cadastrar(dados);
    }

}