package sistema.essenseg.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema.essenseg.model.cliente.Cliente;


@Entity
@Getter
@Setter
@Table(name = "anexos")
@AllArgsConstructor
@NoArgsConstructor
public class Anexo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    private String nome;

    private String type;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] anexoData;
}
