package sistema.essenseg.model.report;

import java.math.BigDecimal;

public record ParametrosCliente(

        String nome,
        BigDecimal comissaoEmpresa,
        BigDecimal impostoDevido


) {
}
