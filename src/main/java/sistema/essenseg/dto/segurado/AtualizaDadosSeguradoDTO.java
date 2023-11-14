package sistema.essenseg.dto.segurado;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import sistema.essenseg.model.Segurado.Segmentacao;

import java.math.BigDecimal;

public record AtualizaDadosSeguradoDTO(

        Long operadoraId,

        Long administradoraId,

        String vigencia,

        BigDecimal plano,

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
