package sistema.essenseg.model.cliente;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema.essenseg.dto.cliente.AtualizaDadosClienteDTO;
import sistema.essenseg.dto.cliente.DadosCadastroClienteDTO;

import java.math.BigDecimal;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class DadosEspecificosCliente {

    private String cpf;

    private String nomeResponsavel;

    private String cpfResponsavel;

    private BigDecimal peso;

    private BigDecimal altura;

    public DadosEspecificosCliente(DadosCadastroClienteDTO dados){
        this.peso = dados.dadosEspecificosCadastroClienteDTO().peso();
        this.altura = dados.dadosEspecificosCadastroClienteDTO().altura();
        this.cpf = dados.dadosEspecificosCadastroClienteDTO().cpf();
        this.nomeResponsavel = dados.dadosEspecificosCadastroClienteDTO().nomeResponsavel();
        this.cpfResponsavel = dados.dadosEspecificosCadastroClienteDTO().cpfResponsavel();
    }

    public void checaCamposEAtualiza(AtualizaDadosClienteDTO dados) {

        if (dados.atualizaDadosEspecificosClienteDTO().cpf() != null) {
            this.cpf = dados.atualizaDadosEspecificosClienteDTO().cpf();
        }
        if (dados.atualizaDadosEspecificosClienteDTO().peso() != null) {
            this.peso = dados.atualizaDadosEspecificosClienteDTO().peso();
        }
        if (dados.atualizaDadosEspecificosClienteDTO().altura() != null) {
            this.altura = dados.atualizaDadosEspecificosClienteDTO().altura();
        }

        if (dados.atualizaDadosEspecificosClienteDTO().nomeResponsavel() != null) {
            this.nomeResponsavel = dados.atualizaDadosEspecificosClienteDTO().nomeResponsavel();
        }

        if (dados.atualizaDadosEspecificosClienteDTO().cpfResponsavel() != null) {
            this.cpfResponsavel = dados.atualizaDadosEspecificosClienteDTO().cpfResponsavel();
        }
    }
}
