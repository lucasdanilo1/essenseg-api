package sistema.essenseg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sistema.essenseg.model.cliente.Cliente;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {


    @Query("""
            SELECT c
            FROM Cliente c
            WHERE (:nome IS NULL OR c.dadosPessoais.nome LIKE %:nome%)
            AND (:cpf IS NULL OR c.dadosPessoais.cpf LIKE %:cpf%)
            AND (:email IS NULL OR c.dadosPessoais.email LIKE %:email%)
            AND (:telefone IS NULL OR c.dadosPessoais.telefone LIKE %:telefone%)
            AND (:administradoraId IS NULL OR c.administradora.id = :administradoraid)
            AND (:operadoraId IS NULL OR c.operadora.id = :operadoraid)
            """)
    List<Cliente> findAllByFiltros(String nome,
                                   String cpf,
                                   String email,
                                   String telefone,
                                   Long administradoraId,
                                   Long operadoraId);
}
