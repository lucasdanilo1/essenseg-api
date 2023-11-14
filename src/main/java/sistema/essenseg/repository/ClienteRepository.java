package sistema.essenseg.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import sistema.essenseg.dto.cliente.FiltrosClienteDTO;
import sistema.essenseg.model.cliente.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>, Repository<Cliente, Long> {

    @Query("""
            SELECT c
            FROM Cliente c
            WHERE (:#{#filtro.nome} IS NULL OR c.dadosPessoaisSegurado.nome LIKE %:#{#filtro.nome}%)
            AND (:#{#filtro.cpf} IS NULL OR c.dadosEspecificosCliente.cpf LIKE %:#{#filtro.cpf}%)
            AND (:#{#filtro.email} IS NULL OR c.dadosPessoaisSegurado.email LIKE %:#{#filtro.email}%)
            AND (:#{#filtro.telefone} IS NULL OR c.dadosPessoaisSegurado.telefone LIKE %:#{#filtro.telefone}%)
            AND (:#{#filtro.segmentacao} IS NULL OR c.dadosContratacaoSegurado.segmentacao = :#{#filtro.segmentacao})
            AND (:#{#filtro.administradoraId} IS NULL OR c.dadosContratacaoSegurado.administradora.id = :#{#filtro.administradoraId})
            AND (:#{#filtro.operadoraId} IS NULL OR c.dadosContratacaoSegurado.operadora.id = :#{#filtro.operadoraId})
            AND (:#{#filtro.primeiraDataVigencia} IS NULL OR c.dadosContratacaoSegurado.vigencia > :#{#filtro.primeiraDataVigencia})
            AND (:#{#filtro.segundaDataVigencia} IS NULL OR c.dadosContratacaoSegurado.vigencia < :#{#filtro.segundaDataVigencia})
            """)
    Page<Cliente> findAll(@Param("filtro") FiltrosClienteDTO filtros, Pageable pageable);

}
