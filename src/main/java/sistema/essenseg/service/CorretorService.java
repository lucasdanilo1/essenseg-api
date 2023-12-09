package sistema.essenseg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import sistema.essenseg.dto.corretor.DadosAtualizaCorretorDTO;
import sistema.essenseg.dto.corretor.DadosCadastroCorretorDTO;
import sistema.essenseg.dto.corretor.DadosCorretorDetalhadoDTO;
import sistema.essenseg.infra.Exception.NomeObjetoJaExistenteException;
import sistema.essenseg.model.Corretor;
import sistema.essenseg.repository.CorretorRepository;

import java.util.List;

@Service
public class CorretorService {

    @Autowired
    private CorretorRepository repository;

    public DadosCorretorDetalhadoDTO cadastrar(DadosCadastroCorretorDTO dados) {

        if(repository.existsByNome(dados.nome())){
            throw new NomeObjetoJaExistenteException();
        }

        Corretor corretor = new Corretor(dados);
        repository.save(corretor);
        return new DadosCorretorDetalhadoDTO(corretor);
    }

    public List<Corretor> listar() {
        return repository.findAll();
    }

    public DadosCorretorDetalhadoDTO atualizar(@PathVariable Long id, DadosAtualizaCorretorDTO dados){

        var corretor = repository.getReferenceById(id);
        corretor.atualizaInformacoes(dados);
        return new DadosCorretorDetalhadoDTO(corretor);
    }
}
