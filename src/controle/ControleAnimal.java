package controle;
import modelo.Animal;
import dao.AnimalDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ControleAnimal {
    public Animal animal;
    private ResultSet resultSet;

    public boolean adicionaAnimal(String nome, int proprietario, String nascimento, int especie, int raca, String sexo, String cor)
    {
        Animal animal = new Animal("", nome, proprietario, nascimento, especie, raca, sexo, cor);

        if(AnimalDAO.cadastrar(animal))
        {
            return true;
        }
        else 
        {
            return false;
        }
    }

    public boolean alteraAnimal(int codigo, String nome, int proprietario, String nascimento, int especie, int raca, String sexo, String cor)
    {
        Animal animal = new Animal(codigo, nome, proprietario, nascimento, especie, raca, sexo, cor);

        try {
			if(AnimalDAO.alterar(animal))
			{
			    return true;
			}
			else 
			{
			    return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public boolean removeAnimal(int codigo)
    {
        try {
			if(AnimalDAO.remover(codigo)) 
			{
			    return true;
			}
			else 
			{
			    return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public boolean recuperar(Animal animal)
        {
            try{
                resultSet = (ResultSet) AnimalDAO.recuperar(Integer.valueOf(animal.getCodigo()));
                animal.setCodigo(resultSet.getInt(1));
                animal.setNome(resultSet.getString(1));
                animal.setProprietario(resultSet.getInt(2));
                animal.setNascimento(resultSet.getString(2));
                animal.setEspecie(resultSet.getInt(3));
                animal.setRaca(resultSet.getInt(4));
                animal.setSexo(resultSet.getString(3));
                animal.setCor(resultSet.getString(4));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
