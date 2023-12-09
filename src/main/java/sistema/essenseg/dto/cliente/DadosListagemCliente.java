package sistema.essenseg.dto.cliente;

import sistema.essenseg.model.segurado.Segmentacao;
import sistema.essenseg.model.cliente.Cliente;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosListagemCliente(Long id, String nome, Long operadoraId, LocalDate vigencia, BigDecimal plano,
                                   BigDecimal adesao, Segmentacao segmentacao) {

    public DadosListagemCliente(Cliente cliente){
        this(cliente.getId(), cliente.getDadosPessoaisSegurado().getNome(), cliente.getDadosContratacaoSegurado().getOperadora().getId(),
                cliente.getDadosContratacaoSegurado().getVigencia(), cliente.getDadosContratacaoSegurado().getPlano(),
                cliente.getDadosContratacaoSegurado().getAdesao(), cliente.getDadosContratacaoSegurado().getSegmentacao());
    }

}
