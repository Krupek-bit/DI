package Classes;

public class ItemPedido {

    private int id;
    private int pedidoId;
    private int produtoId;
    private int quantidade;
    private double precoUnitario;

    public ItemPedido(int pedidoId, int produtoId, int quantidade, double precoUnitario) {

        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade inválida.");
        }

        if (precoUnitario <= 0) {
            throw new IllegalArgumentException("Preço inválido.");
        }

        this.pedidoId = pedidoId;
        this.produtoId = produtoId;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public ItemPedido(int id, int pedidoId, int produtoId,
                      int quantidade, double precoUnitario) {

        this(pedidoId, produtoId, quantidade, precoUnitario);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getPedidoId() {
        return pedidoId;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }
}
