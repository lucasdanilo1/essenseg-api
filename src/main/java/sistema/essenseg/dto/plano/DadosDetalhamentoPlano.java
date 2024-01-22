package sistema.essenseg.dto.plano;

import sistema.essenseg.model.Plano;

public record DadosDetalhamentoPlano(

        Long id,

        String nome,

        String nomeOperadora
        ) {

    public DadosDetalhamentoPlano(Plano plano){
        this(plano.getId(), plano.getNome(), plano.getOperadora().getNome());
    }
}
