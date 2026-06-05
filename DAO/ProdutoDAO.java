package DAO;

import Classes.Produto;
import Classes.Categoria;
import Util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public void salvar(Produto produto) {

        String sql =
                "INSERT INTO produto(nome, preco, estoque, categoria) VALUES (?, ?, ?, ?)";

        try (
                Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getEstoque());
            stmt.setString(4, produto.getCategoria().name());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Produto> listar() {

        List<Produto> produtos = new ArrayList<>();

        String sql = "SELECT * FROM produto";

        try (
                Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
        ) {

            while (rs.next()) {

                produtos.add(
                        new Produto(
                                rs.getInt("id_produto"),
                                rs.getString("nome"),
                                rs.getDouble("preco"),
                                rs.getInt("estoque"),
                                Categoria.valueOf(
                                        rs.getString("categoria")
                                )
                        )
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produtos;
    }
}
