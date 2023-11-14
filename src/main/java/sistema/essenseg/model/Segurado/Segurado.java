package sistema.essenseg.model.Segurado;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class Segurado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected LocalDate dataDoCadastro;

    @Embedded
    protected DadosPessoaisSegurado dadosPessoaisSegurado;

    @Embedded
    protected DadosContratacaoSegurado dadosContratacaoSegurado;

    protected String observacoes;

}
