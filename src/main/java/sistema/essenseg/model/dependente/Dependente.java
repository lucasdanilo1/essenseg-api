package sistema.essenseg.model.dependente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema.essenseg.dto.dependente.DadosAtualizaDependenteDTO;
import sistema.essenseg.dto.dependente.DadosCadastroDependenteDTO;
import sistema.essenseg.model.segurado.Segurado;

@Entity
@Getter
@Setter
@Table(name = "dependente")
@AllArgsConstructor
@NoArgsConstructor
public class Dependente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private DadosPessoaisDependente dadosPessoaisDependente;

    @ManyToOne
    @JoinColumn(name = "segurado_id")
    private Segurado segurado;

    public Dependente(DadosCadastroDependenteDTO dados) {
        this.dadosPessoaisDependente = new DadosPessoaisDependente(dados);
    }

    public void atualizarInformacoes(DadosAtualizaDependenteDTO dados) {
        if(dados != null){
            dadosPessoaisDependente.checaCamposEAtualiza(dados);
        }
    }
}
