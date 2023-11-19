package sistema.essenseg.dto.cliente;

import sistema.essenseg.model.Segurado.Segmentacao;

import java.time.LocalDate;

public record FiltrosClienteDTO(

        String filtroGlobal,
        Segmentacao segmentacao,
        Long administradoraId,
        Long operadoraId,
        LocalDate primeiraDataVigencia,
        LocalDate segundaDataVigencia

){
}
