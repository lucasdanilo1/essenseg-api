package sistema.essenseg.model.cliente;

import lombok.Getter;

@Getter
public enum Segmentacao {

    INDIVIDUAL("Individual"),
    ADESAO("Adesão");

    private final String descricao;

    Segmentacao(String descricao) {
        this.descricao = descricao;
    }

}
