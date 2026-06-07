package DAO;

import Classes.Pedido;
import Util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {

    public int salvar(Pedido pedido) {

        String sql =
                "INSERT INTO pedido(cliente_id, status, data_criacao) VALUES (?, ?, ?)";

        try (
                Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(
                        sql,
                        Statement.RETURN_GENERATED_KEYS
                )
        ) {

            stmt.setInt(1, pedido.getClienteId());
            stmt.setString(2, pedido.getStatus());
            stmt.setTimestamp(
                    3,
                    Timestamp.valueOf(
                            pedido.getDataCriacao()
                    )
            );

            stmt.executeUpdate();

            ResultSet rs =
                    stmt.getGeneratedKeys();

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }
    
    public List<Pedido> listar() {

        List<Pedido> pedidos = new ArrayList<>();

        String sql = "SELECT * FROM pedido";

        try (
                Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
        ) {

            while (rs.next()) {

                pedidos.add(
                        new Pedido(
                                rs.getInt("id_pedido"),
                                rs.getInt("cliente_id"),
                                rs.getString("status"),
                                rs.getTimestamp("data_criacao")
                                        .toLocalDateTime()
                        )
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pedidos;
    }

    public void atualizarStatus(int idPedido, String status) {

    String sql =
            "UPDATE pedido SET status = ? WHERE id_pedido = ?";

    try (
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
    ) {

        stmt.setString(1, status);
        stmt.setInt(2, idPedido);

        stmt.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }
}   
}
