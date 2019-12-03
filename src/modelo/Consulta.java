package modelo;

public class Consulta extends Procedimento{

    private int idAnimal;
    private int idVeterinario;

    public Consulta(int idAnimal, int idVeterinario, String tipo, int dataHora, int id) {
        super(tipo, dataHora, id);
        this.idAnimal = idAnimal;
        this.idVeterinario = idVeterinario;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public int getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(int idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public void agendarConsulta() {
        //TODO: implementar
    }

    public void finalizarConsulta() {
        //TODO: implementar
    }

}
