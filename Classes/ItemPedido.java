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

  
