package sistema.essenseg.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sistema.essenseg.dto.clienteDTO.DadosClienteDTO;
import sistema.essenseg.model.cliente.Cliente;
import sistema.essenseg.model.cliente.Segmentacao;
import sistema.essenseg.repository.AdministradoraRepository;
import sistema.essenseg.repository.ClienteRepository;
import sistema.essenseg.repository.OperadoraRepository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ClienteServiceUtil {

    @Autowired
    private OperadoraRepository operadoraRepository;
    @Autowired
    private AdministradoraRepository administradoraRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    public Map<String, List<?>> listasParaFiltragem() {
        var operadoras = operadoraRepository.findAll();
        var administradoras = administradoraRepository.findAll();

        Map<String, List<?>> listas = new HashMap<>();

        listas.put("operadoras", operadoras);
        listas.put("administradoras", administradoras);
        listas.put("segmentacoes", Arrays.asList(Segmentacao.values()));
        return listas;
    }
    public Cliente novoObjCliente(DadosClienteDTO dados){
        var operadora = operadoraRepository.getReferenceById(dados.dadosParaContratacaoClienteDTO().operadoraId());
        var administradora = administradoraRepository.getReferenceById(dados.dadosParaContratacaoClienteDTO().operadoraId());
        return new Cliente(dados, operadora, administradora);
    }

}
