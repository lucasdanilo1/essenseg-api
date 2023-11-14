package sistema.essenseg.dto.cliente;

import jakarta.validation.Valid;
import sistema.essenseg.dto.segurado.DadosParaContratacaoSeguradoDTO;
import sistema.essenseg.dto.segurado.DadosPessoaisSeguradoDTO;

public record DadosCadastroClienteDTO(

        @Valid
        DadosPessoaisSeguradoDTO dadosPessoaisSeguradoDTO,

        @Valid
        DadosParaContratacaoSeguradoDTO dadosParaContratacaoSeguradoDTO,

        @Valid
        DadosEspecificosCadastroClienteDTO dadosEspecificosCadastroClienteDTO,

        String observacoes

){
}
