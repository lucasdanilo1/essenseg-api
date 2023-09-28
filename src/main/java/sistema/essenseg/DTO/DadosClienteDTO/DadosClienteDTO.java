package sistema.essenseg.DTO.DadosClienteDTO;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DadosClienteDTO{

        @Valid
        DadosPessoaisCliente dadosPessoaisCliente;
        @Valid
        DadosParaContratacaoCliente dadosParaContratacaoCliente;

}
