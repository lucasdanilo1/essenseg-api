package sistema.essenseg.infra;

public class CnpjObrigatorioException extends RuntimeException{

    public CnpjObrigatorioException() {
        super("CNPJ é obrigatório");
    }

}
