package sistema.essenseg.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema.essenseg.model.segurado.Segurado;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "anexo")
public class Anexo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "segurado_id")
    private Segurado segurado;

    private String nomeArquivo;

    private String tipoArquivo;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] anexoData;
}
