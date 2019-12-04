package controle;

import dao.AnimalDAO;
import modelo.Animal;

public class ControleAnimal {

    AnimalDAO animalDAO = new AnimalDAO();

    public boolean adicionaAnimal(String nome, int proprietario, String nascimento, int especie, int raca, String sexo, String cor)
    {
        Animal animal = new Animal("", nome, proprietario, nascimento, especie, raca, sexo, cor);

        if(animalDAO.cadastrar(animal))
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

        if(animalDAO.alterar(animal))
        {
            return true;
        }
        else 
        {
            return false;
        }
    }

    public boolean removeAnimal(int codigo)
    {
        if(animalDAO.remover(codigo)) 
        {
            return true;
        }
        else 
        {
            return false;
        }
    }

    public Animal buscaAnimal(int codigo)
    {
        return animalDAO.recuperar(codigo);
    }
}
