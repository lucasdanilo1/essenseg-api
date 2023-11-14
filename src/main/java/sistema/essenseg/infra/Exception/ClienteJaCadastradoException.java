package sistema.essenseg.infra.Exception;

public class ClienteJaCadastradoException extends RuntimeException{

    public ClienteJaCadastradoException() {
        super("CPF ou CPNJ já existente");
    }

}
