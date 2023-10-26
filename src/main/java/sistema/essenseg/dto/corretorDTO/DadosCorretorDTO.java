package sistema.essenseg.dto.corretorDTO;

import jakarta.validation.constraints.NotBlank;

public record DadosCorretorDTO(@NotBlank String nome, String email, String telefone) {
}
