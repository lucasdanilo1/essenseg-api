package sistema.essenseg.controller;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sistema.essenseg.dto.administradoraDTO.FiltrosAdministradorasDTO;
import sistema.essenseg.dto.clienteDTO.FiltrosClienteDTO;
import sistema.essenseg.dto.operadoraDTO.FiltrosOperadorasDTO;
import sistema.essenseg.service.AdministradoraService;
import sistema.essenseg.service.ClienteService;
import sistema.essenseg.service.OperadoraService;

@Controller
@RequestMapping("listagem")
public class ListagemController {

    @Autowired
    OperadoraService operadoraService;
    @Autowired
    ClienteService clienteService;
    @Autowired
    AdministradoraService administradoraService;

    @GetMapping("clientes")
    public ModelAndView clientes(FiltrosClienteDTO filtros) {
        return clienteService.clientes(filtros);
    }

    @Transactional
    @PostMapping("clientes/filtrados")
    public ModelAndView clientesFiltrados(FiltrosClienteDTO filtros) {
        return clienteService.clientesFiltrados(filtros);
    }

    @GetMapping("operadoras")
    public ModelAndView operadoras(){
        return operadoraService.operadoras();
    }

    @Transactional
    @PostMapping("operadoras/filtradas")
    public ModelAndView operadorasFiltradas(FiltrosOperadorasDTO filtros) {
        return operadoraService.operadorasFiltradas(filtros);
    }

    @GetMapping("administradoras")
    public ModelAndView administradoras() {
        return administradoraService.administradoras();
    }

    @Transactional
    @PostMapping("administradoras/filtradas")
    public ModelAndView administradorasFiltradas(FiltrosAdministradorasDTO filtros) {
        return administradoraService.administradorasFiltradas(filtros);
    }


}
