package sistema.essenseg.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sistema.essenseg.dto.cliente.*;
import sistema.essenseg.infra.Exception.ClienteJaCadastradoException;
import sistema.essenseg.model.cliente.Cliente;
import sistema.essenseg.repository.ClienteRepository;
import sistema.essenseg.util.SeguradoServiceUtil;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;
    @Autowired
    private SeguradoServiceUtil seguradoServiceUtil;

    @Transactional
    public Cliente cadastrar(DadosCadastroClienteDTO dados) {
        if(repository.existsByDadosEspecificosClienteCpf(dados.dadosEspecificosCadastroClienteDTO().cpf())){
            throw new ClienteJaCadastradoException();
        }

        var cliente = new Cliente(dados);

        seguradoServiceUtil.defineOperadora(cliente, dados.dadosParaContratacaoSeguradoDTO().operadoraId());
        seguradoServiceUtil.defineAdministradora(cliente, dados.dadosParaContratacaoSeguradoDTO().administradoraId());
        seguradoServiceUtil.defineCorretor(cliente, dados.dadosParaContratacaoSeguradoDTO().corretorId());

        repository.save(cliente);
        return cliente;
    }

    public DadosClienteDetalhadoDTO atualizar(Long id, AtualizaDadosClienteDTO dados) {

        if(repository.existsByDadosEspecificosClienteCpf(dados.atualizaDadosEspecificosClienteDTO().cpf())){
            throw new ClienteJaCadastradoException();
        }

        var cliente = repository.getReferenceById(id);
        seguradoServiceUtil.atualizaOperadoraOuAdministradora(cliente, dados.atualizaDadosSeguradoDTO());
        cliente.atualizarInformacoes(dados);

        return new DadosClienteDetalhadoDTO(cliente);
    }

    public DadosClienteDetalhadoDTO detalhar(Long id){
        return new DadosClienteDetalhadoDTO(repository.getReferenceById(id));
    }

    public Page<DadosListagemCliente> listar(Pageable page){
        return repository.findAll(page).map(DadosListagemCliente::new);
    }

    public Page<DadosListagemCliente> listarFiltrados(FiltrosClienteDTO filtros, Pageable page){
        return repository.findAll(filtros, page).map(DadosListagemCliente::new);
    }

    public DadosClienteDetalhadoDTO inativar(Long id) {
        var cliente = repository.getReferenceById(id);
        cliente.setAtivo(false);
        return new DadosClienteDetalhadoDTO(cliente);
    }
}
