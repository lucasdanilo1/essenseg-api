package sistema.essenseg.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Extrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long randomId;

    private String nome;

    @ManyToOne
    private Corretor corretor;

    private LocalDate dataCriacao;

    @Lob
    @Column(columnDefinition = "bytea")
    private byte[] extratoData;

}
