package sistema.essenseg.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import sistema.essenseg.dto.empresa.*;
import sistema.essenseg.model.empresa.Empresa;
import sistema.essenseg.service.EmpresaService;

@RestController
@RequestMapping("empresa")
public class EmpresaController {

    @Autowired
    EmpresaService service;

    @Transactional
    @PostMapping("cadastro/save")
    public ResponseEntity<DadosEmpresaDetalhadaDTO> cadastro(@Valid @RequestBody DadosCadastroEmpresaDTO dados, UriComponentsBuilder uriBuilder) {
        Empresa empresa = service.cadastrar(dados);
        return ResponseEntity.created(
                uriBuilder.path("empresa/{id}")
                        .buildAndExpand(empresa.getId())
                        .toUri()
            ).body(new DadosEmpresaDetalhadaDTO(empresa));
    }

    @GetMapping("empresas")
    public ResponseEntity<Page<DadosListagemEmpresa>> empresas(Pageable page) {
        return ResponseEntity.ok().body(service.listar(page));
    }

    @Transactional
    @PostMapping("empresas/filtrados")
    public ResponseEntity<Page<DadosListagemEmpresa>> empresasFiltrados(@RequestBody FiltrosEmpresaDTO filtros, Pageable page) {
        return ResponseEntity.ok().body(service.listarFiltrados(filtros, page));
    }

    @GetMapping("{id}")
    public ResponseEntity<DadosEmpresaDetalhadaDTO> detalhar(@PathVariable Long id){
        return ResponseEntity.ok().body(service.detalhar(id));
    }

    @Transactional
    @PutMapping("{id}/atualizar")
    public ResponseEntity<DadosEmpresaDetalhadaDTO> atualizar(@PathVariable Long id, @Valid @RequestBody AtualizaDadosEmpresaDTO dados){
        return ResponseEntity.ok().body(service.atualizar(id, dados));
    }

    @Transactional
    @DeleteMapping("inativar/{id}")
    public ResponseEntity<DadosEmpresaDetalhadaDTO> inativar(@PathVariable Long id){
        return ResponseEntity.ok().body(service.inativar(id));
    }
}