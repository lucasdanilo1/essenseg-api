package sistema.essenseg.dto.empresa;

import jakarta.validation.Valid;
import sistema.essenseg.dto.segurado.DadosParaContratacaoSeguradoDTO;
import sistema.essenseg.dto.segurado.DadosPessoaisSeguradoDTO;

public record DadosCadastroEmpresaDTO(

        @Valid
        DadosPessoaisSeguradoDTO dadosPessoaisSeguradoDTO,

        @Valid
        DadosParaContratacaoSeguradoDTO dadosParaContratacaoSeguradoDTO,

        @Valid
        DadosEspecificosCadastroEmpresaDTO dadosEspecificosCadastroEmpresaDTO,

        String observacoes

){
}
