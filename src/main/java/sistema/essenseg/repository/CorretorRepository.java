package sistema.essenseg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sistema.essenseg.model.Corretor;

public interface CorretorRepository extends JpaRepository<Corretor, Long> {
    boolean existsByNome(String nome);
}
