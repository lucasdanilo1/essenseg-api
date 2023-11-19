package sistema.essenseg.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema.essenseg.dto.corretor.DadosAtualizaCorretorDTO;
import sistema.essenseg.dto.corretor.DadosCadastroCorretorDTO;

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
    public Corretor(DadosCadastroCorretorDTO dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
    }

    public void atualizaInformacoes(DadosAtualizaCorretorDTO dados) {
        if(dados != null){
            if(dados.getNome() != null){
                this.nome = dados.getNome();
            }
            if(dados.getEmail() != null){
                this.email = dados.getEmail();
            }
            if(dados.getTelefone() != null){
                this.telefone = dados.getTelefone();
            }
        }
    }
}
