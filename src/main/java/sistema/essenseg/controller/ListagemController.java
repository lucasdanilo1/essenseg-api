package sistema.essenseg.controller;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sistema.essenseg.dto.segurado.DadosListagemSeguradoDTO;
import sistema.essenseg.dto.cliente.DadosListagemCliente;
import sistema.essenseg.dto.cliente.FiltrosClienteDTO;
import sistema.essenseg.dto.empresa.DadosListagemEmpresa;
import sistema.essenseg.dto.empresa.FiltrosEmpresaDTO;
import sistema.essenseg.model.Administradora;
import sistema.essenseg.model.Corretor;
import sistema.essenseg.model.Operadora;
import sistema.essenseg.model.cliente.Cliente;
import sistema.essenseg.model.empresa.Empresa;
import sistema.essenseg.repository.ClienteRepository;
import sistema.essenseg.repository.EmpresaRepository;
import sistema.essenseg.service.*;

import java.util.ArrayList;
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

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    EmpresaRepository empresaRepository;

    @Transactional
    @GetMapping("segurados")
    public ResponseEntity<?> segurados(Pageable page) {

        Page<Cliente> pageClientes = clienteRepository.findAll(page);
        Page<Empresa> pageEmpresas = empresaRepository.findAll(page);

        List<DadosListagemSeguradoDTO> listaClientes = pageClientes.getContent().stream().map(DadosListagemSeguradoDTO::new).toList();
        List<DadosListagemSeguradoDTO> listaEmpresas = pageEmpresas.getContent().stream().map(DadosListagemSeguradoDTO::new).toList();

        List<DadosListagemSeguradoDTO> listaCombinada = new ArrayList<>(listaClientes);
        listaCombinada.addAll(listaEmpresas);

        Page<DadosListagemSeguradoDTO> pageCombinada = new PageImpl<>(listaCombinada, page, listaClientes.size());

        return ResponseEntity.ok(pageCombinada);

    }

    @GetMapping("clientes")
    public ResponseEntity<Page<DadosListagemCliente>> clientes(Pageable page) {
        return clienteService.listar(page);
    }

    @Transactional
    @PostMapping("clientes/filtrados")
    public ResponseEntity<Page<DadosListagemCliente>> clientesFiltrados(@RequestBody FiltrosClienteDTO filtros, Pageable page) {
        return clienteService.listarFiltrados(filtros, page);
    }

    @GetMapping("empresas")
    public ResponseEntity<Page<DadosListagemEmpresa>> empresas(Pageable page) {
        return empresaService.listar(page);
    }
    @Transactional
    @PostMapping("empresas/filtrados")
    public ResponseEntity<Page<DadosListagemEmpresa>> empresasFiltrados(@RequestBody FiltrosEmpresaDTO filtros, Pageable page) {
        return empresaService.listarFiltrados(filtros, page);
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
