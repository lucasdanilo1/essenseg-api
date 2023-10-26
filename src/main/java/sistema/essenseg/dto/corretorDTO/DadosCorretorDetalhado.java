package sistema.essenseg.dto.corretorDTO;

import lombok.Getter;
import sistema.essenseg.model.Corretor;

@Getter
public class DadosCorretorDetalhado {

    private String nome;

    private String email;

    private String telefone;

    public DadosCorretorDetalhado(Corretor corretor){
        this.nome = corretor.getNome();
        this.email = corretor.getEmail();
        this.telefone = corretor.getTelefone();
    }
}
