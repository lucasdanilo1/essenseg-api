package sistema.essenseg.model.empresa;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sistema.essenseg.dto.empresa.AtualizaDadosEmpresaDTO;
import sistema.essenseg.dto.empresa.DadosCadastroEmpresaDTO;
import sistema.essenseg.util.DataUtil;

import java.time.LocalDate;

@Embeddable
@Getter
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

        if (dados.atualizaDadosEspecificosEmpresaDTO().razaoSocial() != null) {
            this.razaoSocial = dados.atualizaDadosEspecificosEmpresaDTO().razaoSocial();
        }
        if (dados.atualizaDadosEspecificosEmpresaDTO().nomeFantasia() != null) {
            this.nomeFantasia = dados.atualizaDadosEspecificosEmpresaDTO().nomeFantasia();
        }

        if (dados.atualizaDadosEspecificosEmpresaDTO().atvEconomica() != null) {
            this.atvEconomica = dados.atualizaDadosEspecificosEmpresaDTO().atvEconomica();
        }

        if (dados.atualizaDadosEspecificosEmpresaDTO().dataAbertura() != null) {
            this.dataAbertura = DataUtil.converterData(dados.atualizaDadosEspecificosEmpresaDTO().dataAbertura());
        }
    }

}
