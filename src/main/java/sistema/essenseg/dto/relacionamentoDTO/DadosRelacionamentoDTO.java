package sistema.essenseg.dto.relacionamentoDTO;

import jakarta.validation.constraints.NotNull;

public record DadosRelacionamentoDTO(
        @NotNull
        Long operadoraId,
        @NotNull
        Long administradoraId
){}
