package sistema.essenseg.model.cliente;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sistema.essenseg.dto.cliente.AtualizaDadosClienteDTO;
import sistema.essenseg.dto.cliente.DadosCadastroClienteDTO;

import java.math.BigDecimal;

@Embeddable
@Getter
@NoArgsConstructor
public class DadosEspecificosCliente {

    @Column(unique = true)
    private String cpf;

    private String nomeResponsavel;

    @Column(unique = true)
    private String cpfResponsavel;

    private BigDecimal peso = new BigDecimal("0");

    private BigDecimal altura = new BigDecimal("0");

    public DadosEspecificosCliente(DadosCadastroClienteDTO dados){
        this.peso = dados.dadosEspecificosCadastroClienteDTO().peso();
        this.altura = dados.dadosEspecificosCadastroClienteDTO().altura();
        this.cpf = dados.dadosEspecificosCadastroClienteDTO().cpf();
        this.nomeResponsavel = dados.dadosEspecificosCadastroClienteDTO().nomeResponsavel();
        this.cpfResponsavel = dados.dadosEspecificosCadastroClienteDTO().cpfResponsavel();
    }

    public void checaCamposEAtualiza(AtualizaDadosClienteDTO dados) {
        if (dados.atualizaDadosEspecificosClienteDTO().peso() != null) {
            this.peso = dados.atualizaDadosEspecificosClienteDTO().peso();
        }
        if (dados.atualizaDadosEspecificosClienteDTO().altura() != null) {
            this.altura = dados.atualizaDadosEspecificosClienteDTO().altura();
        }

        if (dados.atualizaDadosEspecificosClienteDTO().nomeResponsavel() != null) {
            this.nomeResponsavel = dados.atualizaDadosEspecificosClienteDTO().nomeResponsavel();
        }
    }
}
