package udesc.diskgaseagua.model;

import java.util.Date;

public class Pedido {

    private String codCliente;
    private String formaPagamento;
    private float total;
    private Date data;

    public Pedido(String codCliente, String formaPagamento, float total, Date data) {
        this.codCliente = codCliente;
        this.formaPagamento = formaPagamento;
        this.total = total;
        this.data = data;
    }

    public Pedido(){

    }

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Pedido {" + "\n" +
                "codCliente='" + codCliente + "\n" +
                ", formaPagamento='" + formaPagamento + "\n" +
                ", total=" + total + "\n" +
                ", data=" + data + "\n" +
                '}';
    }
}
