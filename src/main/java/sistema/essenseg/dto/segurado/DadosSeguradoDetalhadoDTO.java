package sistema.essenseg.dto.segurado;

import com.fasterxml.jackson.annotation.JsonFormat;
import sistema.essenseg.model.segurado.DadosContratacaoSegurado;
import sistema.essenseg.model.segurado.DadosPessoaisSegurado;
import sistema.essenseg.model.segurado.Segmentacao;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosSeguradoDetalhadoDTO(

        String nome,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataNascimento,
        String telefone,
        String cep,
        String endereco,
        String email,
        Long corretorId,
        Long operadoraId,
        Long administradoraId,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate vigencia,
        Long planoId,
        BigDecimal valorDoPlanoBruto,
        BigDecimal percentualComissaoDaOperadora,
        BigDecimal adesao,
        Segmentacao segmentacao

) {
    public DadosSeguradoDetalhadoDTO(DadosPessoaisSegurado dadosPessoaisSegurado, DadosContratacaoSegurado dadosContratacaoSegurado){
        this(
                dadosPessoaisSegurado.getNome(),
                dadosPessoaisSegurado.getDataNascimento(),
                dadosPessoaisSegurado.getTelefone(),
                dadosPessoaisSegurado.getCep(),
                dadosPessoaisSegurado.getEndereco(),
                dadosPessoaisSegurado.getEmail(),
                dadosContratacaoSegurado.getCorretor().getId(),
                dadosContratacaoSegurado.getOperadora().getId(),
                dadosContratacaoSegurado.getAdministradora().getId(),
                dadosContratacaoSegurado.getVigencia(),
                dadosContratacaoSegurado.getPlano().getId(),
                dadosContratacaoSegurado.getValorDoPlanoBruto(),
                dadosContratacaoSegurado.getPercentualComissaoDaOperadora(),
                dadosContratacaoSegurado.getAdesao(),
                dadosContratacaoSegurado.getSegmentacao()
        );
    }

}
