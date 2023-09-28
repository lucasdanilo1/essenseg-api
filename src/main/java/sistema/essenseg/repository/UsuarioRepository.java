package sistema.essenseg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sistema.essenseg.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByUsuario(String usuario);

}
