package sistema.essenseg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sistema.essenseg.dto.segurado.DadosListagemSegurado;
import sistema.essenseg.dto.segurado.FiltrosSeguradoDTO;
import sistema.essenseg.repository.SeguradoRepository;

@Service
public class SeguradoService {

    @Autowired
    SeguradoRepository repository;

    public ResponseEntity<Page<DadosListagemSegurado>> listar(Pageable page){
        return ResponseEntity.ok().body(repository.findAll(page).map(DadosListagemSegurado::new));
    }

    public ResponseEntity<Page<DadosListagemSegurado>> listarFiltrados(FiltrosSeguradoDTO filtros, Pageable page) {
        return ResponseEntity.ok(repository.findAll(filtros, page).map(DadosListagemSegurado::new));
    }
}
