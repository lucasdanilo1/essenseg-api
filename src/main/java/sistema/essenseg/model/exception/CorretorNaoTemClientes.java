package sistema.essenseg.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CorretorNaoTemClientes extends RuntimeException{

    public CorretorNaoTemClientes() {
        super("Não existem clientes vinculados a esse corretor");
    }

}
