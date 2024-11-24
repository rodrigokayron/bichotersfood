package projeto.bichotersfood.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import projeto.bichotersfood.repositorios.PratoRepository;

@Controller
public class MenuController {

    @Autowired
    private PratoRepository pratoRepository;

    @GetMapping("/cardapio")
    public String cardapio(Model model) {
        model.addAttribute("pratos", pratoRepository.findAll());
        return "cardapio";
    }
}
