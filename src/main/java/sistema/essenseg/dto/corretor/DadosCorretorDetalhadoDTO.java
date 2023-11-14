package sistema.essenseg.dto.corretor;

import sistema.essenseg.model.Corretor;

public record DadosCorretorDetalhadoDTO(
        String nome,

        String email,

        String telefone
) {



    public DadosCorretorDetalhadoDTO(Corretor corretor) {
        this(corretor.getNome(), corretor.getEmail(), corretor.getTelefone());
    }
}
