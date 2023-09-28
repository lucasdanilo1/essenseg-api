package sistema.essenseg.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sistema.essenseg.DTO.DadosClienteDTO.DadosClienteDTO;
import sistema.essenseg.DTO.FiltrosClienteDTO;
import sistema.essenseg.model.cliente.Cliente;
import sistema.essenseg.service.ClienteService;

import java.util.List;


@Controller
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    ClienteService service;

    @GetMapping("lista")
    public String clientes(Model model, DadosClienteDTO dados, FiltrosClienteDTO filtrosDTO) {
        service.carregarClientes(model);
        return "listaClientes";
    }

    @PostMapping("lista")
    public String clientesFiltrados(Model model, FiltrosClienteDTO filtrosDTO, DadosClienteDTO dados) {
        service.carregarClientesFiltrados(model, filtrosDTO);
        return "listaClientes";
    }

    @GetMapping("cadastro")
    public String formulario(Model model, DadosClienteDTO dados){
        service.carregarOperadoraEAdministradora(model);
        return "formulario";
    }

    @Transactional
    @PostMapping("cadastro/save")
    public String cadastrarCliente(@Valid DadosClienteDTO dados){
        service.cadastrarCliente(dados);
        return "redirect:/clientes/cadastro";
    }


}
