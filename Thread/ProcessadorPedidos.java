package Thread;

public class ProcessadorPedidos extends Thread {

    @Override
    public void run() {

        while (true) {

            try {

                System.out.println(
                        "Verificando pedidos na fila..."
                );

