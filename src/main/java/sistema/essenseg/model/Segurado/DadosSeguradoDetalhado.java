package sistema.essenseg.model.Segurado;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosSeguradoDetalhado(

        Long operadoraId,
        Long administradoraId,
        LocalDate vigencia,
        BigDecimal plano,
        BigDecimal adesao,
        Segmentacao segmentacao,
        String nome,
        String telefone,
        String cep,
        String endereco,
        String email

) {
    public DadosSeguradoDetalhado(DadosPessoaisSegurado dadosPessoaisSegurado, DadosContratacaoSegurado dadosContratacaoSegurado){
        this(dadosContratacaoSegurado.getOperadora().getId(),dadosContratacaoSegurado.getAdministradora().getId(),
                dadosContratacaoSegurado.getVigencia(), dadosContratacaoSegurado.getPlano(), dadosContratacaoSegurado.getAdesao(), dadosContratacaoSegurado.getSegmentacao(),
                dadosPessoaisSegurado.getNome(), dadosPessoaisSegurado.getTelefone(), dadosPessoaisSegurado.getCep(),
                dadosPessoaisSegurado.getEndereco(),
                dadosPessoaisSegurado.getEmail());
    }

}
