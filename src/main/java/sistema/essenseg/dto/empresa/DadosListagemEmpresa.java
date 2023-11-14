package sistema.essenseg.dto.empresa;

import sistema.essenseg.model.empresa.Empresa;

public record DadosListagemEmpresa(

        Long id,

        String nomeFantasia,

        String cnpj,

        String responsavelEmpresa,

        String email

) {

    public DadosListagemEmpresa(Empresa empresa){
        this(empresa.getId(), empresa.getDadosEspecificosEmpresa().getNomeFantasia(), empresa.getDadosEspecificosEmpresa().getCnpj(),
                empresa.getDadosPessoaisSegurado().getNome(), empresa.getDadosPessoaisSegurado().getEmail());
    }
}
