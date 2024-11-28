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

    @GetMapping
    public String mostrarCardapio(Model model) {
        model.addAttribute("pratos", pratoRepository.findAll());
        return "cardapio";  
    }

    @PostMapping("/carrinho")
    public String adicionarAoCarrinho(@RequestParam("pratoId") Long pratoId,
                                       @RequestParam("pratoNome") String pratoNome,
                                       @RequestParam("pratoPreco") double pratoPreco,
                                       Model model) {
        
        Prato prato = new Prato();
        prato.setId(pratoId);
        prato.setNome(pratoNome);  
        prato.setPreco(pratoPreco);

        carrinho.adicionarPrato(prato);  

        return "redirect:/cardapio/carrinho";  
    }

    @PostMapping("/carrinho/remover")
    public String removerDoCarrinho(@RequestParam("pratoId") Long pratoId, Model model) {
        carrinho.removerPrato(pratoId); 
        return "redirect:/cardapio/carrinho";  
    }

    @GetMapping("/carrinho")
    public String mostrarCarrinho(Model model) {
        model.addAttribute("itensCarrinho", carrinho.getItens());
        model.addAttribute("total", carrinho.getTotal());
        return "carrinho";  
    }
}
