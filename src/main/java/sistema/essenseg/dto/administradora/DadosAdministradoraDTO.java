package sistema.essenseg.dto.administradora;

import jakarta.validation.constraints.NotBlank;

public record DadosAdministradoraDTO(
        @NotBlank String nome
) {
}



