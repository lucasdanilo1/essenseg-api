package sistema.essenseg.infra.Exception;

public class CpfObrigatorioException extends RuntimeException{

    public CpfObrigatorioException() {
        super("CPF é obrigatório");
    }

}
