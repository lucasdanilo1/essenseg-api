package sistema.essenseg.infra;

public class CpfObrigatorioException extends RuntimeException{

    public CpfObrigatorioException() {
        super("CPF é obrigatório");
    }

}
