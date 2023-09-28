package sistema.essenseg.DTO;

public record FiltrosClienteDTO(

        String nome,
        String cpf,
        String email,
        String telefone,
        Long administradoraId,
        Long operadoraId

) {
}
