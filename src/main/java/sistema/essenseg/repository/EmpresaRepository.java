package sistema.essenseg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sistema.essenseg.model.empresa.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
