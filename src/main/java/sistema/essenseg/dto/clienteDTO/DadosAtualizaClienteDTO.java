package sistema.essenseg.dto.clienteDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DadosAtualizaClienteDTO {

    private DadosPessoaisClienteDTO dadosPessoaisClienteDTO;

    private DadosParaContratacaoClienteDTO dadosParaContratacaoClienteDTO;

    private String observacoes;

}
