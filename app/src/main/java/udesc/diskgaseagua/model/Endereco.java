package udesc.diskgaseagua.model;

public class Endereco {

    private String rua;
    private String bairro;
    private String cep;
    private int numero;
    private String cidade;

    public Endereco(String rua, String bairro, String cep, int numero, String cidade) {
        this.rua = rua;
        this.bairro = bairro;
        this.cep = cep;
        this.numero = numero;
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "rua='" + rua + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cep='" + cep + '\'' +
                ", numero=" + numero +
                ", cidade='" + cidade + '\'' +
                '}';
    }
}
