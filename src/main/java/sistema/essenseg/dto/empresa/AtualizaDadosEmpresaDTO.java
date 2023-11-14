package sistema.essenseg.dto.empresa;

import org.hibernate.validator.constraints.br.CNPJ;
import sistema.essenseg.dto.segurado.AtualizaDadosSeguradoDTO;

public record AtualizaDadosEmpresaDTO(

        AtualizaDadosSeguradoDTO atualizaDadosSeguradoDTO,

        @CNPJ
        String cnpj,

        String razaoSocial,

        String nomeFantasia,

        String atvEconomica,

        String dataAbertura,

        String observacoes

) {
}
