package thread;

import Classes.Cliente;
import DAO.ClienteDAO;

public class Main {

    public static void main(String[] args) {

        ClienteDAO dao = new ClienteDAO();

        dao.salvar(
            new Cliente(
                "Gustavo",
                "gustavo@gmail.com"

            )
        );

        ProcessadorPedidos processador =
                new ProcessadorPedidos();

        processador.start();

        System.out.println(
                "Sistema iniciado."
        );
    }
}
