package sistema.essenseg.dto.cliente;

import org.hibernate.validator.constraints.br.CPF;
import sistema.essenseg.dto.segurado.AtualizaDadosSeguradoDTO;

import java.math.BigDecimal;

public record AtualizaDadosClienteDTO(

        AtualizaDadosSeguradoDTO atualizaDadosSeguradoDTO,

        @CPF
        String cpf,

        String nomeResponsavel,

        String cpfResponsavel,

        BigDecimal peso,

        BigDecimal altura,

        String observacoes

) {
}
