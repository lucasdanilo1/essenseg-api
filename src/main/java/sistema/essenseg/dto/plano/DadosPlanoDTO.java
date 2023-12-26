package sistema.essenseg.dto.plano;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosPlanoDTO(

        @NotNull
        Long operadoraId,
        @NotBlank
        String nome,

        @DecimalMin(value = "1", message = "A comissão deve ser no mínimo 1")
        @Digits(integer = 2, fraction = 1, message = "A comissão deve ter no máximo 2 digitos inteiros e 1 fracional ex: 30,5")
        BigDecimal comissao

) {
}
