package Thread;

public class ProcessadorPedidos extends Thread {

    @Override
    public void run() {

        while (true) {

            try {

                System.out.println(
                        "Verificando pedidos na fila..."
                );

                Thread.sleep(5000);

            } catch (InterruptedException e) {

                System.out.println(
                        "Erro na thread: "
                        + e.getMessage()
                );
            }
        }
    }
}
