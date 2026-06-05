package Service;

import Classes.ItemPedido;
import Classes.Pedido;
import DAO.ItemPedidoDAO;
import DAO.PedidoDAO;
import DAO.ProdutoDAO;
import Exception.EstoqueInsuficienteException;

import java.util.List;

public class PedidoService {

    private final PedidoDAO pedidoDAO =
            new PedidoDAO();

    private final ProdutoDAO produtoDAO =
            new ProdutoDAO();

    private final ItemPedidoDAO itemPedidoDAO =
            new ItemPedidoDAO();

    public void criarPedido(
            Pedido pedido,
            List<ItemPedido> itens
    ) {
