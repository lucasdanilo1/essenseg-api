package sistema.essenseg.dto.clienteDTO;

import lombok.Getter;
import lombok.Setter;
import sistema.essenseg.model.cliente.Segmentacao;

import java.time.LocalDate;

@Getter
@Setter
public class FiltrosClienteDTO{

        private String nome;
        private String cpf;
        private  String email;
        private String telefone;
        private  Segmentacao segmentacao;
        private  Long administradoraId;
        private Long operadoraId;
        private LocalDate primeiraData;
        private  LocalDate segundaData;

}
