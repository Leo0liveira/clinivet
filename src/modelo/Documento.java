package modelo;

public class Documento {

    private int dataHora;
    private String caminhoArquivo;
    private int id;

    public void imprimirArquivo() {
        //TODO: implementar;
    }

    public int getDataHora() {
        return dataHora;
    }

    public void setDataHora(int dataHora) {
        this.dataHora = dataHora;
    }

    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }

    public void setCaminhoArquivo(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
