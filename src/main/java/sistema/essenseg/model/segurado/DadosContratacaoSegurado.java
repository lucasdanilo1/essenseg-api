package sistema.essenseg.model.segurado;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema.essenseg.dto.cliente.DadosCadastroClienteDTO;
import sistema.essenseg.dto.empresa.DadosCadastroEmpresaDTO;
import sistema.essenseg.dto.segurado.AtualizaDadosSeguradoDTO;
import sistema.essenseg.model.Administradora;
import sistema.essenseg.model.Corretor;
import sistema.essenseg.model.Operadora;
import sistema.essenseg.model.Plano;

import java.math.BigDecimal;
import java.time.LocalDate;

@Embeddable
@NoArgsConstructor
@Getter
@Setter
public class DadosContratacaoSegurado {

    @ManyToOne(fetch = FetchType.EAGER)
    private Operadora operadora;

    @ManyToOne(fetch = FetchType.EAGER)
    private Administradora administradora;

    @ManyToOne(fetch = FetchType.EAGER)
    private Corretor corretor;

    private LocalDate vigencia;

    @ManyToOne(fetch = FetchType.EAGER)
    private Plano plano;

    @Column(precision = 10, scale = 2)
    private BigDecimal valorDoPlano = new BigDecimal("0");

    private BigDecimal percentualComissao = new BigDecimal("0");

    @Column(precision = 10, scale = 2)
    private BigDecimal adesao = new BigDecimal("0");

    @Enumerated(EnumType.STRING)
    private Segmentacao segmentacao;

    public DadosContratacaoSegurado(DadosCadastroClienteDTO dados){
        this.vigencia = dados.dadosParaContratacaoSeguradoDTO().vigencia();
        this.valorDoPlano = dados.dadosParaContratacaoSeguradoDTO().valorDoPlano();
        this.percentualComissao = dados.dadosParaContratacaoSeguradoDTO().percentualComissao();
        this.adesao = dados.dadosParaContratacaoSeguradoDTO().adesao();
        this.segmentacao = dados.dadosParaContratacaoSeguradoDTO().segmentacao();
    }

    public DadosContratacaoSegurado(DadosCadastroEmpresaDTO dados){
        this.vigencia = dados.dadosParaContratacaoSeguradoDTO().vigencia();
        this.valorDoPlano = dados.dadosParaContratacaoSeguradoDTO().valorDoPlano();
        this.percentualComissao = dados.dadosParaContratacaoSeguradoDTO().percentualComissao();
        this.adesao = dados.dadosParaContratacaoSeguradoDTO().adesao();
        this.segmentacao = Segmentacao.EMPRESARIAL;
    }

    public void checaCamposEAtualiza(AtualizaDadosSeguradoDTO dados) {
        if(dados.vigencia() != null){
            this.vigencia = dados.vigencia();
        }
        if (dados.valorDoPlano() != null) {
            this.valorDoPlano = dados.valorDoPlano();
        }
        if(dados.percentualComissao() != null){
            this.percentualComissao = dados.percentualComissao();
        }
        if(dados.adesao() != null){
            this.adesao = dados.adesao();
        }
        if(dados.segmentacao() != null){
            this.segmentacao = dados.segmentacao();
        }
    }
}
