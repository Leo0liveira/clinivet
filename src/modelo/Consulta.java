package modelo;

import java.sql.Date;


public class Consulta extends Procedimento{

    private int idAnimal;
    private int idVeterinario;
    private String horario;
    private String pagamentoForma;

    public Consulta(int idAnimal, int idVeterinario, String tipo, Date dataHora, int id, String horario, String pagamentoForma) {
        super(tipo, dataHora, id);
        this.idAnimal = idAnimal;
        this.idVeterinario = idVeterinario;
        this.horario = horario;
        this.pagamentoForma = pagamentoForma;
        
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

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getPagamentoForma() {
		return pagamentoForma;
	}

	public void setPagamentoForma(String pagamentoForma) {
		this.pagamentoForma = pagamentoForma;
	}
    

}
