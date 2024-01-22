package sistema.essenseg.dto.report;

import sistema.essenseg.model.Extrato;

import java.time.LocalDate;

public record DadosListagemExtrato(

        Long identificador,
        String nome,
        LocalDate dataCriacao,
        String corretor

) {
    public DadosListagemExtrato(Extrato extrato){
        this(extrato.getRandomId(), extrato.getNomeArquivo(), extrato.getDataCriacao(), extrato.getCorretor().getNome());
    }
}
