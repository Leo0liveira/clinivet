package modelo;

public class Servico extends Procedimento {

    private String nome;
    private Integer codigo;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Servico(String tipo, int dataHora, int id, String nome) {
        super(tipo, dataHora, id);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
