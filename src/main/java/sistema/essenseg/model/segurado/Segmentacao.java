package sistema.essenseg.model.segurado;

import lombok.Getter;

@Getter
public enum Segmentacao {

    INDIVIDUAL("Individual"),
    ADESAO("Adesão"),
    EMPRESARIAL("Empresarial");

    private final String descricao;

    Segmentacao(String descricao) {
        this.descricao = descricao;
    }

}
