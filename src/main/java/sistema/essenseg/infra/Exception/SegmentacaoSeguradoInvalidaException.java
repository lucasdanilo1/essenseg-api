package sistema.essenseg.infra.Exception;

public class SegmentacaoSeguradoInvalidaException extends RuntimeException{

    public SegmentacaoSeguradoInvalidaException() {
        super("Segmentação inválida: Segurados com segmentação do tipo INDIVIDUAL não podem ter dependentes.");
    }

}
