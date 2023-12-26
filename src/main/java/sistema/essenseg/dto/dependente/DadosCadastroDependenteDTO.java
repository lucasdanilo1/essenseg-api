package sistema.essenseg.dto.dependente;

import org.hibernate.validator.constraints.br.CPF;

public record DadosCadastroDependenteDTO(

        String nome,
        String dataNascimento,
        @CPF
        String cpf,
        String parentesco,
        String telefone,
        String email

) {
}
