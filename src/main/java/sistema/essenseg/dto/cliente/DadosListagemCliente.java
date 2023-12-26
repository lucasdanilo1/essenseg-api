package sistema.essenseg.dto.cliente;

import com.fasterxml.jackson.annotation.JsonFormat;
import sistema.essenseg.model.segurado.Segmentacao;
import sistema.essenseg.model.cliente.Cliente;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosListagemCliente(Long id,
                                   String nome,
                                   Long operadoraId,
                                   @JsonFormat(pattern = "dd/MM/yyyy")
                                   LocalDate vigencia,
                                   Long planoId,
                                   BigDecimal valorDoPlano,
                                   BigDecimal adesao,
                                   Segmentacao segmentacao) {

    public DadosListagemCliente(Cliente cliente){
        this(
                cliente.getId(),
                cliente.getDadosPessoaisSegurado().getNome(),
                cliente.getDadosContratacaoSegurado().getOperadora().getId(),
                cliente.getDadosContratacaoSegurado().getVigencia(),
                cliente.getDadosContratacaoSegurado().getPlano().getId(),
                cliente.getDadosContratacaoSegurado().getValorDoPlano(),
                cliente.getDadosContratacaoSegurado().getAdesao(),
                cliente.getDadosContratacaoSegurado().getSegmentacao()
        );
    }

}
