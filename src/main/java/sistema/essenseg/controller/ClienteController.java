package sistema.essenseg.controller;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import sistema.essenseg.dto.clienteDTO.DadosClienteDTO;
import sistema.essenseg.service.ClienteService;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    ClienteService service;

    @GetMapping("{id}")
    public ModelAndView cliente(@PathVariable Long id){
        return service.cliente(id);
    }

    @GetMapping("cadastro")
    public ModelAndView formulario(DadosClienteDTO dados){
        return service.carregarOperadoraEAdministradora();
    }

    @Transactional
    @PostMapping("cadastro/save")
    public ModelAndView cadastrar(@Valid DadosClienteDTO dados, @RequestParam("anexos") List<MultipartFile> listaDeAnexos){
        return service.cadastrarCliente(dados, listaDeAnexos);
    }

    @GetMapping("/{clienteId}/anexo/{anexoId}")
    public void downloadAnexos(@PathVariable Long clienteId, @PathVariable Long anexoId, HttpServletResponse response) throws IOException {
        service.downloadAnexos(clienteId, anexoId, response);
    }



}
