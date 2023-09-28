package sistema.essenseg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import sistema.essenseg.DTO.DadosClienteDTO.DadosClienteDTO;
import sistema.essenseg.DTO.FiltrosClienteDTO;
import sistema.essenseg.model.Administradora;
import sistema.essenseg.model.Operadora;
import sistema.essenseg.model.cliente.Cliente;
import sistema.essenseg.repository.AdministradoraRepository;
import sistema.essenseg.repository.ClienteRepository;
import sistema.essenseg.repository.OperadoraRepository;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    OperadoraRepository operadoraRepository;
    @Autowired
    AdministradoraRepository administradoraRepository;
    @Autowired
    ClienteRepository clienteRepository;

    public void cadastrarCliente(DadosClienteDTO dados){
        Operadora operadora = operadoraRepository.getReferenceById(dados.getDadosParaContratacaoCliente().getOperadoraId());
        Administradora administradora = administradoraRepository.getReferenceById(dados.getDadosParaContratacaoCliente().getAdministradoraId());
        Cliente cliente = new Cliente(dados);
        cliente.setOperadora(operadora);
        cliente.setAdministradora(administradora);
        clienteRepository.save(cliente);
    }

    public void carregarOperadoraEAdministradora(Model model){
        List<Operadora> operadoras = operadoraRepository.findAll();
        List<Administradora> administradoras = administradoraRepository.findAll();
        model.addAttribute("operadoras", operadoras);
        model.addAttribute("administradoras", administradoras);
    }

    public List<Cliente> carregarClientes(Model model){
        List<Cliente> clientes = clienteRepository.findAll();
        model.addAttribute("clientes", clientes);
        return clientes;
    }

    public List<Cliente> carregarClientesFiltrados(Model model, FiltrosClienteDTO filtros){
        List<Cliente> clientes = clienteRepository.findAllByFiltros(filtros.nome(), filtros.cpf(), filtros.email(), filtros.telefone(), filtros.administradoraId(), filtros.operadoraId());
        model.addAttribute("clientes", clientes);
        return clientes;
    }

}
