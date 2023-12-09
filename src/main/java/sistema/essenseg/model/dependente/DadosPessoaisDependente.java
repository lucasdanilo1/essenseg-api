package sistema.essenseg.model.dependente;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import sistema.essenseg.dto.dependente.DadosAtualizaDependenteDTO;
import sistema.essenseg.dto.dependente.DadosCadastroDependenteDTO;
import sistema.essenseg.util.DataUtil;

import java.time.LocalDate;

@Embeddable
@Getter
public class DadosPessoaisDependente {

    private String nome;

    private LocalDate dataNascimento;

    private final String cpf;

    private String parentesco;

    private String email;

    private String telefone;

    public DadosPessoaisDependente(DadosCadastroDependenteDTO dados) {
        this.nome = dados.nome();
        this.dataNascimento = DataUtil.converterData(dados.dataNascimento());
        this.cpf = dados.cpf();
        this.parentesco = dados.parentesco();
        this.email = dados.email();
        this.telefone = dados.telefone();
    }

    public void checaCamposEAtualiza(DadosAtualizaDependenteDTO dados) {
        if(dados != null){
            if(dados.nome() != null){
                this.nome = dados.nome();
            }
            if(dados.dataNascimento() != null){
                this.dataNascimento = DataUtil.converterData(dados.dataNascimento());
            }
            if(dados.parentesco() != null){
                this.parentesco = dados.parentesco();
            }
            if(dados.email() != null){
                this.email = dados.email();
            }
            if(dados.telefone() != null){
                this.telefone = dados.telefone();
            }
        }
    }
}
