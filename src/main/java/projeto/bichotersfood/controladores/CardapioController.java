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
        model.addAttribute("pratos", pratoRepository.findAll());  // Carrega todos os pratos
        return "cardapio";
    }

    @PostMapping("/carrinho")
    public String adicionarAoCarrinho(@RequestParam("pratoId") Long pratoId,
                                      @RequestParam("pratoNome") String pratoNome, 
                                      @RequestParam("pratoPreco") double pratoPreco,
                                      @RequestParam(required = false) String saborRefrigerante, Model model) {

        Prato prato = pratoRepository.findById(pratoId).orElse(null);

        if (prato == null || !prato.isDisponivel()) {  // Verifica se o prato existe e está disponível
            model.addAttribute("error", "O prato não está disponível no momento.");
            model.addAttribute("pratos", pratoRepository.findAll()); // Recarregar pratos para a view
            return "cardapio";  // Redireciona de volta para o cardápio
        }

        // Se for um refrigerante e tiver sabor, adiciona ao nome
        if (pratoNome.equals("Refrigerante") && saborRefrigerante != null) {
            pratoNome = pratoNome + " - " + saborRefrigerante;
        }

        prato.setNome(pratoNome);
        prato.setPreco(pratoPreco);

        carrinho.adicionarPrato(prato);  // Adiciona ao carrinho

        return "redirect:/cardapio/carrinho";  // Redireciona para o carrinho
    }

    @GetMapping("/carrinho")
    public String exibirCarrinho(Model model) {
        model.addAttribute("carrinho", carrinho);  // Exibe o carrinho
        return "carrinho";  // Retorna para a página do carrinho
    }

    @PostMapping("/carrinho/remover")
    public String removerDoCarrinho(@RequestParam("pratoId") Long pratoId) {
        carrinho.removerPrato(pratoId);  // Remove o prato do carrinho
        return "redirect:/cardapio/carrinho";  // Redireciona para o carrinho
    }
}