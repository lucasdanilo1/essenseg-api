package sistema.essenseg.dto.empresaDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CNPJ;

import java.math.BigDecimal;

public record DadosEmpresaDTO(

        @NotNull
        String razaoSocial,

        String nomeFantasia,

        @CNPJ
        @NotBlank
        String cnpj,

        @NotBlank
        String responsavelEmpresa,

        @Pattern(regexp = "\\d{10}")
        String telefone,

        @Email
        String email,

        String vigencia,

        String plano,

        BigDecimal valorPlano

) {
}
