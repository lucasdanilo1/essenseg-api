package sistema.essenseg.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema.essenseg.dto.operadora.DadosOperadoraDTO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "operadora")
@NoArgsConstructor
@AllArgsConstructor
public class Operadora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;

    @OneToMany(mappedBy = "operadora", cascade = CascadeType.ALL)
    private List<Plano> planos = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "operadora_administradora",
            joinColumns = @JoinColumn(name = "operadora_id"),
            inverseJoinColumns = @JoinColumn(name = "administradora_id"))
    private Set<Administradora> administradora = new HashSet<>();

    public Operadora(DadosOperadoraDTO dados){
        this.nome = dados.nome();
    }

}
