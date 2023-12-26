package sistema.essenseg.dto.empresa;

import com.fasterxml.jackson.annotation.JsonFormat;
import sistema.essenseg.model.empresa.DadosEspecificosEmpresa;

import java.time.LocalDate;

public record DadosEspecificosEmpresaDetalhadaDTO(

        String razaoSocial,

        String nomeFantasia,

        String cnpj,

        String atvEconomica,

        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataAbertura

) {
    public DadosEspecificosEmpresaDetalhadaDTO(DadosEspecificosEmpresa dados) {
        this(dados.getRazaoSocial(), dados.getNomeFantasia(), dados.getCnpj(), dados.getAtvEconomica(),
                dados.getDataAbertura());
    }
}
