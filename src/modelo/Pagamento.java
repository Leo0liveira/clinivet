package modelo;

public class Pagamento extends Procedimento {

    private String pagante;
    private double valor;

    public Pagamento(String pagante, double valor, String tipo, int dataHora, int id) {
        super(tipo, dataHora, id);
        this.pagante = pagante;
        this.valor = valor;
    }

    public String getPagante() {
        return pagante;
    }

    public void setPagante(String pagante) {
        this.pagante = pagante;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
