package sistema.essenseg.service;

import net.sf.jasperreports.engine.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sistema.essenseg.dto.report.DadosListagemExtrato;
import sistema.essenseg.dto.report.SeguradoSelecionado;
import sistema.essenseg.model.Corretor;
import sistema.essenseg.model.Extrato;
import sistema.essenseg.model.exception.CorretorNaoTemClientes;
import sistema.essenseg.model.exception.GerarRelatorioException;
import sistema.essenseg.model.exception.ObjectNotFoundException;
import sistema.essenseg.repository.CorretorRepository;
import sistema.essenseg.repository.ExtratoRepository;
import sistema.essenseg.repository.SeguradoRepository;
import sistema.essenseg.util.DocData;

import java.time.LocalDate;
import java.util.*;

import static sistema.essenseg.service.ReportService.*;

@Service
public class ExtratoReportService {

    @Autowired
    private CorretorRepository corretorRepository;

    @Autowired
    private ExtratoRepository extratoRepository;

    @Autowired
    private SeguradoRepository seguradoRepository;

    public DocData gerarExtratoReport(Long id, List<SeguradoSelecionado> dados) {

        if(corretorRepository.getReferenceById(id).getSegurados().isEmpty()){
            throw new CorretorNaoTemClientes();
        }

        String jasperReport = "src/main/resources/relatorios/relatorio.jasper";

        JasperPrint jasperPrint;
        ByteArrayResource resource;

        var dataSource = gerarDataSourceDosSeguradosSelecionados(dados, seguradoRepository);

        var corretor = corretorRepository.getReferenceById(id);

        var randomId = gerarRandomId(new Random(), extratoRepository);

        try {
            jasperPrint = JasperFillManager.fillReport(
                    jasperReport,
                    definirParametros(dataSource, corretor.getNome(), randomId),
                    new JREmptyDataSource());
            resource = new ByteArrayResource(JasperExportManager.exportReportToPdf(jasperPrint));
        } catch (JRException e) {
            throw new GerarRelatorioException();
        }

        saveExtratoReport(randomId, corretor, resource.getByteArray());

        return new DocData(corretor.getNome(), resource.contentLength(), resource);
    }

    public void saveExtratoReport(long randomId, Corretor corretor, byte[] resource){
        var extrato = new Extrato(
                null,
                randomId,
                LocalDate.now() + "-" + corretor.getNome(),
                corretor,
                LocalDate.now(),
                resource
        );
        corretor.getExtratos().add(extrato);
        extratoRepository.save(extrato);
    }

    public Page<DadosListagemExtrato> listar(Pageable page){
        return extratoRepository.findAll(page).map(DadosListagemExtrato::new);
    }

    public DocData downloadExtrato(Long id) {
        var extrato = extratoRepository.findByRandomId(id).orElseThrow(() -> new ObjectNotFoundException("Extrato não encontrado"));

        ByteArrayResource resource = new ByteArrayResource(extrato.getExtratoData());

        return new DocData(extrato.getNome(), resource.contentLength(), resource);
    }
}