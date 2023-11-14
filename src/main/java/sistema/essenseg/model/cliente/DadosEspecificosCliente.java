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

        if (dados.cpf() != null) {
            this.cpf = dados.cpf();
        }
        if (dados.peso() != null) {
            this.peso = dados.peso();
        }
        if (dados.altura() != null) {
            this.altura = dados.altura();
        }

        if (dados.nomeResponsavel() != null) {
            this.nomeResponsavel = dados.nomeResponsavel();
        }

        if (dados.cpfResponsavel() != null) {
            this.cpfResponsavel = dados.cpfResponsavel();
        }
    }
}
