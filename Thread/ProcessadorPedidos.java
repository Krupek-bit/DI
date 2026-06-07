package thread;

import DAO.PedidoDAO;
import Classes.Pedido;

import java.util.List;

public class ProcessadorPedidos extends Thread {

    private PedidoDAO pedidoDAO =
            new PedidoDAO();

    @Override
    public void run() {

        while (true) {

            try {

                List<Pedido> pedidos =
                        pedidoDAO.listarPorStatus(
                                "FILA"
                        );

                for (Pedido pedido : pedidos) {

                    System.out.println(
                        "\n[THREAD] Processando pedido "
                                + pedido.getIdPedido()
                    );

                    pedidoDAO.atualizarStatus(
                            pedido.getIdPedido(),
                            "PROCESSANDO"
                    );

                    Thread.sleep(3000);

                    pedidoDAO.atualizarStatus(
                            pedido.getIdPedido(),
                            "FINALIZADO"
                    );

                    System.out.println(
                        "[THREAD] Pedido "
                                + pedido.getIdPedido()
                                + " finalizado.\n"
                    );
                }

                Thread.sleep(5000);

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }
}