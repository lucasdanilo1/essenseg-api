package sistema.essenseg.model.enums;

public enum Segmentacao {

    INDIVIDUAL("Individual"),
    EMPRESARIAL("Empresarial"),
    ADESAO("Adesão");

    private String descricao;

    Segmentacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
