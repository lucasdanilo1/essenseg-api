package sistema.essenseg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import sistema.essenseg.dto.relacionamento.DadosRelacionamentoDTO;
import sistema.essenseg.model.Administradora;
import sistema.essenseg.model.Operadora;
import sistema.essenseg.model.OperadoraAdministradora;
import sistema.essenseg.repository.AdministradoraRepository;
import sistema.essenseg.repository.OperadoraRepository;
import sistema.essenseg.repository.OperadorasAdministradorasRepository;

import java.util.List;

@Service
public class RelacionamentoService {

    @Autowired
    OperadoraRepository operadoraRepository;
    @Autowired
    AdministradoraRepository administradoraRepository;
    @Autowired
    OperadorasAdministradorasRepository operadorasAdministradorasRepository;

    public ModelAndView relacionar(DadosRelacionamentoDTO dados){

        Administradora administradora = administradoraRepository.getReferenceById(dados.administradoraId());
        Operadora operadora = operadoraRepository.getReferenceById(dados.operadoraId());

        OperadoraAdministradora operadorasAdministradoras = new OperadoraAdministradora(administradora, operadora);

        operadorasAdministradorasRepository.save(operadorasAdministradoras);

        return new ModelAndView("redirect:/relacionar/cadastro");
    }

    public ModelAndView carregarOperadorasEAdministradoras(){
        ModelAndView mv = new ModelAndView("formularioAssociacao");

        List<Operadora> operadoras = operadoraRepository.findAll();
        List<Administradora> administradoras = administradoraRepository.findAll();
        mv.addObject("operadoras", operadoras);
        mv.addObject("administradoras", administradoras);

        return mv;
    }

}
