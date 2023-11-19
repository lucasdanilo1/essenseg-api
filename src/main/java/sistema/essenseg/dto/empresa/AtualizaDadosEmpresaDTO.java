package sistema.essenseg.dto.empresa;

import sistema.essenseg.dto.segurado.AtualizaDadosSeguradoDTO;

public record AtualizaDadosEmpresaDTO(

        AtualizaDadosSeguradoDTO atualizaDadosSeguradoDTO,

        AtualizaDadosEspecificosEmpresaDTO atualizaDadosEspecificosEmpresaDTO,

        String observacoes

) {
}
