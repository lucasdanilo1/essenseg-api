package sistema.essenseg.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema.essenseg.dto.administradora.DadosAdministradoraDTO;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "administradora")
@NoArgsConstructor
@AllArgsConstructor
public class Administradora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToMany(mappedBy = "administradora")
    private Set<Operadora> operadora = new HashSet<>();

    public Administradora(DadosAdministradoraDTO dados){
        this.nome = dados.nome();
    }

}
