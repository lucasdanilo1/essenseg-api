package sistema.essenseg.dto.segurado;

import jakarta.validation.constraints.NotNull;
import sistema.essenseg.model.segurado.Segmentacao;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosParaContratacaoSeguradoDTO(

        @NotNull
        Long operadoraId,

        Long administradoraId,

        @NotNull
        Long corretorId,

        LocalDate vigencia,

        @NotNull
        Long planoId,

        @NotNull
        BigDecimal valorDoPlano,

        @NotNull
        BigDecimal percentualComissao,

        @NotNull
        BigDecimal adesao,

        Segmentacao segmentacao

) {

}
