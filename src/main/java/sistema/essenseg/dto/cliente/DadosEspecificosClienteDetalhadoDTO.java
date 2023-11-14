package sistema.essenseg.dto.cliente;

import sistema.essenseg.model.cliente.DadosEspecificosCliente;

import java.math.BigDecimal;

public record DadosEspecificosClienteDetalhadoDTO(

       String cpf,

       String nomeResponsavel,

       String cpfResponsavel,

       BigDecimal peso,

       BigDecimal altura


) {
    public DadosEspecificosClienteDetalhadoDTO(DadosEspecificosCliente dados){
        this(dados.getCpf(), dados.getNomeResponsavel(), dados.getCpfResponsavel(), dados.getPeso(), dados.getAltura());
    }
}
