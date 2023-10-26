package sistema.essenseg.infra;

public class NomeObjetoJaExistenteException extends RuntimeException{

    public NomeObjetoJaExistenteException() {
        super("Objeto com o mesmo nome já existente");
    }

}
