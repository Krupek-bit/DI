package thread;

public class Main {

    public static void main(String[] args) {

        ProcessadorPedidos processador =
                new ProcessadorPedidos();

        processador.start();

        System.out.println(
                "Sistema iniciado."
        );
    }
}
