package sistema.essenseg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sistema.essenseg.dto.operadora.DadosOperadoraDTO;
import sistema.essenseg.infra.Exception.NomeObjetoJaExistenteException;
import sistema.essenseg.model.Operadora;
import sistema.essenseg.repository.OperadoraRepository;

import java.util.List;

@Service
public class OperadoraService {

    @Autowired
    OperadoraRepository repository;

    public List<Operadora> listar() {
        return repository.findAll();
    }

    public Operadora cadastrar(DadosOperadoraDTO dados){

        if(repository.existsByNome(dados.nome())){
            throw new NomeObjetoJaExistenteException();
        }
            Operadora operadora = new Operadora(dados);
            repository.save(operadora);
            return operadora;
    }
}