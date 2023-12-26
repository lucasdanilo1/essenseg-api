package sistema.essenseg.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sistema.essenseg.dto.dependente.DadosAtualizaDependenteDTO;
import sistema.essenseg.dto.dependente.DadosCadastroDependenteDTO;
import sistema.essenseg.model.exception.ObjectNotFoundException;
import sistema.essenseg.model.exception.SegmentacaoSeguradoInvalidaException;
import sistema.essenseg.model.dependente.Dependente;
import sistema.essenseg.model.segurado.Segmentacao;
import sistema.essenseg.model.segurado.Segurado;
import sistema.essenseg.repository.DependenteRepository;
import sistema.essenseg.repository.SeguradoRepository;

import java.util.List;

@Service
public class DependenteService {

    @Autowired
    DependenteRepository dependenteRepository;
    @Autowired
    SeguradoRepository seguradoRepository;

    public Dependente cadastrar(DadosCadastroDependenteDTO dados, Long seguradoId) {
        Segurado segurado = seguradoRepository.findById(seguradoId).orElseThrow(() -> new ObjectNotFoundException("Segurado não encontrado"));

        if(segurado.getDadosContratacaoSegurado().getSegmentacao() == Segmentacao.INDIVIDUAL){
            throw new SegmentacaoSeguradoInvalidaException();
        }

        Dependente dependente = new Dependente(dados);

        dependente.setSegurado(segurado);

        dependenteRepository.save(dependente);
        return dependente;
    }

    @Transactional
    public List<Dependente> listar(){
        return dependenteRepository.findAll();
    }

    public Dependente atualizar(Long id, DadosAtualizaDependenteDTO dados) {
        var dependente = dependenteRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Dependente não encontrado"));
        dependente.atualizarInformacoes(dados);
        return dependente;
    }
}
