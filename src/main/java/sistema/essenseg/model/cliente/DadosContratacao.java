package sistema.essenseg.model.cliente;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema.essenseg.dto.clienteDTO.DadosAtualizaClienteDTO;
import sistema.essenseg.dto.clienteDTO.DadosClienteDTO;
import sistema.essenseg.util.DataUtil;

import java.math.BigDecimal;
import java.time.LocalDate;

@Embeddable
@NoArgsConstructor
@Getter
@Setter
public class DadosContratacao {

    @NotNull
    private LocalDate vigencia;

    @Column(precision = 10, scale = 2)
    private BigDecimal plano;

    @Column(precision = 10, scale = 2)
    private BigDecimal adesao;

    @Enumerated(EnumType.STRING)
    private Segmentacao segmentacao;




    public DadosContratacao(DadosClienteDTO dados){
        this.vigencia = DataUtil.converterData(dados.dadosParaContratacaoClienteDTO().vigencia());
        this.plano = dados.dadosParaContratacaoClienteDTO().plano();
        this.adesao = dados.dadosParaContratacaoClienteDTO().adesao();
        this.segmentacao = dados.dadosParaContratacaoClienteDTO().segmentacao();
    }

    public void checaCamposEAtualiza(DadosAtualizaClienteDTO dados) {
        if(dados.getDadosParaContratacaoClienteDTO().vigencia() != null){
            this.vigencia = getVigencia();
        }
        if (dados.getDadosParaContratacaoClienteDTO().plano() != null) {
            this.plano = dados.getDadosParaContratacaoClienteDTO().plano();
        }
        if(dados.getDadosParaContratacaoClienteDTO().adesao() != null){
            this.adesao = dados.getDadosParaContratacaoClienteDTO().adesao();
        }
        if(dados.getDadosParaContratacaoClienteDTO().segmentacao() != null){
            this.segmentacao = dados.getDadosParaContratacaoClienteDTO().segmentacao();
        }
    }
}
