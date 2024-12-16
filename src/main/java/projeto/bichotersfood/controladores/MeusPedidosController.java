package projeto.bichotersfood.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import projeto.bichotersfood.modelos.Pedido;
import projeto.bichotersfood.repositorios.PedidoRepository;

@Controller
@RequestMapping("/meus-pedidos")
public class MeusPedidosController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping
	public String exibirMeusPedidos(Model model) {

		model.addAttribute("pedidos", pedidoRepository.findAll());
		return "meus-pedidos";
	}
}