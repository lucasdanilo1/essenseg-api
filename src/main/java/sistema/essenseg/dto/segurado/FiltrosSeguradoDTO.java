package sistema.essenseg.dto.segurado;

import com.fasterxml.jackson.annotation.JsonFormat;
import sistema.essenseg.model.segurado.Segmentacao;

import java.time.LocalDate;

public record FiltrosSeguradoDTO(

        String filtroGlobal,
        Segmentacao segmentacao,
        Long administradoraId,
        Long operadoraId,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate primeiraDataVigencia,
        LocalDate segundaDataVigencia

) {
}
