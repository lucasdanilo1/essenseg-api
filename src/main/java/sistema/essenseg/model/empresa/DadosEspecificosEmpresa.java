package sistema.essenseg.model.empresa;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema.essenseg.dto.empresa.AtualizaDadosEmpresaDTO;
import sistema.essenseg.dto.empresa.DadosCadastroEmpresaDTO;
import sistema.essenseg.util.DataUtil;

import java.time.LocalDate;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class DadosEspecificosEmpresa {

    private String razaoSocial;

    private String nomeFantasia;

    private String cnpj;

    private String atvEconomica;

    private LocalDate dataAbertura;

    public DadosEspecificosEmpresa(DadosCadastroEmpresaDTO dados) {
        this.razaoSocial = dados.dadosEspecificosCadastroEmpresaDTO().razaoSocial();
        this.cnpj = dados.dadosEspecificosCadastroEmpresaDTO().cnpj();
        this.nomeFantasia = dados.dadosEspecificosCadastroEmpresaDTO().nomeFantasia();
        this.atvEconomica = dados.dadosEspecificosCadastroEmpresaDTO().atvEconomica();
        this.dataAbertura = DataUtil.converterData(dados.dadosEspecificosCadastroEmpresaDTO().dataAbertura());
    }

    public void checaCamposEAtualiza(AtualizaDadosEmpresaDTO dados) {

        if (dados.razaoSocial() != null) {
            this.razaoSocial = dados.razaoSocial();
        }

        if (dados.cnpj() != null) {
            this.cnpj = dados.cnpj();
        }
        if (dados.nomeFantasia() != null) {
            this.nomeFantasia = dados.nomeFantasia();
        }

        if (dados.atvEconomica() != null) {
            this.atvEconomica = dados.atvEconomica();
        }

        if (dados.dataAbertura() != null) {
            this.dataAbertura = DataUtil.converterData(dados.dataAbertura());
        }
    }

}
