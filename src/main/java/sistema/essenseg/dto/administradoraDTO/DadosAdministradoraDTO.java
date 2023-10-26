package sistema.essenseg.dto.administradoraDTO;

import jakarta.validation.constraints.NotBlank;

public record DadosAdministradoraDTO(
        @NotBlank String nome
) {
}



