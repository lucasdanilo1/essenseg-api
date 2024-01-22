package sistema.essenseg.dto.plano;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosPlanoDTO(

        @NotNull
        Long operadoraId,
        @NotBlank
        String nome

) {
}
