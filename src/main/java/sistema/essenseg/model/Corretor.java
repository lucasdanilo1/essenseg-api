package sistema.essenseg.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema.essenseg.dto.corretorDTO.DadosAtualizaCorretor;
import sistema.essenseg.dto.corretorDTO.DadosCorretorDTO;

@Entity
@Getter
@Setter
@Table(name = "corretores")
@AllArgsConstructor
@NoArgsConstructor
public class Corretor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String telefone;
    public Corretor(DadosCorretorDTO dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
    }

    public void atualizaInformacoes(DadosAtualizaCorretor dados) {
        if(!dados.getNome().isEmpty()){
            this.nome = dados.getNome();
        }
        if(!dados.getEmail().isEmpty()){
            this.email = dados.getEmail();
        }
        if(!dados.getTelefone().isEmpty()){
            this.telefone = dados.getTelefone();
        }
    }
}
