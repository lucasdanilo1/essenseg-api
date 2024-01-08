package sistema.essenseg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import sistema.essenseg.dto.corretor.DadosAtualizaCorretorDTO;
import sistema.essenseg.dto.corretor.DadosCadastroCorretorDTO;
import sistema.essenseg.dto.corretor.DadosCorretorDetalhadoDTO;
import sistema.essenseg.dto.corretor.DadosListagemCorretor;
import sistema.essenseg.model.exception.ObjectNotFoundException;
import sistema.essenseg.model.Corretor;
import sistema.essenseg.repository.CorretorRepository;

import java.util.List;

@Service
public class CorretorService {

    @Autowired
    private CorretorRepository repository;

    public DadosCorretorDetalhadoDTO cadastrar(DadosCadastroCorretorDTO dados) {
        if(repository.existsByNome(dados.nome())){
            throw new DataIntegrityViolationException("Corretor já cadastrado");
        }
        Corretor corretor = new Corretor(dados);
        repository.save(corretor);
        return new DadosCorretorDetalhadoDTO(corretor);
    }

    public List<DadosListagemCorretor> listar() {
        return repository.findAll().stream().map(DadosListagemCorretor::new).toList();
    }

    public DadosCorretorDetalhadoDTO atualizar(@PathVariable Long id, DadosAtualizaCorretorDTO dados){
        var corretor = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Corretor não encontrado"));
        corretor.atualizaInformacoes(dados);
        return new DadosCorretorDetalhadoDTO(corretor);
    }
}
