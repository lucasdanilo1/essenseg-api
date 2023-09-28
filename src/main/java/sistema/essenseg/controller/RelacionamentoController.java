package sistema.essenseg.controller;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sistema.essenseg.DTO.DadosAssociacaoDTO;
import sistema.essenseg.service.RelacionamentoService;

@Controller
@RequestMapping("relacionar")
public class RelacionamentoController {

    @Autowired
    RelacionamentoService service;

    @GetMapping("cadastro")
    public String formulario(DadosAssociacaoDTO dados, Model model){
        System.out.println();
        service.carregarOperadorasEAdministradoras(model);
        return "formularioAssociacao";
    }

    @PostMapping("cadastro/save")
    @Transactional
    public String cadastro(DadosAssociacaoDTO dados){
        service.relacionar(dados);
        return "redirect:/relacionar/cadastro";
    }



}
