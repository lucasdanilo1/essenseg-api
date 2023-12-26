package sistema.essenseg.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sistema.essenseg.model.exception.*;
import sistema.essenseg.model.segurado.Segurado;
import sistema.essenseg.repository.AdministradoraRepository;
import sistema.essenseg.repository.CorretorRepository;
import sistema.essenseg.repository.OperadoraRepository;
import sistema.essenseg.repository.PlanoRepository;

@Service
public class SeguradoServiceUtil {

    @Autowired
    OperadoraRepository operadoraRepository;

    @Autowired
    AdministradoraRepository administradoraRepository;

    @Autowired
    CorretorRepository corretorRepository;

    @Autowired
    PlanoRepository planoRepository;

    public void defineOperadoraPorId(Segurado segurado, Long id) {
        var operadora = operadoraRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Operadora não encontrada"));
        segurado.getDadosContratacaoSegurado().setOperadora(operadora);
    }

    public void defineAdministradoraPorId(Segurado segurado, Long id){
        var administradora = administradoraRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Administradora não encontrada"));
        segurado.getDadosContratacaoSegurado().setAdministradora(administradora);
    }

    public void definePlanoPorId(Segurado segurado, Long id){
        var plano = planoRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Plano não encontrado"));
        segurado.getDadosContratacaoSegurado().setPlano(plano);
    }

    public void defineCorretorPorId(Segurado segurado, Long id){
        var corretor = corretorRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Corretor não encontrado"));
        corretor.getSegurados().add(segurado);
        segurado.getDadosContratacaoSegurado().setCorretor(corretor);
    }
}
