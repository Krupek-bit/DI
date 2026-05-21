package Classes;

public class Cliente {

    private int id;
    private String nome;
    private String email;

    public Cliente(String nome, String email) {
        validar(nome, email);

        this.nome = nome;
        this.email = email;
    }

    public Cliente(int id, String nome, String email) {
        validar(nome, email);

        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    private void validar(String nome, String email) {

        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome inválido.");
        }

        if (email == null || email.isBlank() || !email.contains("@")) {
            throw new IllegalArgumentException("Email inválido.");
        }
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}