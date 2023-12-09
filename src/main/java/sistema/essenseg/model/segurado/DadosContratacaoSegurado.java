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
import sistema.essenseg.util.DataUtil;

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

    @Column(precision = 10, scale = 2)
    private BigDecimal plano;

    @Column(precision = 10, scale = 2)
    private BigDecimal adesao;

    @Enumerated(EnumType.STRING)
    private Segmentacao segmentacao;

    public DadosContratacaoSegurado(DadosCadastroClienteDTO dados){
        this.vigencia = DataUtil.converterData(dados.dadosParaContratacaoSeguradoDTO().vigencia());
        this.plano = dados.dadosParaContratacaoSeguradoDTO().plano();
        this.adesao = dados.dadosParaContratacaoSeguradoDTO().adesao();
        this.segmentacao = dados.dadosParaContratacaoSeguradoDTO().segmentacao();
    }

    public DadosContratacaoSegurado(DadosCadastroEmpresaDTO dados){
        this.vigencia = DataUtil.converterData(dados.dadosParaContratacaoSeguradoDTO().vigencia());
        this.plano = dados.dadosParaContratacaoSeguradoDTO().plano();
        this.adesao = dados.dadosParaContratacaoSeguradoDTO().adesao();
        this.segmentacao = Segmentacao.EMPRESARIAL;
    }

    public void checaCamposEAtualiza(AtualizaDadosSeguradoDTO dados) {
        if(dados.vigencia() != null){
            this.vigencia = DataUtil.converterData(dados.vigencia());
        }
        if (dados.plano() != null) {
            this.plano = dados.plano();
        }
        if(dados.adesao() != null){
            this.adesao = dados.adesao();
        }
        if(dados.segmentacao() != null){
            this.segmentacao = dados.segmentacao();
        }
    }
}
