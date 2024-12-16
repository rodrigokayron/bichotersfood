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
                                  @RequestParam(value = "troco", required = false) String troco,
                                  Model model) {

        // Lógica para processar o pagamento, troco ou chave Pix
        carrinho.getItens().clear();
        model.addAttribute("status", "Aguardando Confirmação");
        
        if ("dinheiro".equals(formaPagamento) && troco != null) {
            model.addAttribute("troco", troco);
        }
        
        return "status-compra";
    }

    @GetMapping
    public String mostrarPaginaFinalizarCompra(Model model) {
        model.addAttribute("itensCarrinho", carrinho.getItens());
        model.addAttribute("total", carrinho.getTotal());  // Passando o total para o modelo
        return "finalizar-compra";
    }
}