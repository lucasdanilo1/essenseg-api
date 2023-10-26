package sistema.essenseg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import sistema.essenseg.dto.corretorDTO.DadosAtualizaCorretor;
import sistema.essenseg.dto.corretorDTO.DadosCorretorDTO;
import sistema.essenseg.dto.corretorDTO.DadosCorretorDetalhado;
import sistema.essenseg.model.Corretor;
import sistema.essenseg.repository.CorretorRepository;

import java.net.URI;
import java.util.List;

@Service
public class CorretorService {

    @Autowired
    private CorretorRepository repository;

    public ResponseEntity<DadosCorretorDetalhado> cadastrar(DadosCorretorDTO dados) {
        Corretor corretor = new Corretor(dados);
        repository.save(corretor);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .replacePath("listagem/corretores")
                .build().toUri();
        return ResponseEntity.created(location).body(new DadosCorretorDetalhado(corretor));
    }

    public ResponseEntity<List<Corretor>> listar() {
        var corretores = repository.findAll();
        return ResponseEntity.ok().body(corretores);
    }

    public ResponseEntity<DadosCorretorDetalhado> atualizar(@PathVariable Long id, DadosAtualizaCorretor dados){
        var corretor = repository.getReferenceById(id);
        corretor.atualizaInformacoes(dados);
        return ResponseEntity.ok().body(new DadosCorretorDetalhado(corretor));
    }
}
