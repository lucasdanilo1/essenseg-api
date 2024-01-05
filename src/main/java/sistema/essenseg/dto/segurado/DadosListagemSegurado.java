package sistema.essenseg.dto.segurado;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import sistema.essenseg.model.segurado.Segurado;
import sistema.essenseg.model.cliente.Cliente;
import sistema.essenseg.model.empresa.Empresa;

import java.time.LocalDate;

@Getter
@Setter
public class DadosListagemSegurado {

    String tipo;
    Long id;
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate dataCadastro;
    String nome;
    String telefone;
    String email;
    String cpfCnpj;

    public DadosListagemSegurado(Segurado segurado){
        this.id = segurado.getId();
        this.telefone = segurado.getDadosPessoaisSegurado().getTelefone();
        this.dataCadastro = segurado.getDataDoCadastro();
        this.email = segurado.getDadosPessoaisSegurado().getEmail();
        this.tipo = segurado.getDadosContratacaoSegurado().getSegmentacao().getDescricao();
        if(segurado instanceof Cliente){
            this.nome = segurado.getDadosPessoaisSegurado().getNome();
            this.cpfCnpj = segurado.getDadosEspecificosCliente().getCpf();
        } else if (segurado instanceof Empresa) {
            this.nome = segurado.getDadosEspecificosEmpresa().getNomeFantasia();
            this.cpfCnpj = segurado.getDadosEspecificosEmpresa().getCnpj();
        }
    }
}
