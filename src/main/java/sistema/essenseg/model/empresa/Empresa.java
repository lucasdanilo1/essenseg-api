package sistema.essenseg.model.empresa;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema.essenseg.dto.empresaDTO.DadosEmpresaDTO;
import sistema.essenseg.model.cliente.Cliente;

import java.time.LocalDate;


@Entity
@Getter
@Setter
@Table(name = "empresas")
@AllArgsConstructor
@NoArgsConstructor
public class Empresa extends Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataDoCadastro;

    @Embedded
    private DadosEmpresa dadosEmpresa;


    public Empresa(DadosEmpresaDTO dados){
       this.dataDoCadastro = LocalDate.now();
       this.dadosEmpresa = new DadosEmpresa(dados);
    }

}