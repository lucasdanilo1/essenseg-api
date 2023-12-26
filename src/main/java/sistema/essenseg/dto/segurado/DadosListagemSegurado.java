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

    Long id;
    String nome;
    String nomeFantasia;
    String telefone;
    String cpf;
    String cnpj;
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate dataCadastro;

    public DadosListagemSegurado(Segurado segurado){
        this.id = segurado.getId();
        this.nome = segurado.getDadosPessoaisSegurado().getNome();
        this.telefone = segurado.getDadosPessoaisSegurado().getTelefone();
        this.dataCadastro = segurado.getDataDoCadastro();
        if(segurado instanceof Cliente){
            this.cpf = segurado.getDadosEspecificosCliente().getCpf();
        } else if (segurado instanceof Empresa) {
            this.cnpj = segurado.getDadosEspecificosEmpresa().getCnpj();
            this.nomeFantasia = segurado.getDadosEspecificosEmpresa().getNomeFantasia();
        }
    }
}
