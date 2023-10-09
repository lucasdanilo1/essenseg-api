package sistema.essenseg.service;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import sistema.essenseg.dto.clienteDTO.DadosClienteDTO;
import sistema.essenseg.dto.clienteDTO.FiltrosClienteDTO;
import sistema.essenseg.model.Administradora;
import sistema.essenseg.model.Operadora;
import sistema.essenseg.model.cliente.Cliente;
import sistema.essenseg.model.cliente.Segmentacao;
import sistema.essenseg.repository.AdministradoraRepository;
import sistema.essenseg.repository.ClienteRepository;
import sistema.essenseg.repository.OperadoraRepository;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private OperadoraRepository operadoraRepository;
    @Autowired
    private AdministradoraRepository administradoraRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private AnexoService anexoService;

    public ModelAndView cliente(Long id){
        ModelAndView mv = new ModelAndView("cliente");
        var cliente = clienteRepository.getReferenceById(id);

        mv.addObject("cliente", cliente);
        return mv;
    }

    public void downloadAnexos(Long clienteId, Long anexoId, HttpServletResponse response) throws IOException {

        var cliente = clienteRepository.getReferenceById(clienteId);

        var anexo = cliente.getAnexos().get(anexoId.intValue());

        response.setHeader("Content-Disposition", "attachment; filename=" + anexo.getNome());
        response.setContentType(anexo.getType());

        response.getOutputStream().write(anexo.getAnexoData());
    }

    @Transactional
    public ModelAndView cadastrarCliente(DadosClienteDTO dados, @RequestParam("anexos") List<MultipartFile> listaDeAnexos) {

        Operadora operadora = operadoraRepository.getReferenceById(dados.getDadosParaContratacaoCliente().getOperadoraId());
        Administradora administradora = administradoraRepository.getReferenceById(dados.getDadosParaContratacaoCliente().getAdministradoraId());
        Cliente cliente = new Cliente(dados, operadora, administradora);
        clienteRepository.save(cliente);

            try {
                anexoService.uploadDeAnexo(listaDeAnexos, cliente);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        return new ModelAndView("redirect:/clientes/cadastro");
    }

    public ModelAndView carregarOperadoraEAdministradora(){
        ModelAndView mv = new ModelAndView("formulario");
        var operadoras = operadoraRepository.findAll();
        var administradoras = administradoraRepository.findAll();

        mv.addObject("operadoras", operadoras);
        mv.addObject("administradoras", administradoras);
        return mv;
    }

    public ModelAndView clientes(FiltrosClienteDTO filtros){
        ModelAndView mv = new ModelAndView("listas/listaClientes");
        var clientes = clienteRepository.findAll();
        var operadoras = operadoraRepository.findAll();
        var administradoras = administradoraRepository.findAll();

        mv.addObject("segmentacoes", Arrays.asList(Segmentacao.values()));
        mv.addObject("clientes", clientes);
        mv.addObject("operadoras", operadoras);
        mv.addObject("administradoras", administradoras);
        return mv;
    }

    public ModelAndView clientesFiltrados(FiltrosClienteDTO filtros){

        ModelAndView mv = new ModelAndView("listas/listaClientes");

        var clientes = clienteRepository.findAllByFiltros(filtros.getNome(), filtros.getCpf(), filtros.getEmail(),
                filtros.getTelefone(), filtros.getSegmentacao(), filtros.getAdministradoraId(), filtros.getOperadoraId(), filtros.getPrimeiraData(), filtros.getSegundaData());

        var operadoras = operadoraRepository.findAll();
        var administradoras = administradoraRepository.findAll();

        mv.addObject("segmentacoes", Arrays.asList(Segmentacao.values()));
        mv.addObject("clientes", clientes);
        mv.addObject("operadoras", operadoras);
        mv.addObject("administradoras", administradoras);
        return mv;
    }

}
