package visao.interfaces;

import modelo.Raca;

public interface IRacaCRUD {

    public boolean adicionaRaca(int codigo, String descricao);
    public boolean alteraRaca(int codigo, String descricao);
    public boolean removeRaca(int codigo);
    public Raca buscaRaca(int codigo);
}
