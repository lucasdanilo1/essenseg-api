package sistema.essenseg.model.cliente;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema.essenseg.dto.clienteDTO.DadosAtualizaClienteDTO;
import sistema.essenseg.dto.clienteDTO.DadosClienteDTO;
import sistema.essenseg.util.DataUtil;

import java.math.BigDecimal;
import java.time.LocalDate;


@Embeddable
@NoArgsConstructor
@Getter
@Setter
public class DadosPessoais {

    private String nome;

    private String cpf;

    private String nomeResponsavel;

    private String cpfResponsavel;

    private LocalDate dataNascimento;

    private String telefone;

    private String cep;

    private String endereco;

    private String email;

    private BigDecimal peso;

    private BigDecimal altura;


    public DadosPessoais(DadosClienteDTO dados){

        this.nome = dados.dadosPessoaisClienteDTO().nome();
        this.cpf = dados.dadosPessoaisClienteDTO().cpf();
        this.nomeResponsavel = dados.dadosPessoaisClienteDTO().nomeResponsavel();
        this.cpfResponsavel = dados.dadosPessoaisClienteDTO().cpfResponsavel();
        this.dataNascimento = DataUtil.converterData(dados.dadosPessoaisClienteDTO().dataNascimento());
        this.telefone = dados.dadosPessoaisClienteDTO().telefone();
        this.cep = dados.dadosPessoaisClienteDTO().cep();
        this.endereco = dados.dadosPessoaisClienteDTO().endereco();
        this.email = dados.dadosPessoaisClienteDTO().email();
        this.peso = dados.dadosPessoaisClienteDTO().peso();
        this.altura = dados.dadosPessoaisClienteDTO().altura();

    }

    public void checaCamposEAtualiza(DadosAtualizaClienteDTO dados) {

        if (!dados.getDadosPessoaisClienteDTO().nome().isEmpty()) {
            this.nome = dados.getDadosPessoaisClienteDTO().nome();
        }

        if (!dados.getDadosPessoaisClienteDTO().cpf().isEmpty()) {
            this.cpf = dados.getDadosPessoaisClienteDTO().cpf();
        }

        if (!dados.getDadosPessoaisClienteDTO().nomeResponsavel().isEmpty()) {
            this.nomeResponsavel = dados.getDadosPessoaisClienteDTO().nomeResponsavel();
        }

        if (!dados.getDadosPessoaisClienteDTO().cpfResponsavel().isEmpty()) {
            this.cpfResponsavel = dados.getDadosPessoaisClienteDTO().cpfResponsavel();
        }

        if (dados.getDadosPessoaisClienteDTO().dataNascimento() != null) {
            this.dataNascimento = DataUtil.converterData(dados.getDadosPessoaisClienteDTO().dataNascimento());
        }

        if (!dados.getDadosPessoaisClienteDTO().telefone().isEmpty()) {
            this.telefone = dados.getDadosPessoaisClienteDTO().telefone();
        }
        if (!dados.getDadosPessoaisClienteDTO().cep().isEmpty()) {
            this.cep = dados.getDadosPessoaisClienteDTO().cep();
        }

        if (!dados.getDadosPessoaisClienteDTO().endereco().isEmpty()) {
            this.endereco = dados.getDadosPessoaisClienteDTO().endereco();
        }

        if (!dados.getDadosPessoaisClienteDTO().email().isEmpty()) {
            this.email = dados.getDadosPessoaisClienteDTO().email();
        }

        if (dados.getDadosPessoaisClienteDTO().peso() != null) {
            this.peso = dados.getDadosPessoaisClienteDTO().peso();
        }

        if (dados.getDadosPessoaisClienteDTO().altura() != null) {
            this.altura = dados.getDadosPessoaisClienteDTO().altura();
        }

    }
}
