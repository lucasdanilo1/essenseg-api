package sistema.essenseg.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import sistema.essenseg.dto.segurado.FiltrosSeguradoDTO;
import sistema.essenseg.model.Segurado.Segurado;

public interface SeguradoRepository extends JpaRepository<Segurado, Long>, Repository<Segurado, Long> {

    @Query("""
            SELECT s
            FROM Segurado s
            WHERE (:#{#filtro.filtroGlobal} IS NULL
            OR s.dadosPessoaisSegurado.nome LIKE %:#{#filtro.filtroGlobal}%
            OR s.dadosEspecificosCliente.cpf LIKE %:#{#filtro.filtroGlobal}%
            OR s.dadosEspecificosEmpresa.nomeFantasia LIKE %:#{#filtro.filtroGlobal}%
            OR s.dadosEspecificosEmpresa.cnpj LIKE %:#{#filtro.filtroGlobal}%
            OR s.dadosEspecificosEmpresa.atvEconomica LIKE %:#{#filtro.filtroGlobal}%
            OR s.dadosEspecificosEmpresa.razaoSocial LIKE %:#{#filtro.filtroGlobal}%
            OR s.dadosPessoaisSegurado.email LIKE %:#{#filtro.filtroGlobal}%
            OR s.dadosPessoaisSegurado.telefone LIKE %:#{#filtro.filtroGlobal}%)
            AND (:#{#filtro.segmentacao} IS NULL OR s.dadosContratacaoSegurado.segmentacao = :#{#filtro.segmentacao})
            AND (:#{#filtro.administradoraId} IS NULL OR s.dadosContratacaoSegurado.administradora.id = :#{#filtro.administradoraId})
            AND (:#{#filtro.operadoraId} IS NULL OR s.dadosContratacaoSegurado.operadora.id = :#{#filtro.operadoraId})
            AND (:#{#filtro.primeiraDataVigencia} IS NULL OR s.dadosContratacaoSegurado.vigencia > :#{#filtro.primeiraDataVigencia})
            AND (:#{#filtro.segundaDataVigencia} IS NULL OR s.dadosContratacaoSegurado.vigencia < :#{#filtro.segundaDataVigencia})
            ORDER BY s.dadosPessoaisSegurado.nome ASC
            """)
    Page<Segurado> findAll(@Param("filtro") FiltrosSeguradoDTO filtros, Pageable pageable);

    @Override
    @Query("SELECT s FROM Segurado s ORDER BY s.dadosPessoaisSegurado.nome ASC")
    Page<Segurado> findAll(Pageable pageable);
}
