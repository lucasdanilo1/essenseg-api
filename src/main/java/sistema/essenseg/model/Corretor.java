package sistema.essenseg.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "corretores")
@AllArgsConstructor
@NoArgsConstructor
public class Corretor {

    private String nome;

    private String email;

    private String telefone;

}
