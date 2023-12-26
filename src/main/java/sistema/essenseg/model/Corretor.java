package sistema.essenseg.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema.essenseg.dto.corretor.DadosAtualizaCorretorDTO;
import sistema.essenseg.dto.corretor.DadosCadastroCorretorDTO;
import sistema.essenseg.model.segurado.Segurado;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "corretor")
@AllArgsConstructor
@NoArgsConstructor
public class Corretor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;

    private String email;

    private String telefone;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Extrato> extratos = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Segurado> segurados = new ArrayList<>();

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
