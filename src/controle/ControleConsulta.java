package controle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import modelo.Consulta;



public class ControleConsulta {
    public Consulta consulta;
    private ResultSet resultSet;
    
    public boolean salvarDados(int idAnimal, int idVeterinario, String tipo, Date data, String horario) {
    	Consulta consulta = new Consulta(idAnimal, idVeterinario, tipo, data, horario);
    }
    
    
}
public class ControleAnimal {
    public Animal animal;
    private ResultSet resultSet;

    public boolean adicionaAnimal(String nome, int proprietario, String nascimento, int especie, int raca, String sexo, String cor) {
        Animal animal = new Animal(0, nome, proprietario, nascimento, especie, raca, sexo, cor);

        try{
        	if (AnimalDAO.cadastrar(animal)) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
    }
    