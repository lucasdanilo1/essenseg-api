package sistema.essenseg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sistema.essenseg.model.cliente.Cliente;
import sistema.essenseg.model.cliente.Segmentacao;

import java.time.LocalDate;
import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {


    @Query("""
    SELECT c
    FROM Cliente c
    WHERE (:nome IS NULL OR c.dadosPessoais.nome LIKE %:nome%)
    AND (:cpf IS NULL OR c.dadosPessoais.cpf LIKE %:cpf%)
    AND (:email IS NULL OR c.dadosPessoais.email LIKE %:email%)
    AND (:telefone IS NULL OR c.dadosPessoais.telefone LIKE %:telefone%)
    AND (:segmentacao IS NULL OR c.dadosContratacao.segmentacao = :segmentacao)
    AND (:administradoraId IS NULL OR c.administradora.id = :administradoraId)
    AND (:operadoraId IS NULL OR c.operadora.id = :operadoraId)
    AND (:primeiraData IS NULL OR c.dadosContratacao.vigencia > :primeiraData)
    AND (:segundaData IS NULL OR c.dadosContratacao.vigencia < :segundaData)
                """)
    List<Cliente> findAllByFiltros(String nome,
                                   String cpf,
                                   String email,
                                   String telefone,
                                   Segmentacao segmentacao,
                                   Long administradoraId,
                                   Long operadoraId, LocalDate primeiraData, LocalDate segundaData);

}
