package sistema.essenseg.model.segurado;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import sistema.essenseg.model.Anexo;
import sistema.essenseg.model.cliente.DadosEspecificosCliente;
import sistema.essenseg.model.dependente.Dependente;
import sistema.essenseg.model.empresa.DadosEspecificosEmpresa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "segurado")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class Segurado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected boolean ativo;

    protected LocalDate dataDoCadastro;

    @Embedded
    protected DadosPessoaisSegurado dadosPessoaisSegurado;

    @Embedded
    protected DadosContratacaoSegurado dadosContratacaoSegurado;

    @Embedded
    protected DadosEspecificosCliente dadosEspecificosCliente;

    @Embedded
    protected DadosEspecificosEmpresa dadosEspecificosEmpresa;

    @OneToMany(mappedBy = "segurado", cascade = CascadeType.ALL)
    private List<Dependente> dependentes = new ArrayList<>();

    @OneToMany(mappedBy = "segurado", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Anexo> anexos =  new ArrayList<>();

    protected String observacoes;

    public Segurado(){
        this.ativo = true;
        this.dataDoCadastro = LocalDate.now();
    }

}
