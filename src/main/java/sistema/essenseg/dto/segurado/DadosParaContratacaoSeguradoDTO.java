package sistema.essenseg.dto.segurado;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import sistema.essenseg.model.segurado.Segmentacao;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosParaContratacaoSeguradoDTO(

        @NotNull
        Long operadoraId,

        @NotNull
        Long administradoraId,

        @NotNull
        Long corretorId,

        @JsonFormat(pattern = "dd/MM/yyyy")
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
