package sistema.essenseg.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import sistema.essenseg.dto.clienteDTO.FiltrosClienteDTO;
import sistema.essenseg.model.cliente.Cliente;
public interface ClienteRepository extends JpaRepository<Cliente, Long>, Repository<Cliente, Long> {

    @Query("""
            SELECT c
            FROM Cliente c
            WHERE (:#{#filtro.nome} IS NULL OR c.dadosPessoais.nome LIKE %:#{#filtro.nome}%)
            AND (:#{#filtro.cpf} IS NULL OR c.dadosPessoais.cpf LIKE %:#{#filtro.cpf}%)
            AND (:#{#filtro.email} IS NULL OR c.dadosPessoais.email LIKE %:#{#filtro.email}%)
            AND (:#{#filtro.telefone} IS NULL OR c.dadosPessoais.telefone LIKE %:#{#filtro.telefone}%)
            AND (:#{#filtro.segmentacao} IS NULL OR c.dadosContratacao.segmentacao = :#{#filtro.segmentacao})
            AND (:#{#filtro.administradoraId} IS NULL OR c.administradora.id = :#{#filtro.administradoraId})
            AND (:#{#filtro.operadoraId} IS NULL OR c.operadora.id = :#{#filtro.operadoraId})
            AND (:#{#filtro.primeiraData} IS NULL OR c.dadosContratacao.vigencia > :#{#filtro.primeiraData})
            AND (:#{#filtro.segundaData} IS NULL OR c.dadosContratacao.vigencia < :#{#filtro.segundaData})
            """)
    Page<Cliente> findAll(@Param("filtro") FiltrosClienteDTO filtros, Pageable pageable);

    boolean existsByDadosPessoaisCpf(String cpf);

}
