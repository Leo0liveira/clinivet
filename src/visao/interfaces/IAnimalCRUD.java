package visao.interfaces;

import modelo.Animal;
import modelo.Especie;
import modelo.Raca;

import java.util.Date;

public interface IAnimalCRUD {

    public boolean adicionaAnimal(int codigo, String nome, String proprietario, Date nascimento, Especie especie, Raca raca, String sexo, String cor);
    public boolean alteraAnimal(int codigo, String nome, String proprietario, Date nascimento, Especie especie, Raca raca, String sexo, String cor);
    public boolean removeAnimal(int codigo);
    public Animal buscaAnimal(int codigo);
}
