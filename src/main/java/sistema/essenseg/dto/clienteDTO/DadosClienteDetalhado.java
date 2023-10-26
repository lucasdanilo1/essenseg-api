package sistema.essenseg.dto.clienteDTO;

import lombok.Getter;
import sistema.essenseg.model.cliente.Cliente;
import sistema.essenseg.model.cliente.DadosContratacao;
import sistema.essenseg.model.cliente.DadosPessoais;

@Getter
public class DadosClienteDetalhado {

        private DadosPessoais dadosPessoais;

        private DadosContratacao dadosContratacao;

        private String observacoes;

        public DadosClienteDetalhado(Cliente cliente){
                this.dadosPessoais = cliente.getDadosPessoais();
                this.dadosContratacao = cliente.getDadosContratacao();
                this.observacoes = cliente.getObservacoes();
        }

}
