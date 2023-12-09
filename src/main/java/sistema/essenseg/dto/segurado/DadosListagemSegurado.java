package sistema.essenseg.dto.segurado;

import lombok.Getter;
import lombok.Setter;
import sistema.essenseg.model.segurado.Segurado;
import sistema.essenseg.model.cliente.Cliente;
import sistema.essenseg.model.empresa.Empresa;

@Getter
@Setter
public class DadosListagemSegurado {

    Long id;
    String nome;
    String nomeFantasia;
    String telefone;
    String cpf;
    String cnpj;
    String dataCadastro;

    public DadosListagemSegurado(Segurado segurado){
        this.id = segurado.getId();
        this.nome = segurado.getDadosPessoaisSegurado().getNome();
        this.telefone = segurado.getDadosPessoaisSegurado().getTelefone();
        this.dataCadastro = segurado.getDataDoCadastro().toString();
        if(segurado instanceof Cliente){
            this.cpf = segurado.getDadosEspecificosCliente().getCpf();
        } else if (segurado instanceof Empresa) {
            this.cnpj = segurado.getDadosEspecificosEmpresa().getCnpj();
            this.nomeFantasia = segurado.getDadosEspecificosEmpresa().getNomeFantasia();
        }
    }
}
