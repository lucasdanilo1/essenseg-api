package sistema.essenseg.dto.relacionamento;

import jakarta.validation.constraints.NotNull;

public record DadosRelacionamentoDTO(
        @NotNull
        Long operadoraId,
        @NotNull
        Long administradoraId
){}
