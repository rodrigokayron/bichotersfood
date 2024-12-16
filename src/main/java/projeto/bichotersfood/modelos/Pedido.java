package projeto.bichotersfood.modelos;

import java.util.List;

public class Pedido {

	private Long id;
	private String nomeCliente;
	private List<Prato> pratos;
	private double total;
	private String dataPedido;

	public Pedido(String nomeCliente, List<Prato> pratos, double total, String dataPedido) {
		this.nomeCliente = nomeCliente;
		this.pratos = pratos;
		this.total = total;
		this.dataPedido = dataPedido;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public List<Prato> getPratos() {
		return pratos;
	}

	public void setPratos(List<Prato> pratos) {
		this.pratos = pratos;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(String dataPedido) {
		this.dataPedido = dataPedido;
	}
}