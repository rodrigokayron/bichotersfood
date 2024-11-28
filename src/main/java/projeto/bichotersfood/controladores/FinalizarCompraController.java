package projeto.bichotersfood.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import projeto.bichotersfood.modelos.Carrinho;
import projeto.bichotersfood.modelos.Prato;

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

  
        carrinho.getItens().clear();

        model.addAttribute("mensagem", "Compra realizada com sucesso!");

        return "compra-finalizada";  
    }

    @GetMapping
    public String mostrarPaginaFinalizarCompra(Model model) {
        model.addAttribute("itensCarrinho", carrinho.getItens());
        model.addAttribute("total", carrinho.getTotal());
        return "finalizar-compra";  
    }
}
