package sistema.essenseg.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import sistema.essenseg.dto.empresaDTO.DadosEmpresaDTO;
import sistema.essenseg.dto.empresaDTO.DadosEmpresaDetalhada;
import sistema.essenseg.dto.empresaDTO.DadosListagemEmpresa;
import sistema.essenseg.model.empresa.Empresa;
import sistema.essenseg.repository.EmpresaRepository;

@Service
public class EmpresaService {

    @Autowired
    EmpresaRepository repository;

    @Transactional
    public ResponseEntity<DadosEmpresaDetalhada> cadastrar(DadosEmpresaDTO dados, UriComponentsBuilder uriBuilder) {

        var empresa = new Empresa(dados);

        repository.save(empresa);
        var uri = uriBuilder.path("empresa/{id}").buildAndExpand(empresa.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosEmpresaDetalhada(empresa));
    }

    public ResponseEntity<Page<DadosListagemEmpresa>> listar(Pageable page){
        return ResponseEntity.ok().body(repository.findAll(page).map(DadosListagemEmpresa::new));
    }
}
