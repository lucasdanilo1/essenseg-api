package sistema.essenseg.model.cliente;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema.essenseg.DTO.DadosClienteDTO.DadosClienteDTO;
import sistema.essenseg.model.Administradora;
import sistema.essenseg.model.Operadora;

@Entity
@Getter
@Setter
@Table(name = "clientes")
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private DadosPessoais dadosPessoais;

    @Embedded
    private DadosContratacao dadosContratacao;

    @NotNull
    @ManyToOne
    private Operadora operadora;

    @NotNull
    @ManyToOne
    private Administradora administradora;

   public Cliente(DadosClienteDTO dados){
       this.dadosPessoais = new DadosPessoais(dados);
       this.dadosContratacao = new DadosContratacao(dados);
   }

}
