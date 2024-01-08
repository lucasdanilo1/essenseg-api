package sistema.essenseg.dto.administradora;

import sistema.essenseg.model.Administradora;

public record DadosListagemAdministradoraDTO(

        Long id,
        String nome

) {
    public DadosListagemAdministradoraDTO(Administradora administradora){
        this(administradora.getId(), administradora.getNome());
    }
}
