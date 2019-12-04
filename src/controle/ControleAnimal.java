package controle;

import dao.AnimalDAO;
import modelo.Animal;

public class ControleAnimal {

    public boolean adicionaAnimal(String nome, int proprietario, Date nascimento, Especie especie, Raca raca, String sexo, String cor)
    {
        //removi o 'int codigo' já que o codigo vai ser criado pelo proprio banco quando adicionar.

        AnimalDAO animalDAO = new AnimalDAO();
        Animal animal = new Animal();

        animal.setNome(nome);
        animal.setSexo(sexo);
        animal.setCor(cor);
        animal.setRaca(raca);
        animal.setDonoId(proprietario); //mudado para INT porque guarda o id do proprietario

        animalDAO.cadastrar(animal);
    }

    public boolean alteraAnimal(int codigo, String nome, int proprietario, Date nascimento, Especie especie, Raca raca, String sexo, String cor)
    {
        AnimalDAO animalDAO = new AnimalDAO();
        Animal animal = new Animal();

        animal.setId(codigo);
        animal.setNome(nome);
        animal.setSexo(sexo);
        animal.setCor(cor);
        animal.setRaca(raca);
        animal.setDonoId(proprietario); //mudado para INT porque guarda o id do proprietario

        animalDAO.alterar(animal);
    }

    public boolean removeAnimal(int codigo)
    {
        AnimalDAO animalDAO = new AnimalDAO();

        if(animalDAO.remover(codigo)) 
        {
            System.out.println("Removido com sucesso");
        } 
        else
        {
            System.out.println("Erro ao remover");
        }
    }

    public Animal buscaAnimal(int codigo)
    {
        AnimalDAO animalDAO = new AnimalDAO();

        return animalDAO.recuperar(codigo);
    }
}
