package udesc.diskgaseagua.model;

public class Produto {

    private static int geradorCodigo = 0;

    private int codigo;
    private Categoria categoria;
    private String nome;
    private float preco;
    private int quantidade;

    public Produto(Categoria categoria, String nome, float preco, int quantidade) {
        this.codigo = geraCodigo(geradorCodigo);
        this.categoria = categoria;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int geraCodigo(int cod){
        return ++this.geradorCodigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }


    @Override
    public String toString() {
        return "Produto{" +
                "categoria=" + categoria +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                '}';
    }
}
