package udesc.diskgaseagua.model;

public class Cliente extends Pessoa{

    private String cpf;
    private String telefone;
    private String dataNascimento;
    private Endereco endereco;

    public Cliente(String nome, String cpf, String senha, String telefone, String dataNasc,
                   Endereco endereco) {
        super(nome, senha);
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataNascimento = dataNasc;
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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
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
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}
