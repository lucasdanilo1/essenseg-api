package sistema.essenseg.dto.clienteDTO;

import jakarta.validation.Valid;
public record DadosClienteDTO(

        @Valid
        DadosPessoaisClienteDTO dadosPessoaisClienteDTO,

        @Valid
        DadosParaContratacaoClienteDTO dadosParaContratacaoClienteDTO,

        String observacoes

){
}
