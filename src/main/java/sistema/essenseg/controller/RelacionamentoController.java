package sistema.essenseg.controller;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sistema.essenseg.dto.relacionamento.DadosRelacionamentoDTO;
import sistema.essenseg.service.RelacionamentoService;

@Controller
@RequestMapping("relacionar")
public class RelacionamentoController {

    @Autowired
    RelacionamentoService service;

    @GetMapping("cadastro")
    public ModelAndView formulario(DadosRelacionamentoDTO dados){
        return service.carregarOperadorasEAdministradoras();
    }

    @PostMapping("cadastro/save")
    @Transactional
    public ModelAndView relacionar(DadosRelacionamentoDTO dados){
        return service.relacionar(dados);
    }

}
