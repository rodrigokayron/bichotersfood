package projeto.bichotersfood.modelos;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class Carrinho {
	private List<Prato> itens = new ArrayList<>();

	public void adicionarPrato(Prato prato) {
		itens.add(prato);
	}

	public void removerPrato(Long pratoId) {
		itens.removeIf(prato -> prato.getId().equals(pratoId));
	}

	public List<Prato> getItens() {
		return itens;
	}

	public double getTotal() {
		double total = 0;
		for (Prato prato : itens) {
			total += prato.getPreco();
		}
		return total;
	}
}