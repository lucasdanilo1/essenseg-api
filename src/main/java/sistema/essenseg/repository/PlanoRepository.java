package sistema.essenseg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sistema.essenseg.model.Plano;

import java.util.List;

public interface PlanoRepository extends JpaRepository<Plano, Long> {
    @Query("SELECT p FROM Plano p WHERE p.operadora.id = :id")
    List<Plano> findAllByOperadoraId(@Param("id") Long id);

    long countByIdAndOperadoraId(Long id, Long operadoraId);

    boolean existsByNome(String nome);
}
