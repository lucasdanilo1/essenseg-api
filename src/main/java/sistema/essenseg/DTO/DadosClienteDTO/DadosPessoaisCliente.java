package sistema.essenseg.DTO.DadosClienteDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DadosPessoaisCliente {

        @NotBlank
        String nome;
        @NotBlank
        String nomeResponsavel;
        @NotBlank
        String cpf;
        @NotBlank
        String dataNascimento;
        @NotBlank
        String email;
        @NotNull
        Double peso;
        @NotNull
        Integer altura;
        String mensagem;
        @NotBlank
        String telefone;

}
