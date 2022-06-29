package udesc.diskgaseagua.model;

public class Usuario {

    private String uid;
    private String email;
    private String senha;
    private int acesso;

    public Usuario( String email, String senha, int acesso) {
        this.email = email;
        this.senha = senha;
        this.acesso = acesso;
    }

    public Usuario(){

    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getAcesso() {
        return acesso;
    }

    public void setAcesso(int acesso) {
        this.acesso = acesso;
    }
}
