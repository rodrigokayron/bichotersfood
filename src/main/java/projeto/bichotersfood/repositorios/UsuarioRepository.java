package projeto.bichotersfood.repositorios;

import projeto.bichotersfood.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Usuario findByNomeUsuario(String nomeUsuario);
}