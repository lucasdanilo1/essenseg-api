package sistema.essenseg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import sistema.essenseg.DTO.DadosAssociacaoDTO;
import sistema.essenseg.model.Administradora;
import sistema.essenseg.model.OperadoraAdministradora;
import sistema.essenseg.model.Operadora;
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

    public void relacionar(DadosAssociacaoDTO dados){
        Administradora administradora = administradoraRepository.findById(dados.administradoraId()).orElseThrow(() -> new RuntimeException("Administradora não encontrada"));
        Operadora operadora = operadoraRepository.findById(dados.operadoraId()).orElseThrow(() -> new RuntimeException("Operadora não encontrada"));

        OperadoraAdministradora operadorasAdministradoras = new OperadoraAdministradora(administradora, operadora);

        operadorasAdministradorasRepository.save(operadorasAdministradoras);
    }

    public void carregarOperadorasEAdministradoras(Model model){
        List<Operadora> operadoras = operadoraRepository.findAll();
        List<Administradora> administradoras = administradoraRepository.findAll();
        model.addAttribute("operadoras", operadoras);
        model.addAttribute("administradoras", administradoras);
    }

}
