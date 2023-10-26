package sistema.essenseg.dto.clienteDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;

public record DadosPessoaisClienteDTO(

        @NotBlank
        String nome,

        @CPF
        @NotNull
        String cpf,

        String nomeResponsavel,

        @CPF
        String cpfResponsavel,

        @NotBlank
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
        String cep,

        BigDecimal peso,

        BigDecimal altura

) {
}
