package sistema.essenseg.model.report;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
public class SeguradoParaDataSet {

    private String nomeCorretor;
    private String nomeSegurado;
    private Date vigencia;
    private String nomePlano;
    private String nomeOperadora;
    private String nomeAdm;
    private BigDecimal valorDoPlano;
    private BigDecimal percentualComissaoCorretor;
    private BigDecimal percentualComissaoEmpresa;
    private BigDecimal percentualImpostoDevido;

}
