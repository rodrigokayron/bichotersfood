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

        // Exibir ou processar as informações
        System.out.println("Forma de Pagamento: " + formaPagamento);
        System.out.println("Hora de Retirada: " + horaRetirada);

        // Exemplo: Pode-se adicionar a compra ao banco de dados, gerar um pedido, etc.
        // Aqui você pode salvar a compra no banco, gerar um pedido, etc.
        
        // Limpar o carrinho após a compra
        carrinho.getItens().clear();

        // Exibir uma mensagem de confirmação
        model.addAttribute("mensagem", "Compra realizada com sucesso!");

        return "compra-finalizada";  // Redireciona para a página de confirmação ou para uma nova tela
    }

    @GetMapping
    public String mostrarPaginaFinalizarCompra(Model model) {
        model.addAttribute("itensCarrinho", carrinho.getItens());
        model.addAttribute("total", carrinho.getTotal());
        return "finalizar-compra";  // Exibe a página de finalização da compra
    }
}
