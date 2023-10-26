package sistema.essenseg.dto.empresaDTO;

import lombok.Getter;
import lombok.Setter;
import sistema.essenseg.model.empresa.DadosEmpresa;
import sistema.essenseg.model.empresa.Empresa;

import java.time.LocalDate;

@Getter
@Setter
public class DadosEmpresaDetalhada {

    private LocalDate dataDoCadastro;

    private DadosEmpresa dadosEmpresa;

    public DadosEmpresaDetalhada(Empresa empresa){
        this.dataDoCadastro = empresa.getDataDoCadastro();
        this.dadosEmpresa = empresa.getDadosEmpresa();
    }

}
