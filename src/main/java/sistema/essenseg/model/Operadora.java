package sistema.essenseg.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema.essenseg.DTO.DadosOperadoraDTO;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Operadora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
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
