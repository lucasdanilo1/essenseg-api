package sistema.essenseg.dto.empresa;

import java.time.LocalDate;

public record FiltrosEmpresaDTO(

        String nomeFantasia,
        String cnpj,
        String atvEconomica,
        String nome,
        String razaoSocial,
        Long administradoraId,
        Long operadoraId,
        LocalDate primeiraDataVigencia,
        LocalDate segundaDataVigencia

) {

}
