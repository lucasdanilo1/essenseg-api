package sistema.essenseg.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sistema.essenseg.dto.cliente.*;
import sistema.essenseg.model.exception.*;
import sistema.essenseg.model.cliente.Cliente;
import sistema.essenseg.repository.ClienteRepository;
import sistema.essenseg.repository.OperadoraRepository;
import sistema.essenseg.repository.PlanoRepository;
import sistema.essenseg.util.SeguradoServiceUtil;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;
    @Autowired
    private SeguradoServiceUtil seguradoServiceUtil;
    @Autowired
    private OperadoraRepository operadoraRepository;
    @Autowired
    private PlanoRepository planoRepository;


    @Transactional
    public Cliente cadastrar(DadosCadastroClienteDTO dados) {
        if(dados.dadosEspecificosCadastroClienteDTO() != null){
            if(this.repository.existsByDadosEspecificosClienteCpf(dados.dadosEspecificosCadastroClienteDTO().cpf())){
                throw new DataIntegrityViolationException("CPF já cadastrado");
            }
        }

        long qtdDeLinhasCorrespondentes = planoRepository.countByIdAndOperadoraId(dados.dadosParaContratacaoSeguradoDTO().planoId(),
                dados.dadosParaContratacaoSeguradoDTO().operadoraId());

       if(qtdDeLinhasCorrespondentes == 0){
           throw new DataIntegrityViolationException("Plano não faz parte da Operadora");
       }

        var cliente = new Cliente(dados);

        seguradoServiceUtil.defineOperadoraPorId(cliente, dados.dadosParaContratacaoSeguradoDTO().operadoraId());
        seguradoServiceUtil.defineAdministradoraPorId(cliente, dados.dadosParaContratacaoSeguradoDTO().administradoraId());
        seguradoServiceUtil.defineCorretorPorId(cliente, dados.dadosParaContratacaoSeguradoDTO().corretorId());
        seguradoServiceUtil.definePlanoPorId(cliente, dados.dadosParaContratacaoSeguradoDTO().planoId());

        repository.save(cliente);
        return cliente;
    }

    public DadosClienteDetalhadoDTO atualizar(Long id, AtualizaDadosClienteDTO dados) {

        var cliente = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Segurado não encontrado"));

        seguradoServiceUtil.defineOperadoraPorId(cliente, dados.atualizaDadosSeguradoDTO().operadoraId());
        seguradoServiceUtil.defineAdministradoraPorId(cliente, dados.atualizaDadosSeguradoDTO().administradoraId());
        seguradoServiceUtil.definePlanoPorId(cliente, dados.atualizaDadosSeguradoDTO().planoId());

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
