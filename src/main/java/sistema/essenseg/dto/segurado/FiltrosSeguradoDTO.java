package sistema.essenseg.dto.segurado;

import sistema.essenseg.model.segurado.Segmentacao;

import java.time.LocalDate;

public record FiltrosSeguradoDTO(

        String filtroGlobal,
        Segmentacao segmentacao,
        Long administradoraId,
        Long operadoraId,
        LocalDate primeiraDataVigencia,
        LocalDate segundaDataVigencia

) {
}
