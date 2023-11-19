package sistema.essenseg.dto.empresa;

import lombok.Getter;
import sistema.essenseg.dto.segurado.DadosSeguradoDetalhadoDTO;
import sistema.essenseg.model.empresa.Empresa;

@Getter
public class DadosEmpresaDetalhadaDTO {

    DadosSeguradoDetalhadoDTO dadosSeguradoDetalhadoDTO;

    DadosEspecificosEmpresaDetalhadaDTO dadosEspecificosEmpresaDetalhadaDTO;

    String observacoes;

    public DadosEmpresaDetalhadaDTO(Empresa empresa){
        this.dadosSeguradoDetalhadoDTO = new DadosSeguradoDetalhadoDTO(empresa.getDadosPessoaisSegurado(), empresa.getDadosContratacaoSegurado());
        this.dadosEspecificosEmpresaDetalhadaDTO = new DadosEspecificosEmpresaDetalhadaDTO(empresa.getDadosEspecificosEmpresa());
        this.observacoes = empresa.getObservacoes();
    }

}
