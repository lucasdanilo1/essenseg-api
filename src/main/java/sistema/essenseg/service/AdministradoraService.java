package sistema.essenseg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import sistema.essenseg.dto.administradoraDTO.DadosAdministradoraDTO;
import sistema.essenseg.dto.administradoraDTO.FiltrosAdministradorasDTO;
import sistema.essenseg.model.Administradora;
import sistema.essenseg.repository.AdministradoraRepository;

import java.util.List;

@Service
public class AdministradoraService {

    @Autowired
    AdministradoraRepository repository;

    public ModelAndView administradoras(){
        ModelAndView mv = new ModelAndView();
        List<Administradora> administradoras = repository.findAll();
        mv.addObject("administradoras", administradoras);
        return mv;
    }

    public ModelAndView cadastrarAdministradora(DadosAdministradoraDTO dados){
        Administradora administradora = new Administradora(dados);
        repository.save(administradora);
        return new ModelAndView("redirect:/listagem/administradoras");
    }

    public ModelAndView administradorasFiltradas(FiltrosAdministradorasDTO filtros) {
        return new ModelAndView();
    }
}
