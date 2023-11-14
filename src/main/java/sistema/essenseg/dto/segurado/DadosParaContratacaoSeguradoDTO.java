package sistema.essenseg.dto.segurado;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import sistema.essenseg.model.Segurado.Segmentacao;

import java.math.BigDecimal;

public record DadosParaContratacaoSeguradoDTO(

        @NotNull
        Long operadoraId,

        @NotNull
        Long administradoraId,

        @NotBlank
        String vigencia,

        @NotNull
        BigDecimal plano,

        @NotNull
        BigDecimal adesao,

        @NotNull
        Segmentacao segmentacao

) {

}
