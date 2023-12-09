package sistema.essenseg.dto.dependente;

public record DadosAtualizaDependenteDTO(
        String nome,
        String dataNascimento,
        String parentesco,
        String telefone,
        String email
) {
}
