package projeto.bichotersfood.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import projeto.bichotersfood.modelos.Carrinho;

@Controller
@RequestMapping("/finalizar-compra")
public class FinalizarCompraController {

    @Autowired
    private Carrinho carrinho;

    @PostMapping
    public String finalizarCompra(@RequestParam("formaPagamento") String formaPagamento,
                                  @RequestParam("horaRetirada") String horaRetirada,
                                  Model model) {

        System.out.println("Forma de Pagamento: " + formaPagamento);
        System.out.println("Hora de Retirada: " + horaRetirada);

        // Aqui você pode adicionar lógica para salvar o pedido no banco de dados
        carrinho.getItens().clear();

        // Redirecionando para a página de status da compra
        model.addAttribute("status", "Aguardando Confirmação"); // Pode mudar para "Pedido Pronto" conforme necessário
        return "status-compra";  // Nome da nova página de status
    }

    @GetMapping
    public String mostrarPaginaFinalizarCompra(Model model) {
        model.addAttribute("itensCarrinho", carrinho.getItens());
        model.addAttribute("total", carrinho.getTotal());
        return "finalizar-compra";
    }
}
