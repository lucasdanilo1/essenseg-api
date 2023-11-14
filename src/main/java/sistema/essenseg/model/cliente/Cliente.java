package sistema.essenseg.model.cliente;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema.essenseg.dto.cliente.AtualizaDadosClienteDTO;
import sistema.essenseg.dto.cliente.DadosCadastroClienteDTO;
import sistema.essenseg.model.Anexo;
import sistema.essenseg.model.Corretor;
import sistema.essenseg.model.Segurado.DadosContratacaoSegurado;
import sistema.essenseg.model.Segurado.DadosPessoaisSegurado;
import sistema.essenseg.model.Segurado.Segurado;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cliente extends Segurado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    DadosEspecificosCliente dadosEspecificosCliente;

    @ManyToOne
    private Corretor corretor;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Anexo> anexos =  new ArrayList<>();

    public Cliente(DadosCadastroClienteDTO dadosCliente){
       this.dadosPessoaisSegurado = new DadosPessoaisSegurado(dadosCliente);
       this.dadosContratacaoSegurado = new DadosContratacaoSegurado(dadosCliente);
       this.dadosEspecificosCliente = new DadosEspecificosCliente(dadosCliente);

       this.observacoes = dadosCliente.observacoes();
       this.dataDoCadastro = LocalDate.now();
    }


    public void atualizarInformacoes(AtualizaDadosClienteDTO dados){
        if(dados != null){
            if(dados.atualizaDadosSeguradoDTO() != null){
                this.dadosPessoaisSegurado.checaCamposEAtualiza(dados.atualizaDadosSeguradoDTO());
                this.dadosContratacaoSegurado.checaCamposEAtualiza(dados.atualizaDadosSeguradoDTO());
            }
            this.dadosEspecificosCliente.checaCamposEAtualiza(dados);
        }
    }
}