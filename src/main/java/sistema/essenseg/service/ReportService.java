package sistema.essenseg.service;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;
import sistema.essenseg.dto.report.SeguradoSelecionado;
import sistema.essenseg.model.segurado.DadosContratacaoSegurado;
import sistema.essenseg.repository.ExtratoRepository;
import sistema.essenseg.repository.SeguradoRepository;
import sistema.essenseg.model.report.SeguradoParaDataSet;

import java.time.ZoneId;
import java.util.*;

@Service
public class ReportService {

    public static long gerarRandomId(Random random, ExtratoRepository repository) {
        long randomId = 100000 + random.nextLong(900000);

        while (repository.existsByRandomId(randomId)){
            randomId = 100000 + random.nextLong(900000);
        }

        return randomId;
    }

    public static JRBeanCollectionDataSource gerarDataSourceDosSeguradosSelecionados(List<SeguradoSelecionado> dados, SeguradoRepository repository) {

        List<SeguradoParaDataSet> dataset = new ArrayList<>();

        for (SeguradoSelecionado seguradoSelecionado : dados) {

            DadosContratacaoSegurado dadosContratacaoSegurado =
                    repository.getReferenceById(seguradoSelecionado.clienteId()).getDadosContratacaoSegurado();

            SeguradoParaDataSet seguradoParaDataSet = new SeguradoParaDataSet(
                    dadosContratacaoSegurado.getCorretor().getNome(),
                    repository.getReferenceById(seguradoSelecionado.clienteId()).getDadosPessoaisSegurado().getNome(),
                    Date.from(dadosContratacaoSegurado.getVigencia().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()),
                    dadosContratacaoSegurado.getPlano().getNome(),
                    dadosContratacaoSegurado.getOperadora().getNome(),
                    dadosContratacaoSegurado.getAdministradora().getNome(),
                    dadosContratacaoSegurado.getValorDoPlanoBruto(),
                    dadosContratacaoSegurado.getPercentualComissaoDaOperadora(),
                    seguradoSelecionado.percentualComissaoDoCorretor(),
                    seguradoSelecionado.percentualDoImposto()
            );
            dataset.add(seguradoParaDataSet);
//            if(!seguradoDuplicado(dataset, seguradoParaDataSet)){
//                dataset.add(seguradoParaDataSet);
//            }
        }
        return new JRBeanCollectionDataSource(dataset);
    }

    public static Map<String, Object> definirParametros(JRBeanCollectionDataSource dataSource, String nomeCorretor, long randomId) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("ID", randomId);
        parameters.put("NOME_CORRETOR", nomeCorretor);
        parameters.put("DADOS_DOS_CLIENTES_SELECIONADOS", dataSource);
        parameters.put("imagemPath", "classpath:/img/logo.png");

        return parameters;
    }

    private static boolean seguradoDuplicado(List<SeguradoParaDataSet> dataset, SeguradoParaDataSet segurado) {
        for (SeguradoParaDataSet data : dataset) {
            if (data.getNomeSegurado().equals(segurado.getNomeSegurado())) {
                return true;
            }
        }
        return false;
    }
}
