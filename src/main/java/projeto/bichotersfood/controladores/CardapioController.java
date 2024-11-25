package projeto.bichotersfood.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import projeto.bichotersfood.modelos.Carrinho;
import projeto.bichotersfood.modelos.Prato;
import projeto.bichotersfood.repositorios.PratoRepository;

@Controller
@RequestMapping("/cardapio")
public class CardapioController {

    @Autowired
    private PratoRepository pratoRepository;

    @Autowired
    private Carrinho carrinho;

    // Exibe todos os pratos disponíveis no cardápio
    @GetMapping
    public String mostrarCardapio(Model model) {
        model.addAttribute("pratos", pratoRepository.findAll());
        return "cardapio";  // A view cardapio será exibida
    }

    // Adiciona o prato ao carrinho e redireciona para a página do carrinho
    @PostMapping("/carrinho")
    public String adicionarAoCarrinho(@RequestParam("pratoId") Long pratoId, Model model) {
        Prato prato = pratoRepository.findById(pratoId).orElse(null);
        if (prato != null) {
            carrinho.adicionarPrato(prato);  // Adiciona o prato ao carrinho
        }
        return "redirect:/cardapio/carrinho";  // Redireciona para a página do carrinho
    }

    // Exibe os itens do carrinho
    @GetMapping("/carrinho")
    public String mostrarCarrinho(Model model) {
        model.addAttribute("itensCarrinho", carrinho.getItens());
        model.addAttribute("total", carrinho.getTotal());
        return "carrinho";  // Página do carrinho
    }
}
