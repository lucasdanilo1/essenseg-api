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
        String nomeCorretor,
        Long corretorId,
        String nomeOperadora,
        Long operadoraId,
        String nomeAdministradora,
        Long administradoraId,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate vigencia,
        String nomePlano,
        Long planoId,
        BigDecimal valorDoPlanoBruto,
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
                dadosContratacaoSegurado.getCorretor().getNome(),
                dadosContratacaoSegurado.getCorretor().getId(),
                dadosContratacaoSegurado.getOperadora().getNome(),
                dadosContratacaoSegurado.getOperadora().getId(),
                dadosContratacaoSegurado.getAdministradora().getNome(),
                dadosContratacaoSegurado.getAdministradora().getId(),
                dadosContratacaoSegurado.getVigencia(),
                dadosContratacaoSegurado.getPlano().getNome(),
                dadosContratacaoSegurado.getPlano().getId(),
                dadosContratacaoSegurado.getValorDoPlanoBruto(),
                dadosContratacaoSegurado.getAdesao(),
                dadosContratacaoSegurado.getSegmentacao()
        );
    }

}
