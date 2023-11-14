package sistema.essenseg.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema.essenseg.dto.operadora.DadosOperadoraDTO;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "operadoras")
@NoArgsConstructor
@AllArgsConstructor
public class Operadora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToMany
    @JoinTable(name = "operadora_administradora",
            joinColumns = @JoinColumn(name = "operadora_id"),
            inverseJoinColumns = @JoinColumn(name = "administradora_id"))
    private Set<Administradora> administradoras = new HashSet<>();

    public Operadora(DadosOperadoraDTO dados){
        this.nome = dados.nome();
    }

}
