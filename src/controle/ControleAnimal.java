package controle;

import dao.AnimalDAO;
import modelo.Animal;

public class ControleAnimal {

    public boolean adicionaAnimal(String nome, int proprietario, String nascimento, int especie, int raca, String sexo, String cor)
    {
        AnimalDAO animalDAO = new AnimalDAO();
        Animal animal = new Animal("", nome, proprietario, nascimento, especie, raca, sexo, cor);

        if(animalDAO.cadastrar(animal))
        {
            System.out.println("Cadastrado com sucesso"); //mensagem de sucesso pra view
        }
        else 
        {
            System.out.println("Erro ao cadastrar"); //mensagem de erro pra view
        }
    }

    public boolean alteraAnimal(int codigo, String nome, int proprietario, String nascimento, int especie, int raca, String sexo, String cor)
    {
        AnimalDAO animalDAO = new AnimalDAO();
        Animal animal = new Animal(codigo, nome, proprietario, nascimento, especie, raca, sexo, cor);

        if(animalDAO.alterar(animal))
        {
            System.out.println("Alterado com sucesso"); //mensagem de sucesso pra view
        }
        else 
        {
            System.out.println("Erro ao alterar"); //mensagem de erro pra view
        }
    }

    public boolean removeAnimal(int codigo)
    {
        AnimalDAO animalDAO = new AnimalDAO();

        if(animalDAO.remover(codigo)) 
        {
            System.out.println("Removido com sucesso"); //mensagem de sucesso pra view
        } 
        else
        {
            System.out.println("Erro ao remover"); //mensagem de erro pra view
        }
    }

    public Animal buscaAnimal(int codigo)
    {
        AnimalDAO animalDAO = new AnimalDAO();

        return animalDAO.recuperar(codigo);
    }
}
