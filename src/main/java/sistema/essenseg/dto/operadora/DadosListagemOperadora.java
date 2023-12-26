package sistema.essenseg.dto.operadora;

import sistema.essenseg.model.Operadora;

public record DadosListagemOperadora(

        Long id,
        String nome

) {
    public DadosListagemOperadora(Operadora operadora){
        this(operadora.getId(), operadora.getNome());
    }
}
