package sistema.essenseg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sistema.essenseg.dto.segurado.DadosListagemSegurado;
import sistema.essenseg.dto.segurado.FiltrosSeguradoDTO;
import sistema.essenseg.repository.SeguradoRepository;

@Service
public class SeguradoService {

    @Autowired
    SeguradoRepository repository;

    public Page<DadosListagemSegurado> listar(Pageable page){
        return repository.findAll(page).map(DadosListagemSegurado::new);
    }

    public Page<DadosListagemSegurado> listarFiltrados(FiltrosSeguradoDTO filtros, Pageable page) {
        return repository.findAll(filtros, page).map(DadosListagemSegurado::new);
    }
}
