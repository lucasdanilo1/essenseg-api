package sistema.essenseg.dto.empresaDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;
import sistema.essenseg.model.empresa.Empresa;


public record DadosListagemEmpresa(

        Long id,

        String nomeFantasia,

        @CNPJ
        @NotBlank
        String cnpj,

        @NotBlank
        String responsavelEmpresa,

        @Email
        String email

) {

    public DadosListagemEmpresa(Empresa empresa){
        this(empresa.getId(), empresa.getDadosEmpresa().getNomeFantasia(), empresa.getDadosEmpresa().getCnpj(),
                empresa.getDadosEmpresa().getResponsavel(), empresa.getDadosEmpresa().getEmail());
    }

}
