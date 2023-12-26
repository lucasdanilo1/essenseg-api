package sistema.essenseg.dto.segurado;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import sistema.essenseg.model.segurado.Segmentacao;

import java.math.BigDecimal;
import java.time.LocalDate;

public record AtualizaDadosSeguradoDTO(

        Long operadoraId,

        Long administradoraId,

        Long planoId,

        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate vigencia,

        BigDecimal valorDoPlano,

        BigDecimal percentualComissao,

        BigDecimal adesao,

        Segmentacao segmentacao,

        String nome,

        @Pattern(regexp = "\\d{10}")
        String telefone,

        @Pattern(regexp = "\\d{5}-\\d{3}")
        String cep,

        String endereco,

        @Email
        String email

) {
}
