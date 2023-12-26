package sistema.essenseg.dto.plano;

import sistema.essenseg.model.Plano;

import java.math.BigDecimal;

public record DadosDetalhamentoPlano(

        Long id,

        String nome,

        String nomeOperadora,
        
        BigDecimal comissao
) {

    public DadosDetalhamentoPlano(Plano plano){
        this(plano.getId(), plano.getNome(), plano.getOperadora().getNome(), plano.getComissao());
    }
}
