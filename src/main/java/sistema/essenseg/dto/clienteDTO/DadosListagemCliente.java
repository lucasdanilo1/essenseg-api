package sistema.essenseg.dto.clienteDTO;

import sistema.essenseg.model.cliente.Cliente;
import sistema.essenseg.model.cliente.Segmentacao;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosListagemCliente(Long id, String nome, Long operadoraId, LocalDate vigencia, BigDecimal plano,
                                   BigDecimal adesao, Segmentacao segmentacao) {

    public DadosListagemCliente(Cliente cliente){
        this(cliente.getId(), cliente.getDadosPessoais().getNome(), cliente.getOperadora().getId(),
                cliente.getDadosContratacao().getVigencia(), cliente.getDadosContratacao().getPlano(),
                cliente.getDadosContratacao().getAdesao(), cliente.getDadosContratacao().getSegmentacao());
    }

}
