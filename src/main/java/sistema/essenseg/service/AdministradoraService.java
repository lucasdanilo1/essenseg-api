package sistema.essenseg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import sistema.essenseg.dto.administradora.DadosAdministradoraDTO;
import sistema.essenseg.model.Administradora;
import sistema.essenseg.repository.AdministradoraRepository;

import java.util.List;

@Service
public class AdministradoraService {

    @Autowired
    AdministradoraRepository repository;

    public List<Administradora> listar(){
        return repository.findAll();
    }

    public Administradora cadastrar(DadosAdministradoraDTO dados){
        if(repository.existsByNome(dados.nome())){
            throw new DataIntegrityViolationException("Administradora já cadastrada");
        }

        Administradora administradora = new Administradora(dados);
        repository.save(administradora);
        return administradora;
    }
}
