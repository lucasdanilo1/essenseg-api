package sistema.essenseg.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sistema.essenseg.dto.segurado.AtualizaDadosSeguradoDTO;
import sistema.essenseg.model.Segurado.Segurado;
import sistema.essenseg.repository.AdministradoraRepository;
import sistema.essenseg.repository.CorretorRepository;
import sistema.essenseg.repository.OperadoraRepository;

@Service
public class SeguradoServiceUtil {

    @Autowired
    OperadoraRepository operadoraRepository;

    @Autowired
    AdministradoraRepository administradoraRepository;

    @Autowired
    CorretorRepository corretorRepository;

    public void defineOperadora(Segurado segurado, Long id){
        var operadora = operadoraRepository.getReferenceById(id);
        segurado.getDadosContratacaoSegurado().setOperadora(operadora);
    }

    public void defineAdministradora(Segurado segurado, Long id){
        var administradora = administradoraRepository.getReferenceById(id);
        segurado.getDadosContratacaoSegurado().setAdministradora(administradora);
    }

    public void defineCorretor(Segurado segurado, Long id){
        var corretor = corretorRepository.getReferenceById(id);
        segurado.getDadosContratacaoSegurado().setCorretor(corretor);
    }

    public void atualizaOperadoraOuAdministradora(Segurado segurado, AtualizaDadosSeguradoDTO dados) {
        if(dados != null){
            if(dados.operadoraId() != null){
                var operadora = operadoraRepository.getReferenceById(dados.operadoraId());
                segurado.getDadosContratacaoSegurado().setOperadora(operadora);
            } else if (dados.administradoraId() != null) {
                var administradora = administradoraRepository.getReferenceById(dados.administradoraId());
                segurado.getDadosContratacaoSegurado().setAdministradora(administradora);
            }
        }

    }
}
