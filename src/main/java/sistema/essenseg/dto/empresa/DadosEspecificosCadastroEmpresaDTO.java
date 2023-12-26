package sistema.essenseg.dto.empresa;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;

import java.time.LocalDate;

public record DadosEspecificosCadastroEmpresaDTO(

        String razaoSocial,

        String nomeFantasia,

        @CNPJ
        @NotBlank
        String cnpj,

        String atvEconomica,

        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataAbertura

) {
}
