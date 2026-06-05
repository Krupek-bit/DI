package DAO;

import Classes.Pedido;
import Util.Conexao;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {

    public void salvar(Pedido pedido) {

        String sql =
                "INSERT INTO pedido(cliente_id, status, data_criacao) VALUES (?, ?, ?)";

        try (
                Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)
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

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

