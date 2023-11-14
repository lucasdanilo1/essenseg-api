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

import java.time.LocalDate;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Empresa extends Segurado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataDoCadastro;

    @Embedded
    private DadosEspecificosEmpresa dadosEspecificosEmpresa;

    public Empresa(DadosCadastroEmpresaDTO dados){
       this.dataDoCadastro = LocalDate.now();
       this.dadosPessoaisSegurado = new DadosPessoaisSegurado(dados);
       this.dadosEspecificosEmpresa = new DadosEspecificosEmpresa(dados);
       this.dadosContratacaoSegurado = new DadosContratacaoSegurado(dados);
    }

    public void atualizarInformacoes(AtualizaDadosEmpresaDTO dados) {
        if(dados != null){
            if(dados.atualizaDadosSeguradoDTO() != null){
                this.dadosPessoaisSegurado.checaCamposEAtualiza(dados.atualizaDadosSeguradoDTO());
                this.dadosContratacaoSegurado.checaCamposEAtualiza(dados.atualizaDadosSeguradoDTO());
            }
            this.dadosEspecificosEmpresa.checaCamposEAtualiza(dados);
        }
    }
}