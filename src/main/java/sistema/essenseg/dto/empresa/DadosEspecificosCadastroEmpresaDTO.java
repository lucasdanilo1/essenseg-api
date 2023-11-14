package sistema.essenseg.dto.empresa;


import jakarta.validation.constraints.NotBlank;

public record DadosEspecificosCadastroEmpresaDTO(

        String razaoSocial,

        String nomeFantasia,

        @NotBlank
        String cnpj,

        String atvEconomica,

        String dataAbertura

) {
}
