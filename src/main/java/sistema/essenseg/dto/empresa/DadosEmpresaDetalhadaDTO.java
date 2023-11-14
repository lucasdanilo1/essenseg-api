package sistema.essenseg.dto.empresa;

import lombok.Getter;
import sistema.essenseg.model.Segurado.DadosSeguradoDetalhado;
import sistema.essenseg.model.empresa.Empresa;

@Getter
public class DadosEmpresaDetalhadaDTO {

    DadosSeguradoDetalhado dadosSeguradoDetalhado;

    DadosEspecificosEmpresaDetalhadaDTO dadosEspecificosEmpresaDetalhadaDTO;

    String observacoes;

    public DadosEmpresaDetalhadaDTO(Empresa empresa){
        this.dadosSeguradoDetalhado = new DadosSeguradoDetalhado(empresa.getDadosPessoaisSegurado(), empresa.getDadosContratacaoSegurado());
        this.dadosEspecificosEmpresaDetalhadaDTO = new DadosEspecificosEmpresaDetalhadaDTO(empresa.getDadosEspecificosEmpresa());
    }

}
