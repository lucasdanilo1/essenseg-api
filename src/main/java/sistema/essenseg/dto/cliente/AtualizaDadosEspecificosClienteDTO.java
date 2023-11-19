package sistema.essenseg.dto.cliente;

import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;

public record AtualizaDadosEspecificosClienteDTO(

        @CPF
        String cpf,

        String nomeResponsavel,

        String cpfResponsavel,

        BigDecimal peso,

        BigDecimal altura,

        String observacoes

) {
}
