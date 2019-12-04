package visao.interfaces;

import modelo.Animal;
import modelo.Especie;
import modelo.Raca;

import java.util.Date;

public interface IAnimalCRUD {

    public boolean adicionaAnimal(String nome, int proprietario, String nascimento, int especie, int raca, String sexo, String cor);
    public boolean alteraAnimal(int codigo, String nome, int proprietario, String nascimento, int especie, int raca, String sexo, String cor);
    public boolean removeAnimal(int codigo);
    public Animal buscaAnimal(int codigo);
}
