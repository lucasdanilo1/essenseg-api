package sistema.essenseg.dto.cliente;

import lombok.Getter;
import sistema.essenseg.dto.segurado.DadosSeguradoDetalhadoDTO;
import sistema.essenseg.model.cliente.Cliente;

@Getter
public class DadosClienteDetalhadoDTO {

        DadosSeguradoDetalhadoDTO dadosSeguradoDetalhadoDTO;

        DadosEspecificosClienteDetalhadoDTO dadosEspecificosClienteDetalhadoDTO;

        String observacoes;

        public DadosClienteDetalhadoDTO(Cliente cliente){
                this.dadosSeguradoDetalhadoDTO = new DadosSeguradoDetalhadoDTO(cliente.getDadosPessoaisSegurado(), cliente.getDadosContratacaoSegurado());
                this.dadosEspecificosClienteDetalhadoDTO = new DadosEspecificosClienteDetalhadoDTO(cliente.getDadosEspecificosCliente());
                this.observacoes = cliente.getObservacoes();
        }
}
