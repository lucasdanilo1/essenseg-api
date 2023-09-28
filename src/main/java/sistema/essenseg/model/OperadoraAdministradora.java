package sistema.essenseg.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "operadora_administradora")
@NoArgsConstructor
public class OperadoraAdministradora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "administradora_id")
    private Administradora administradora;

    @ManyToOne
    @JoinColumn(name = "operadora_id")
    private Operadora operadora;

    public OperadoraAdministradora(Administradora administradora, Operadora operadora) {
        this.administradora = administradora;
        this.operadora = operadora;
    }

}

