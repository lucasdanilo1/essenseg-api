package sistema.essenseg.dto.report;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Valid
public record SeguradoSelecionado(

        @NotNull
        Long clienteId,
        @NotNull
        BigDecimal percentualComissaoEmpresa,
        @NotNull
        BigDecimal percentualImpostoDevido

) {
}


