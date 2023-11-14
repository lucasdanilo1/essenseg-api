package sistema.essenseg.dto.empresa;

import sistema.essenseg.model.empresa.DadosEspecificosEmpresa;

import java.time.LocalDate;

public record DadosEspecificosEmpresaDetalhadaDTO(

        String razaoSocial,

        String nomeFantasia,

        String cnpj,

        String atvEconomica,

        LocalDate dataAbertura

) {
    public DadosEspecificosEmpresaDetalhadaDTO(DadosEspecificosEmpresa dados) {
        this(dados.getRazaoSocial(), dados.getNomeFantasia(), dados.getCnpj(), dados.getAtvEconomica(),
                dados.getDataAbertura());
    }
}
