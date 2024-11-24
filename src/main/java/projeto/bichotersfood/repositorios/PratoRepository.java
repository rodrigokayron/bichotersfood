package projeto.bichotersfood.repositorios;

import projeto.bichotersfood.modelos.Prato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PratoRepository extends JpaRepository<Prato, Long> {
}
