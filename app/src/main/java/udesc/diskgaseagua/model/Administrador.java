package udesc.diskgaseagua.model;

public class Administrador extends Pessoa{

    private int acesso;
    private String cpf;

    public Administrador(String nome, String cpf, String senha, String email, int acesso) {
        super(nome, email, senha);
        this.cpf = cpf;
        this.acesso = acesso;
    }

    public int getAcesso() {
        return acesso;
    }

    public void setAcesso(int acesso) {
        this.acesso = acesso;
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "acesso=" + acesso +
                '}';
    }
}
