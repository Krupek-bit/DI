package Classes;
import Enums.Categoria;

public class Produto {

    private int id;
    private String nome;
    private double preco;
    private int estoque;
    private Categoria categoria;

    public Produto(String nome, double preco, int estoque, Categoria categoria) {
        validar(nome, preco, estoque);

        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        this.categoria = categoria;
    }

    public Produto(int id, String nome, double preco, int estoque, Categoria categoria) {
        validar(nome, preco, estoque);

        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        this.categoria = categoria;
    }

    private void validar(String nome, double preco, int estoque) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome inválido.");
        }

        if (preco <= 0) {
            throw new IllegalArgumentException("Preço inválido.");
        }

        if (estoque < 0) {
            throw new IllegalArgumentException("Estoque inválido.");
        }
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}