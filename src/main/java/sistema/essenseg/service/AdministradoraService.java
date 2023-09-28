package sistema.essenseg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sistema.essenseg.DTO.DadosAdministradoraDTO;
import sistema.essenseg.model.Administradora;
import sistema.essenseg.repository.AdministradoraRepository;

@Service
public class AdministradoraService {

    @Autowired
    AdministradoraRepository repository;

    public void cadastrarAdministradora(DadosAdministradoraDTO dados){
        Administradora administradora = new Administradora(dados);
        repository.save(administradora);
    }

}
