package sistema.essenseg.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sistema.essenseg.dto.empresa.FiltrosEmpresaDTO;
import sistema.essenseg.model.empresa.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    @Query("""
            SELECT e
            FROM Empresa e
            WHERE (:#{#filtro.filtroGlobal} IS NULL
            OR e.dadosPessoaisSegurado.nome LIKE %:#{#filtro.filtroGlobal}%
            OR e.dadosEspecificosEmpresa.nomeFantasia LIKE %:#{#filtro.filtroGlobal}%
            OR e.dadosEspecificosEmpresa.cnpj LIKE %:#{#filtro.filtroGlobal}%
            OR e.dadosEspecificosEmpresa.atvEconomica LIKE %:#{#filtro.filtroGlobal}%
            OR e.dadosEspecificosEmpresa.razaoSocial LIKE %:#{#filtro.filtroGlobal}%)
            AND (:#{#filtro.administradoraId} IS NULL OR e.dadosContratacaoSegurado.administradora.id = :#{#filtro.administradoraId})
            AND (:#{#filtro.operadoraId} IS NULL OR e.dadosContratacaoSegurado.operadora.id = :#{#filtro.operadoraId})
            AND (:#{#filtro.primeiraDataVigencia} IS NULL OR e.dadosContratacaoSegurado.vigencia > :#{#filtro.primeiraDataVigencia})
            AND (:#{#filtro.segundaDataVigencia} IS NULL OR e.dadosContratacaoSegurado.vigencia < :#{#filtro.segundaDataVigencia})
            ORDER BY e.dadosEspecificosEmpresa.nomeFantasia ASC
            """)
    Page<Empresa> findAll(@Param("filtro") FiltrosEmpresaDTO filtros, Pageable pageable);

    @Override
    @Query("SELECT e FROM Empresa e ORDER BY e.dadosEspecificosEmpresa.nomeFantasia ASC")
    Page<Empresa> findAll(Pageable pageable);

    boolean existsByDadosEspecificosEmpresaCnpj(String cnpj);
}
