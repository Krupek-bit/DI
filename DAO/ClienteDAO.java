package DAO;

import Classes.Cliente;
import Util.Conexão;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public void salvar(Cliente cliente) {

        String sql =
                "INSERT INTO cliente(nome, email) VALUES (?, ?)";

        try (
                Connection conn = Conexão.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Cliente> listar() {

        List<Cliente> clientes = new ArrayList<>();

        String sql = "SELECT * FROM cliente";

        try (
                Connection conn = Conexão.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
        ) {

            while (rs.next()) {

                clientes.add(
                        new Cliente(
                                rs.getInt("id_cliente"),
                                rs.getString("nome"),
                                rs.getString("email")
                        )
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientes;
    }
}
