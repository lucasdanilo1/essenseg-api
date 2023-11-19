package sistema.essenseg.dto.segurado;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosPessoaisSeguradoDTO(

        @NotBlank
        String nome,

        String dataNascimento,

        @Pattern(regexp = "\\d{10}")
        @NotBlank
        String telefone,

        String endereco,

        @Email
        @NotBlank
        String email,

        @Pattern(regexp = "\\d{5}-\\d{3}")
        @NotBlank
        String cep

) {
}
