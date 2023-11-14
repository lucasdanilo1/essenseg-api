package sistema.essenseg.dto.cliente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;

public record DadosEspecificosCadastroClienteDTO(

        @CPF
        @NotNull
        String cpf,

        String nomeResponsavel,

        @CPF
        String cpfResponsavel,

        @NotBlank
        String dataNascimento,

        BigDecimal peso,

        BigDecimal altura

        ) {
}
