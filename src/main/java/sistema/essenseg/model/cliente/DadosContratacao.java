package sistema.essenseg.model.cliente;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema.essenseg.DTO.DadosClienteDTO.DadosClienteDTO;
import sistema.essenseg.model.enums.Segmentacao;
import sistema.essenseg.service.dataConverterService;

import java.math.BigDecimal;
import java.time.LocalDate;

@Embeddable
@NoArgsConstructor
@Getter
@Setter
public class DadosContratacao {

    private LocalDate vigencia;

    @Column(precision = 10, scale = 2)
    private BigDecimal plano;

    @Column(precision = 10, scale = 2)
    private BigDecimal adesao;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Segmentacao segmentacao;


    public DadosContratacao(DadosClienteDTO dados){

        this.vigencia = dataConverterService.converterData(dados.getDadosParaContratacaoCliente().getVigencia());
        this.plano = dados.getDadosParaContratacaoCliente().getPlano();
        this.adesao = dados.getDadosParaContratacaoCliente().getAdesao();
        this.segmentacao = dados.getDadosParaContratacaoCliente().getSegmentacao();


    }

}
