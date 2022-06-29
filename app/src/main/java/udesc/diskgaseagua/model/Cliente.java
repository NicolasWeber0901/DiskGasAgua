package udesc.diskgaseagua.model;

public class Cliente extends Pessoa{

    private String cpf;
    private String telefone;
    private Endereco endereco;

    public Cliente(String nome, String cpf, String senha, String email, String telefone,
                   Endereco endereco) {
        super(nome, email, senha);
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}
