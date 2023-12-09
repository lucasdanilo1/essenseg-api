package sistema.essenseg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sistema.essenseg.model.segurado.Segurado;
import sistema.essenseg.repository.SeguradoRepository;
import sistema.essenseg.service.SeguradoService;

@Controller
@RequestMapping("")
public class GeneratorController {

    @Autowired
    SeguradoRepository seguradoRepository;
    @Autowired
    SeguradoService seguradoService;

    @GetMapping("{id}")
    public void gerarBoletoPdf(@RequestParam Long id){

        Segurado segurado = seguradoRepository.getReferenceById(id);

        seguradoService.gerarBoletoPdf(segurado);

    }

}
