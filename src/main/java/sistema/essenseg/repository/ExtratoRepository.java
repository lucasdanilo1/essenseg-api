package sistema.essenseg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sistema.essenseg.model.Extrato;

import java.util.Optional;

public interface ExtratoRepository extends JpaRepository<Extrato, Long> {
    boolean existsByRandomId(Long randomNumber);

    Optional<Extrato> findByRandomId(Long id);
}
