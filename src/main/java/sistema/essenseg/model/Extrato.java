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
@Table(name = "extrato")
@AllArgsConstructor
@NoArgsConstructor
public class Extrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long randomId;

    private String nomeArquivo;

    @ManyToOne
    private Corretor corretor;

    private LocalDate dataCriacao;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] extratoData;

}
