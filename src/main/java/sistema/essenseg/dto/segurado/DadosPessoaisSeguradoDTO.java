package sistema.essenseg.dto.segurado;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record DadosPessoaisSeguradoDTO(

        @NotBlank
        String nome,

        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataNascimento,

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
