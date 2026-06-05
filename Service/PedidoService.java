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

        for (ItemPedido item : itens) {

            boolean possuiEstoque =
                    produtoDAO.verificarEstoque(
                            item.getProdutoId(),
                            item.getQuantidade()
                    );

            if (!possuiEstoque) {

                throw new EstoqueInsuficienteException(
                        "Estoque insuficiente para o produto "
                                + item.getProdutoId()
                );
            }
        }

        pedidoDAO.salvar(pedido);

        for (ItemPedido item : itens) {

            itemPedidoDAO.salvar(item);

            produtoDAO.baixarEstoque(
                    item.getProdutoId(),
                    item.getQuantidade()
            );
        }
    }
    public List<Pedido> listarPedidos() {

        return pedidoDAO.listar();

    }

    public void enviarParaFila(
            int idPedido
    ) {

        pedidoDAO.atualizarStatus(
                idPedido,
                "FILA"
        );

    }
}
