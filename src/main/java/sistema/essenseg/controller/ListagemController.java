package sistema.essenseg.controller;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sistema.essenseg.dto.clienteDTO.DadosListagemCliente;
import sistema.essenseg.dto.clienteDTO.FiltrosClienteDTO;
import sistema.essenseg.dto.empresaDTO.DadosListagemEmpresa;
import sistema.essenseg.model.Administradora;
import sistema.essenseg.model.Corretor;
import sistema.essenseg.model.Operadora;
import sistema.essenseg.service.*;

import java.util.List;

@RestController
@RequestMapping("listagem")
public class ListagemController {

    @Autowired
    OperadoraService operadoraService;
    @Autowired
    ClienteService clienteService;
    @Autowired
    AdministradoraService administradoraService;
    @Autowired
    CorretorService corretorService;
    @Autowired
    EmpresaService empresaService;

    @GetMapping("clientes")
    public ResponseEntity<Page<DadosListagemCliente>> clientes(Pageable page) {
        return clienteService.listar(page);
    }
    @GetMapping("empresas")
    public ResponseEntity<Page<DadosListagemEmpresa>> empresas(Pageable page) {
        return empresaService.listar(page);
    }

    @Transactional
    @PostMapping("clientes/filtrados")
    public ResponseEntity<Page<DadosListagemCliente>> clientesFiltrados(@RequestBody FiltrosClienteDTO filtros, Pageable page) {
        return clienteService.listarFiltrados(filtros, page);
    }

    @GetMapping("operadoras")
    public ResponseEntity<List<Operadora>> operadoras(){
        return operadoraService.listar();
    }


    @GetMapping("administradoras")
    public ResponseEntity<List<Administradora>> administradoras() {
        return administradoraService.listar();
    }

    @GetMapping("corretores")
    public ResponseEntity<List<Corretor>> corretores() {
        return corretorService.listar();
    }

}
