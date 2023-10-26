package sistema.essenseg.dto.operadoraDTO;

import jakarta.validation.constraints.NotBlank;

public record DadosOperadoraDTO(

        @NotBlank
        String nome

) {
}
