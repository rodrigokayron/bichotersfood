package projeto.bichotersfood.modelos;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class Carrinho {
    private List<Prato> itens = new ArrayList<>();

    // Adiciona um prato ao carrinho
    public void adicionarPrato(Prato prato) {
        itens.add(prato);
    }

    // Remove um prato do carrinho pelo ID
    public void removerPrato(Long pratoId) {
        itens.removeIf(prato -> prato.getId().equals(pratoId));
    }

    // Retorna todos os itens no carrinho
    public List<Prato> getItens() {
        return itens;
    }

    // Calcula o total do carrinho somando os preços dos pratos
    public double getTotal() {
        double total = 0;
        for (Prato prato : itens) {
            total += prato.getPreco();  // Soma o preço de cada prato
        }
        return total;
    }
}
