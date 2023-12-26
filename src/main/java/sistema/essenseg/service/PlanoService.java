package sistema.essenseg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import sistema.essenseg.dto.plano.DadosDetalhamentoPlano;
import sistema.essenseg.dto.plano.DadosPlanoDTO;
import sistema.essenseg.model.Plano;
import sistema.essenseg.model.exception.ObjectNotFoundException;
import sistema.essenseg.repository.OperadoraRepository;
import sistema.essenseg.repository.PlanoRepository;

import java.util.List;

@Service
public class PlanoService {

    @Autowired
    PlanoRepository planoRepository;
    @Autowired
    OperadoraRepository operadoraRepository;

    public DadosDetalhamentoPlano cadastrar(DadosPlanoDTO dados){
        if(planoRepository.existsByNome(dados.nome())){
            throw new DataIntegrityViolationException("Plano já cadastrado");
        }
        Plano plano = new Plano(dados);
        plano.setOperadora(operadoraRepository.findById(dados.operadoraId()).orElseThrow(() -> new ObjectNotFoundException("Operadora não encontrada")));
        planoRepository.save(plano);
        return new DadosDetalhamentoPlano(plano);
    }

    public List<DadosDetalhamentoPlano> listaDePlanosPorOperadora(Long id){
        return planoRepository.findAllByOperadoraId(id).stream().map(DadosDetalhamentoPlano::new).toList();
    }

    public DadosDetalhamentoPlano plano(Long id) {
        return new DadosDetalhamentoPlano(planoRepository.getReferenceById(id));
    }

    public void deletar(Long id) {
        try{
            planoRepository.delete(planoRepository.getReferenceById(id));
        }catch (DataIntegrityViolationException ex){
            throw new DataIntegrityViolationException("Não é possível deletar o plano pois tem clientes associados");
        }
    }
}
