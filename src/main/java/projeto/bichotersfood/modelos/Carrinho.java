package projeto.bichotersfood.modelos;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component  // Adiciona a anotação @Component para registrar o Carrinho como um bean do Spring
public class Carrinho {
    private List<Prato> itens = new ArrayList<>();

    public void adicionarPrato(Prato prato) {
        itens.add(prato);
    }

    public List<Prato> getItens() {
        return itens;
    }

    public double getTotal() {
        double total = 0;
        for (Prato prato : itens) {
            total += prato.getPreco();  // Supondo que o prato tem um método getPreco()
        }
        return total;
    }
}
