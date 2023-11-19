package sistema.essenseg.model.empresa;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema.essenseg.dto.empresa.AtualizaDadosEmpresaDTO;
import sistema.essenseg.dto.empresa.DadosCadastroEmpresaDTO;
import sistema.essenseg.model.Segurado.DadosContratacaoSegurado;
import sistema.essenseg.model.Segurado.DadosPessoaisSegurado;
import sistema.essenseg.model.Segurado.Segurado;

@Getter
@Setter
@Entity
@NoArgsConstructor
@DiscriminatorValue("empresa")
public class Empresa extends Segurado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Empresa(DadosCadastroEmpresaDTO dados){
       this.dadosPessoaisSegurado = new DadosPessoaisSegurado(dados);
       this.dadosEspecificosEmpresa = new DadosEspecificosEmpresa(dados);
       this.dadosContratacaoSegurado = new DadosContratacaoSegurado(dados);
       this.observacoes = dados.observacoes();
    }

    public void atualizarInformacoes(AtualizaDadosEmpresaDTO dados) {
        if(dados != null){
            if(dados.atualizaDadosSeguradoDTO() != null){
                this.dadosPessoaisSegurado.checaCamposEAtualiza(dados.atualizaDadosSeguradoDTO());
                this.dadosContratacaoSegurado.checaCamposEAtualiza(dados.atualizaDadosSeguradoDTO());
            }
            if(dados.atualizaDadosEspecificosEmpresaDTO() != null){
                this.dadosEspecificosEmpresa.checaCamposEAtualiza(dados);
            }
            if(dados.observacoes() != null){
                if(!dados.observacoes().isEmpty()){
                    this.observacoes = dados.observacoes();
                }
            }
        }
    }

    public Long getId() {
        return super.id;
    }
}