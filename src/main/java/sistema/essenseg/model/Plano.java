package sistema.essenseg.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema.essenseg.dto.plano.DadosPlanoDTO;

@Getter
@Setter
@Entity
@Table(name = "plano")
@NoArgsConstructor
@AllArgsConstructor
public class Plano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "operadora_id")
    private Operadora operadora;

    public Plano(DadosPlanoDTO dados){
        this.nome = dados.nome();
    }
}
