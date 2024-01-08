package sistema.essenseg.dto.segurado;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record DadosPessoaisSeguradoDTO(

        @NotBlank
        String nome,

        LocalDate dataNascimento,

        @NotBlank
        String telefone,

        String endereco,

        @Email
        @NotBlank
        String email,

        @NotBlank
        String cep

) {
}
