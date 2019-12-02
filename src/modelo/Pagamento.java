package modelo;

public class Pagamento extends Procedimento {

    private String pagante;
    private double valor;

    public Pagamento(String pagante, double valor, String tipo) {
        super(tipo);
        this.pagante = pagante;
        this.valor = valor;
    }

    public String getPagante() {
        return pagante;
    }

    public void setPagante(String pagante) {
        this.pagante = pagante;
    }
    
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
