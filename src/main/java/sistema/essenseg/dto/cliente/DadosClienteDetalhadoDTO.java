package sistema.essenseg.dto.cliente;

import lombok.Getter;
import sistema.essenseg.model.Segurado.DadosSeguradoDetalhado;
import sistema.essenseg.model.cliente.Cliente;

@Getter
public class DadosClienteDetalhadoDTO {

        DadosSeguradoDetalhado dadosSeguradoDetalhado;

        DadosEspecificosClienteDetalhadoDTO dadosEspecificosClienteDetalhadoDTO;

        String observacoes;

        public DadosClienteDetalhadoDTO(Cliente cliente){
                this.dadosSeguradoDetalhado = new DadosSeguradoDetalhado(cliente.getDadosPessoaisSegurado(), cliente.getDadosContratacaoSegurado());
                this.dadosEspecificosClienteDetalhadoDTO = new DadosEspecificosClienteDetalhadoDTO(cliente.getDadosEspecificosCliente());
        }
}
