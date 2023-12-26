package sistema.essenseg.model.exception;

public class GerarRelatorioException extends RuntimeException{

    public GerarRelatorioException() {
        super("Não foi possível gerar o relatório");
    }

}
