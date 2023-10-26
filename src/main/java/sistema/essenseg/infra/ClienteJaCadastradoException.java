package sistema.essenseg.infra;

public class ClienteJaCadastradoException extends RuntimeException{

    public ClienteJaCadastradoException() {
        super("CPF ou CPNJ já existente");
    }

}
