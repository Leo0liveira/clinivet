package visao.interfaces;

import modelo.Especie;

public interface IEspecieCRUD {

    public boolean adicionaEspecie(int codigo, String especie);
    public boolean alteraEspecie(int codigo, String especie);
    public boolean removeEspecie(int codigo);
    public Especie buscaEspecie(int codigo);
}
