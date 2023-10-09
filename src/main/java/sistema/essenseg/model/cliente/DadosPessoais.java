package sistema.essenseg.model.cliente;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
import sistema.essenseg.dto.clienteDTO.DadosClienteDTO;
import sistema.essenseg.util.DataUtil;

import java.time.LocalDate;


@Embeddable
@NoArgsConstructor
@Getter
@Setter
public class DadosPessoais {

    @NotBlank
    private String nome;

    @NotBlank
    @CPF
    private String cpf;

    private String rg;

    private String nomeResponsavel;

    private String cpfResponsavel;

    @NotNull
    private LocalDate dataNascimento;

    @NotBlank
    private String telefone;

    private String endereco;

    @NotBlank
    private String email;

    private Double peso;

    private Integer altura;


    public DadosPessoais(DadosClienteDTO dados){

        this.nome = dados.getDadosPessoaisCliente().getNome();
        this.cpf = dados.getDadosPessoaisCliente().getCpf();
        this.nomeResponsavel = dados.getDadosPessoaisCliente().getNomeResponsavel();
        this.dataNascimento = DataUtil.converterData(dados.getDadosPessoaisCliente().getDataNascimento());
        this.telefone = dados.getDadosPessoaisCliente().getTelefone();
        this.email = dados.getDadosPessoaisCliente().getEmail();
        this.peso = dados.getDadosPessoaisCliente().getPeso();
        this.altura = dados.getDadosPessoaisCliente().getAltura();

    }




}
