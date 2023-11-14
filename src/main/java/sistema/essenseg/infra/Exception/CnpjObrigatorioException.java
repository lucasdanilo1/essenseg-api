package sistema.essenseg.infra.Exception;

public class CnpjObrigatorioException extends RuntimeException{

    public CnpjObrigatorioException() {
        super("CNPJ é obrigatório");
    }

}
