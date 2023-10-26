package sistema.essenseg.dto.clienteDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import sistema.essenseg.model.cliente.Segmentacao;

import java.math.BigDecimal;

public record DadosParaContratacaoClienteDTO(

        @NotBlank
        String vigencia,

        @NotNull
        BigDecimal plano,

        @NotNull
        BigDecimal adesao,

        @NotNull
        Long administradoraId,

        @NotNull
        Long operadoraId,

        @NotNull
        Segmentacao segmentacao

) {

}
