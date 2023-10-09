package sistema.essenseg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import sistema.essenseg.dto.operadoraDTO.DadosOperadoraDTO;
import sistema.essenseg.dto.operadoraDTO.FiltrosOperadorasDTO;
import sistema.essenseg.model.Operadora;
import sistema.essenseg.repository.OperadoraRepository;

import java.util.List;

@Service
public class OperadoraService {

    @Autowired
    OperadoraRepository repository;

    public ModelAndView operadoras() {
        ModelAndView mv = new ModelAndView();
        List<Operadora> operadoras = repository.findAll();
        mv.addObject("operadoras", operadoras);
        return mv;
    }

    public ModelAndView cadastrar(DadosOperadoraDTO dados) {
        Operadora operadora = new Operadora(dados);
        repository.save(operadora);
        return new ModelAndView("redirect:/listagem/operadoras");
    }

    public ModelAndView operadorasFiltradas(FiltrosOperadorasDTO filtros) {
        return new ModelAndView();
    }
}