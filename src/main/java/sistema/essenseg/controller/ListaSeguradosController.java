package sistema.essenseg.controller;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sistema.essenseg.dto.segurado.DadosListagemSegurado;
import sistema.essenseg.dto.segurado.FiltrosSeguradoDTO;
import sistema.essenseg.model.segurado.Segurado;
import sistema.essenseg.repository.SeguradoRepository;
import sistema.essenseg.service.SeguradoService;

@RestController
@RequestMapping("listagem")
public class ListaSeguradosController {

    SeguradoService service;

    @Transactional
    @GetMapping("segurados")
    public ResponseEntity<Page<DadosListagemSegurado>> segurados(Pageable page) {
        return ResponseEntity.ok().body(service.listar(page));
    }

    @Transactional
    @PostMapping("segurados/filtrados")
    public ResponseEntity<Page<DadosListagemSegurado>> seguradosFiltrados(@RequestBody FiltrosSeguradoDTO filtros, Pageable page) {
        return ResponseEntity.ok().body(service.listarFiltrados(filtros, page));
    }
}
