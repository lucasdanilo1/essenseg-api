package sistema.essenseg.model.Segurado;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema.essenseg.dto.empresa.DadosCadastroEmpresaDTO;
import sistema.essenseg.dto.segurado.AtualizaDadosSeguradoDTO;
import sistema.essenseg.dto.cliente.DadosCadastroClienteDTO;


@Embeddable
@NoArgsConstructor
@Getter
@Setter
public class DadosPessoaisSegurado {

    private String nome;

    private String telefone;

    private String cep;

    private String endereco;

    private String email;

    public DadosPessoaisSegurado(DadosCadastroClienteDTO dados){
        this.nome = dados.dadosPessoaisSeguradoDTO().nome();
        this.telefone = dados.dadosPessoaisSeguradoDTO().telefone();
        this.cep = dados.dadosPessoaisSeguradoDTO().cep();
        this.endereco = dados.dadosPessoaisSeguradoDTO().endereco();
        this.email = dados.dadosPessoaisSeguradoDTO().email();
    }

    public DadosPessoaisSegurado(DadosCadastroEmpresaDTO dados){
        this.nome = dados.dadosPessoaisSeguradoDTO().nome();
        this.telefone = dados.dadosPessoaisSeguradoDTO().telefone();
        this.cep = dados.dadosPessoaisSeguradoDTO().cep();
        this.endereco = dados.dadosPessoaisSeguradoDTO().endereco();
        this.email = dados.dadosPessoaisSeguradoDTO().email();
    }

    public void checaCamposEAtualiza(AtualizaDadosSeguradoDTO dados) {

        if (dados.nome() != null) {
            this.nome = dados.nome();
        }

        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.cep() != null) {
            this.cep = dados.cep();
        }

        if (dados.endereco() != null) {
            this.endereco = dados.endereco();
        }

        if (dados.email() != null) {
            this.email = dados.email();
        }
    }
}
