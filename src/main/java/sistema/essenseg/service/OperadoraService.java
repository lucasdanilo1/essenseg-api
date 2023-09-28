package sistema.essenseg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sistema.essenseg.DTO.DadosOperadoraDTO;
import sistema.essenseg.model.Operadora;
import sistema.essenseg.repository.OperadoraRepository;

@Service
public class OperadoraService {

    @Autowired
    OperadoraRepository repository;

    public void cadastrarOperadora(DadosOperadoraDTO dados){
        Operadora operadora = new Operadora(dados);
        repository.save(operadora);
    }

}
