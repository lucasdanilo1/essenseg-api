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
            WHERE (:#{#filtro.nomeFantasia} IS NULL OR e.dadosEspecificosEmpresa.nomeFantasia LIKE %:#{#filtro.nomeFantasia}%)
            AND (:#{#filtro.cnpj} IS NULL OR e.dadosEspecificosEmpresa.cnpj LIKE %:#{#filtro.cnpj}%)
            AND (:#{#filtro.atvEconomica} IS NULL OR e.dadosEspecificosEmpresa.atvEconomica LIKE %:#{#filtro.atvEconomica}%)
            AND (:#{#filtro.nome} IS NULL OR e.dadosPessoaisSegurado.nome LIKE %:#{#filtro.nome}%)
            AND (:#{#filtro.razaoSocial} IS NULL OR e.dadosEspecificosEmpresa.razaoSocial LIKE %:#{#filtro.razaoSocial}%)
            AND (:#{#filtro.administradoraId} IS NULL OR e.dadosContratacaoSegurado.administradora.id = :#{#filtro.administradoraId})
            AND (:#{#filtro.operadoraId} IS NULL OR e.dadosContratacaoSegurado.operadora.id = :#{#filtro.operadoraId})
            AND (:#{#filtro.primeiraDataVigencia} IS NULL OR e.dadosContratacaoSegurado.vigencia > :#{#filtro.primeiraDataVigencia})
            AND (:#{#filtro.segundaDataVigencia} IS NULL OR e.dadosContratacaoSegurado.vigencia < :#{#filtro.segundaDataVigencia})
            """)
    Page<Empresa> findAll(@Param("filtro") FiltrosEmpresaDTO filtros, Pageable pageable);

}
