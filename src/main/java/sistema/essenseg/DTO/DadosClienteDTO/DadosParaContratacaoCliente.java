package sistema.essenseg.DTO.DadosClienteDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import sistema.essenseg.model.enums.Segmentacao;

import java.math.BigDecimal;

@Setter
@Getter
public class DadosParaContratacaoCliente {

        @NotBlank
        String vigencia;

        @NotNull
        BigDecimal plano;

        @NotNull
        BigDecimal adesao;

        @NotNull
        Long administradoraId;

        @NotNull
        Long operadoraId;

        @NotNull
        Segmentacao segmentacao;

}
