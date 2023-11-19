package sistema.essenseg.dto.empresa;

import org.hibernate.validator.constraints.br.CNPJ;

public record AtualizaDadosEspecificosEmpresaDTO(

        @CNPJ
        String cnpj,

        String razaoSocial,

        String nomeFantasia,

        String atvEconomica,

        String dataAbertura,

        String observacoes

) {
}
