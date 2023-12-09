package sistema.essenseg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sistema.essenseg.dto.dependente.DadosAtualizaDependenteDTO;
import sistema.essenseg.dto.dependente.DadosCadastroDependenteDTO;
import sistema.essenseg.infra.Exception.SegmentacaoSeguradoInvalidaException;
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
        Segurado segurado = seguradoRepository.getReferenceById(seguradoId);

        if(segurado.getDadosContratacaoSegurado().getSegmentacao() == Segmentacao.INDIVIDUAL){
            throw new SegmentacaoSeguradoInvalidaException();
        }

        Dependente dependente = new Dependente(dados);

        dependente.setSegurado(segurado);
        segurado.getDependentes().add(dependente);

        dependenteRepository.save(dependente);
        return dependente;
    }

    public List<Dependente> listar(){
        return dependenteRepository.findAll();
    }

    public Dependente atualizar(Long id, DadosAtualizaDependenteDTO dados) {
        var dependente = dependenteRepository.getReferenceById(id);
        dependente.atualizarInformacoes(dados);
        return dependente;
    }
}
