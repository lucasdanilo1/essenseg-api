package sistema.essenseg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import sistema.essenseg.dto.corretor.DadosAtualizaCorretorDTO;
import sistema.essenseg.dto.corretor.DadosCadastroCorretorDTO;
import sistema.essenseg.dto.corretor.DadosCorretorDetalhadoDTO;
import sistema.essenseg.model.Corretor;
import sistema.essenseg.repository.CorretorRepository;

import java.net.URI;
import java.util.List;

@Service
public class CorretorService {

    @Autowired
    private CorretorRepository repository;

    public ResponseEntity<DadosCorretorDetalhadoDTO> cadastrar(DadosCadastroCorretorDTO dados) {
        Corretor corretor = new Corretor(dados);
        repository.save(corretor);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .replacePath("listagem/corretores")
                .build().toUri();
        return ResponseEntity.created(location).body(new DadosCorretorDetalhadoDTO(corretor));
    }

    public ResponseEntity<List<Corretor>> listar() {
        var corretores = repository.findAll();
        return ResponseEntity.ok().body(corretores);
    }

    public ResponseEntity<DadosCorretorDetalhadoDTO> atualizar(@PathVariable Long id, DadosAtualizaCorretorDTO dados){
        var corretor = repository.getReferenceById(id);
        corretor.atualizaInformacoes(dados);
        return ResponseEntity.ok().body(new DadosCorretorDetalhadoDTO(corretor));
    }
}
