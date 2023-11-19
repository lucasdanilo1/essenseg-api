package sistema.essenseg.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sistema.essenseg.dto.cliente.FiltrosClienteDTO;
import sistema.essenseg.model.cliente.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("""
            SELECT c
            FROM Cliente c
            WHERE (:#{#filtro.filtroGlobal} IS NULL
            OR c.dadosPessoaisSegurado.nome LIKE %:#{#filtro.filtroGlobal}%
            OR c.dadosEspecificosCliente.cpf LIKE %:#{#filtro.filtroGlobal}%
            OR c.dadosPessoaisSegurado.email LIKE %:#{#filtro.filtroGlobal}%
            OR c.dadosPessoaisSegurado.telefone LIKE %:#{#filtro.filtroGlobal}%)
            AND (:#{#filtro.segmentacao} IS NULL OR c.dadosContratacaoSegurado.segmentacao = :#{#filtro.segmentacao})
            AND (:#{#filtro.administradoraId} IS NULL OR c.dadosContratacaoSegurado.administradora.id = :#{#filtro.administradoraId})
            AND (:#{#filtro.operadoraId} IS NULL OR c.dadosContratacaoSegurado.operadora.id = :#{#filtro.operadoraId})
            AND (:#{#filtro.primeiraDataVigencia} IS NULL OR c.dadosContratacaoSegurado.vigencia > :#{#filtro.primeiraDataVigencia})
            AND (:#{#filtro.segundaDataVigencia} IS NULL OR c.dadosContratacaoSegurado.vigencia < :#{#filtro.segundaDataVigencia})
            ORDER BY c.dadosPessoaisSegurado.nome ASC
            """)
    Page<Cliente> findAll(@Param("filtro") FiltrosClienteDTO filtros, Pageable pageable);

    @Override
    @Query("SELECT c FROM Cliente c ORDER BY c.dadosPessoaisSegurado.nome ASC")
    Page<Cliente> findAll(Pageable pageable);

    boolean existsByDadosEspecificosClienteCpf(String cpf);
}
