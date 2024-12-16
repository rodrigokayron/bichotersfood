package projeto.bichotersfood.repositorios;

import org.springframework.stereotype.Repository;
import projeto.bichotersfood.modelos.Pedido;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PedidoRepository {

	private List<Pedido> pedidos = new ArrayList<>();
	private Long idCounter = 1L;

	public void salvarPedido(Pedido pedido) {
		pedido.setId(idCounter++);
		pedidos.add(pedido);
	}

	public List<Pedido> encontrarTodosPedidos() {
		return pedidos;
	}

	public Pedido encontrarPorId(Long id) {
		return pedidos.stream().filter(pedido -> pedido.getId().equals(id)).findFirst().orElse(null);
	}

	public Object findAll() {
		return null;
	}
}