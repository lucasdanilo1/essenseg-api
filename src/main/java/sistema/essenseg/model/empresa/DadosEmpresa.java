package sistema.essenseg.model.empresa;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema.essenseg.dto.empresaDTO.DadosEmpresaDTO;
import sistema.essenseg.util.DataUtil;

import java.math.BigDecimal;
import java.time.LocalDate;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class DadosEmpresa {

    private String razaoSocial;

    private String nomeFantasia;

    private String cnpj;

    private String responsavel;

    private String telefone;

    private String email;

    private LocalDate vigencia;

    private String plano;

    @Column(precision = 10, scale = 2)
    private BigDecimal valorPlano;

    public DadosEmpresa(DadosEmpresaDTO dados) {
        this.razaoSocial = dados.razaoSocial();
        this.cnpj = dados.cnpj();
        this.responsavel = dados.responsavelEmpresa();
        this.telefone = dados.telefone();
        this.email = dados.email();
        this.vigencia = DataUtil.converterData(dados.vigencia());
        this.plano = dados.plano();
        this.valorPlano = dados.valorPlano();
    }
}
