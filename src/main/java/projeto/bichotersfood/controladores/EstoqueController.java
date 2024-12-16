package projeto.bichotersfood.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import projeto.bichotersfood.modelos.Prato;
import projeto.bichotersfood.repositorios.PratoRepository;

@Controller
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    private PratoRepository pratoRepository;

    // Rota para exibir o estoque com os pratos
    @GetMapping
    public String mostrarEstoque(Model model, @RequestParam(value = "mensagem", required = false) String mensagem) {
        model.addAttribute("pratos", pratoRepository.findAll());  // Passa todos os pratos para a view
        model.addAttribute("mensagem", mensagem);  // Passa a mensagem para a página, se existir
        return "estoque";  // A página de estoque
    }

    // Rota para alterar a disponibilidade de um prato
    @PostMapping("/alterarDisponibilidade")
    public String alterarDisponibilidade(@RequestParam("pratoId") Long pratoId, 
                                         @RequestParam("disponivel") boolean disponivel) {
        // Altera a disponibilidade de um prato
        Prato prato = pratoRepository.findById(pratoId).orElse(null);
        if (prato != null) {
            prato.setDisponivel(disponivel);  // Atualiza a disponibilidade
            pratoRepository.save(prato);  // Salva a alteração no banco
        }
        // Após a alteração, redireciona para a página com a mensagem de sucesso
        return "redirect:/estoque?mensagem=Alteração%20realizada%20com%20sucesso!";  
    }
}