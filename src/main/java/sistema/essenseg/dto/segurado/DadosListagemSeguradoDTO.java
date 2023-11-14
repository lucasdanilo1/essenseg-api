package sistema.essenseg.dto.segurado;

import lombok.Getter;
import lombok.Setter;
import sistema.essenseg.model.Segurado.Segmentacao;
import sistema.essenseg.model.Segurado.Segurado;
import sistema.essenseg.model.cliente.Cliente;
import sistema.essenseg.model.empresa.Empresa;

@Getter
@Setter
public class DadosListagemSeguradoDTO {

        String nome;
        String nomeFantasia;
        Long operadoraId;
        Segmentacao segmentacao;
        String cpf;
        String cnpj;
        String email;

    public DadosListagemSeguradoDTO(Segurado segurado) {
        if(segurado instanceof Cliente cliente){
            this.nome = cliente.getDadosPessoaisSegurado().getNome();
            this.nomeFantasia = null;
            this.operadoraId = cliente.getDadosContratacaoSegurado().getOperadora().getId();
            this.segmentacao = cliente.getDadosContratacaoSegurado().getSegmentacao();
            this.cpf = cliente.getDadosEspecificosCliente().getCpf();
            this.cnpj = null;
            this.email = cliente.getDadosPessoaisSegurado().getEmail();
        } else if (segurado instanceof Empresa empresa) {
            this.nome = empresa.getDadosPessoaisSegurado().getNome();
            this.nomeFantasia = empresa.getDadosEspecificosEmpresa().getNomeFantasia();
            this.operadoraId = empresa.getDadosContratacaoSegurado().getOperadora().getId();
            this.segmentacao = empresa.getDadosContratacaoSegurado().getSegmentacao();
            this.cpf = null;
            this.cnpj = empresa.getDadosEspecificosEmpresa().getCnpj();
            this.email = empresa.getDadosPessoaisSegurado().getEmail();
        }
    }

}
