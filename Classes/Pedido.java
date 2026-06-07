package Classes;
import java.time.LocalDateTime;

public class Pedido {

    private int idPedido;
    private int clienteId;
    private String status;
    private LocalDateTime dataCriacao;

    public Pedido(
        int clienteId,
        String status,
        LocalDateTime dataCriacao
    ) {

    this.clienteId = clienteId;
    this.status = status;
    this.dataCriacao = dataCriacao;
    }

    public Pedido(int idPedido, int clienteId, String status, LocalDateTime dataCriacao) {
        this.idPedido = idPedido;
        this.clienteId = clienteId;
        this.status = status;
        this.dataCriacao = dataCriacao;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
