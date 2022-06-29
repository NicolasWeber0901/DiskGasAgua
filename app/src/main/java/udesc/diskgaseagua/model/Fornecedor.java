package udesc.diskgaseagua.model;

public class Fornecedor extends Pessoa{

    private String cpnj;
    private String razaoSocial;

    public Fornecedor(String nome, String senha, String email, String cpnj, String razaoSocial) {
        super(nome, email, senha);
        this.cpnj = cpnj;
        this.razaoSocial = razaoSocial;
    }

    public String getCpnj() {
        return cpnj;
    }

    public void setCpnj(String cpnj) {
        this.cpnj = cpnj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    @Override
    public String toString() {
        return "Fornecedor{" +
                "cpnj='" + cpnj + '\'' +
                ", razaoSocial='" + razaoSocial + '\'' +
                '}';
    }
}
