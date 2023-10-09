package sistema.essenseg.dto.clienteDTO;

import lombok.Getter;
import lombok.Setter;
import sistema.essenseg.model.cliente.Segmentacao;

import java.time.LocalDate;

@Getter
@Setter
public class FiltrosClienteDTO{

        String nome;
        String cpf;
        String email;
        String telefone;
        Segmentacao segmentacao;
        Long administradoraId;
        Long operadoraId;
        LocalDate primeiraData;
        LocalDate segundaData;

}
