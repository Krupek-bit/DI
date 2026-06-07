package thread;

import Util.Conexao;
import java.util.Scanner;
import Classes.Cliente;
import DAO.ClienteDAO;
import java.util.List;
import Classes.Produto;
import DAO.ProdutoDAO;
import Enums.Categoria;
import Classes.Pedido;
import DAO.PedidoDAO;
import Classes.Pedido;
import Classes.ItemPedido;
import Service.PedidoService;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        try {
            Conexao.conectar();
            System.out.println("Conectado ao MySQL com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        ProcessadorPedidos processador =
                new ProcessadorPedidos();

        processador.start();

        Scanner scanner = new Scanner(System.in);
        ClienteDAO clienteDAO = new ClienteDAO();
        ProdutoDAO produtoDAO = new ProdutoDAO();
        PedidoDAO pedidoDAO = new PedidoDAO();
        PedidoService pedidoService = new PedidoService();

        int opcao;

        do {

            System.out.println("\n===== SISTEMA DE PEDIDOS =====");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Listar Clientes");
            System.out.println("3 - Cadastrar Produto");
            System.out.println("4 - Listar Produtos");
            System.out.println("5 - Criar Pedidos");
            System.out.println("6 - Listar Pedidos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    Cliente cliente = new Cliente(
                            nome,
                            email
                    );

                    clienteDAO.salvar(cliente);

                    System.out.println(
                            "Cliente cadastrado com sucesso!"
                    );
                break;

                case 2:
                    List<Cliente> clientes =
                        clienteDAO.listar();

                    for (Cliente c : clientes) {

                        System.out.println(
                                c.getId()
                                + " - "
                                + c.getNome()
                                + " - "
                                + c.getEmail()
                        );
                    }
                break;

                case 3:
                    System.out.print("Nome: ");
                    String nomeProduto = scanner.nextLine();

                    System.out.print("Preco: ");
                    double preco = scanner.nextDouble();

                    System.out.print("Estoque: ");
                    int estoque = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Categorias:");
                    System.out.println("ALIMENTOS");
                    System.out.println("ELETRONICOS");
                    System.out.println("LIVROS");

                    System.out.print("Categoria: ");
                    String categoriaTexto = scanner.nextLine();

                    Categoria categoria =
                            Categoria.valueOf(
                                    categoriaTexto.toUpperCase()
                            );

                    Produto produto =
                            new Produto(
                                    nomeProduto,
                                    preco,
                                    estoque,
                                    categoria
                            );

                    produtoDAO.salvar(produto);

                    System.out.println(
                            "Produto cadastrado com sucesso!"
                    );
                break;

                case 4:
                    List<Produto> produtos =
                        produtoDAO.listar();

                    for (Produto p : produtos) {

                    System.out.println(
                            p.getId()
                            + " - "
                            + p.getNome()
                            + " - R$ "
                            + p.getPreco()
                            + " - Estoque: "
                            + p.getEstoque()
                            + " - "
                            + p.getCategoria()
                    );
                    }
                break;

                case 5:
                    System.out.print("ID do cliente: ");
                    int clienteId = scanner.nextInt();

                    System.out.print("ID do produto: ");
                    int produtoId = scanner.nextInt();

                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();

                    System.out.print("Preco unitario: ");
                    double precoUnitario = scanner.nextDouble();

                    scanner.nextLine();

                    Pedido pedido =
                            new Pedido(
                                    clienteId,
                                    "FILA",
                                    LocalDateTime.now()
                            );

                    ItemPedido item =
                            new ItemPedido(
                                    0,
                                    produtoId,
                                    quantidade,
                                    precoUnitario
                            );

                    List<ItemPedido> itens =
                            new ArrayList<>();

                    itens.add(item);

                    pedidoService.criarPedido(
                            pedido,
                            itens
                    );

                    System.out.println(
                            "Pedido criado com sucesso!"
                    );

                break;

                case 6:
                    List<Pedido> pedidos =
                            pedidoDAO.listar();

                    for (Pedido p : pedidos) {

                        System.out.println(
                                p.getIdPedido()
                                + " - Cliente "
                                + p.getClienteId()
                                + " - "
                                + p.getStatus()
                                + " - "
                                + p.getDataCriacao()
                        );
                    }

                break;

                case 0:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }
}