package sistema.essenseg.dto.corretor;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroCorretorDTO(@NotBlank String nome, String email, String telefone) {
}
