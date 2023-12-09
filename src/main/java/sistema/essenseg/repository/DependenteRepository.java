package sistema.essenseg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sistema.essenseg.model.dependente.Dependente;

public interface DependenteRepository extends JpaRepository<Dependente, Long> {
}
