package sistema.essenseg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import sistema.essenseg.dto.operadora.DadosOperadoraDTO;
import sistema.essenseg.infra.Exception.NomeObjetoJaExistenteException;
import sistema.essenseg.model.Operadora;
import sistema.essenseg.repository.OperadoraRepository;

import java.net.URI;
import java.util.List;

@Service
public class OperadoraService {

    @Autowired
    OperadoraRepository repository;

    public ResponseEntity<List<Operadora>> listar() {
        List<Operadora> operadoras = repository.findAll();
        return ResponseEntity.ok().body(operadoras);
    }

    public ResponseEntity<String> cadastrar(DadosOperadoraDTO dados){

        if(repository.existsByNome(dados.nome())){
            throw new NomeObjetoJaExistenteException();
        }
            Operadora operadora = new Operadora(dados);
            repository.save(operadora);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .replacePath("listagem/operadoras")
                    .build().toUri();

        return ResponseEntity.created(location).body(operadora.getNome());
    }
}