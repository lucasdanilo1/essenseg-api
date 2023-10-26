package sistema.essenseg.model.cliente;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema.essenseg.dto.clienteDTO.DadosAtualizaClienteDTO;
import sistema.essenseg.dto.clienteDTO.DadosClienteDTO;
import sistema.essenseg.model.Administradora;
import sistema.essenseg.model.Anexo;
import sistema.essenseg.model.Corretor;
import sistema.essenseg.model.Operadora;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "clientes")
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataDoCadastro;

    @Embedded
    private DadosPessoais dadosPessoais;

    @Embedded
    private DadosContratacao dadosContratacao;

    @ManyToOne
    private Operadora operadora;

    @ManyToOne
    private Administradora administradora;

    @ManyToOne
    private Corretor corretor;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Anexo> anexos =  new ArrayList<>();

    private String observacoes;

    public Cliente(DadosClienteDTO dados, Operadora operadora, Administradora administradora){
       this.dadosPessoais = new DadosPessoais(dados);
       this.dadosContratacao = new DadosContratacao(dados);
       this.observacoes = dados.observacoes();
       this.operadora = operadora;
       this.administradora = administradora;
       this.dataDoCadastro = LocalDate.now();
    }

    public void atualizarInformacoes(DadosAtualizaClienteDTO dados){
        if(dados.getDadosPessoaisClienteDTO() != null || dados.getDadosParaContratacaoClienteDTO() != null){
            this.dadosPessoais.checaCamposEAtualiza(dados);
            this.dadosContratacao.checaCamposEAtualiza(dados);
        }
    }
}