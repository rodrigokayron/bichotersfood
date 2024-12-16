package projeto.bichotersfood.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto.bichotersfood.modelos.Prato;

public interface PratoRepository extends JpaRepository<Prato, Long> {
}