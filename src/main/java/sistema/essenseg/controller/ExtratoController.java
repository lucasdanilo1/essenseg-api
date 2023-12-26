package sistema.essenseg.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sistema.essenseg.dto.report.DadosListagemExtrato;
import sistema.essenseg.dto.report.SeguradoSelecionado;
import sistema.essenseg.service.ExtratoReportService;
import sistema.essenseg.util.DocData;

import java.util.List;

@RestController
@RequestMapping("extrato")
public class ExtratoController {

    @Autowired
    ExtratoReportService extratoReportService;

    @PostMapping("gerar/corretor/{id}")
    @Transactional
    public ResponseEntity<Resource> gerarExtratoPdf(@PathVariable Long id, @RequestBody @Valid List<SeguradoSelecionado> dados){
        DocData docData = extratoReportService.gerarExtratoReport(id, dados);
        return ResponseEntity.ok()
                .headers(docData.getHeaders())
                .contentLength(docData.getContentLength())
                .body(docData.getResource());
    }

    @GetMapping("listagem")
    public ResponseEntity<Page<DadosListagemExtrato>> listar(@PageableDefault(size = 50) Pageable page){
        return ResponseEntity.ok().body(extratoReportService.listar(page));
    }

    @GetMapping("download/{id}")
    public ResponseEntity<Resource> downloadExtrato(@PathVariable Long id){
        DocData docData = extratoReportService.downloadExtrato(id);
        return ResponseEntity.ok()
                .headers(docData.getHeaders())
                .contentLength(docData.getContentLength())
                .body(docData.getResource());
    }
}
