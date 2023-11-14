package sistema.essenseg.dto.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import sistema.essenseg.model.UsuarioRole;

public record DadosCadastroUsuario(@NotBlank String login, @NotBlank String senha, @NotNull UsuarioRole role) {
}
