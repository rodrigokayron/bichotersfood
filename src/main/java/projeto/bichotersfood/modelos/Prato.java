package projeto.bichotersfood.modelos;

import jakarta.persistence.*;

@Entity
public class Prato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private double preco;
    
    private boolean disponivel; // Adicionamos o campo de disponibilidade

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    // Método para verificar se o prato está disponível
    public boolean isDisponivel() {
        return disponivel;
    }

    // Método para alterar a disponibilidade do prato
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}