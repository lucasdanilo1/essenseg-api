package sistema.essenseg.dto.operadora;

import jakarta.validation.constraints.NotBlank;

public record DadosOperadoraDTO(

        @NotBlank
        String nome

) {
}
