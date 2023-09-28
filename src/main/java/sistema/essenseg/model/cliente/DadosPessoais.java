package sistema.essenseg.model.cliente;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
import sistema.essenseg.DTO.DadosClienteDTO.DadosClienteDTO;
import sistema.essenseg.service.dataConverterService;

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

    @NotBlank
    private String rg;

    @NotBlank
    private String nomeResponsavel;

    @NotBlank
    private String cpfResponsavel;

    @NotNull
    private LocalDate dataNascimento;

    @NotBlank
    private String telefone;

    @NotBlank
    private String endereco;

    @NotBlank
    private String email;

    @NotNull
    private Double peso;

    @NotNull
    private Integer altura;

    String mensagem;

    public DadosPessoais(DadosClienteDTO dados){

        this.nome = dados.getDadosPessoaisCliente().getNome();
        this.cpf = dados.getDadosPessoaisCliente().getCpf();
        this.nomeResponsavel = dados.getDadosPessoaisCliente().getNomeResponsavel();
        this.dataNascimento = dataConverterService.converterData(dados.getDadosPessoaisCliente().getDataNascimento());
        this.telefone = dados.getDadosPessoaisCliente().getTelefone();
        this.email = dados.getDadosPessoaisCliente().getEmail();
        this.peso = dados.getDadosPessoaisCliente().getPeso();
        this.altura = dados.getDadosPessoaisCliente().getAltura();
        this.mensagem = dados.getDadosPessoaisCliente().getMensagem();

    }




}
