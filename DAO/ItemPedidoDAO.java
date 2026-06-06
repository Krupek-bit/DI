package DAO;

import Classes.ItemPedido;
import Util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemPedidoDAO {

    public void salvar(ItemPedido item) {

        String sql =
                "INSERT INTO item_pedido(pedido_id, produto_id, quantidade, preco_unitario) VALUES (?, ?, ?, ?)";

        try (
                Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setInt(1, item.getPedidoId());
            stmt.setInt(2, item.getProdutoId());
            stmt.setInt(3, item.getQuantidade());
            stmt.setDouble(4, item.getPrecoUnitario());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<ItemPedido> listarPorPedido(int pedidoId) {

        List<ItemPedido> itens = new ArrayList<>();

        String sql =
                "SELECT * FROM item_pedido WHERE pedido_id = ?";

        try (
                Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setInt(1, pedidoId);

            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {

                    itens.add(
                            new ItemPedido(
                                    rs.getInt("id_item"),
                                    rs.getInt("pedido_id"),
                                    rs.getInt("produto_id"),
                                    rs.getInt("quantidade"),
                                    rs.getDouble("preco_unitario")
                            )
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return itens;
    }
}
