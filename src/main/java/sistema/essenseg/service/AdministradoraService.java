package sistema.essenseg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import sistema.essenseg.dto.administradora.DadosAdministradoraDTO;
import sistema.essenseg.infra.Exception.NomeObjetoJaExistenteException;
import sistema.essenseg.model.Administradora;
import sistema.essenseg.repository.AdministradoraRepository;

import java.net.URI;
import java.util.List;

@Service
public class AdministradoraService {

    @Autowired
    AdministradoraRepository repository;

    public ResponseEntity<List<Administradora>> listar(){
        List<Administradora> administradoras = repository.findAll();
        return ResponseEntity.ok().body(administradoras);
    }

    public ResponseEntity<String> cadastrar(DadosAdministradoraDTO dados){
        if(repository.existsByNome(dados.nome())){
            throw new NomeObjetoJaExistenteException();
        }

        Administradora administradora = new Administradora(dados);
        repository.save(administradora);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .replacePath("listagem/administradoras")
                .build().toUri();
        return ResponseEntity.created(location).body(administradora.getNome());
    }
}
