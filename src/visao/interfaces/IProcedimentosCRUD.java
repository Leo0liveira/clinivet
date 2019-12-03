package visao.interfaces;

import modelo.Procedimento;

public interface IProcedimentosCRUD {
    public boolean adicionaProcedimento(int codigo, String descricao, double preco);
    public boolean alteraProcedimento(int codigo, String descricao, double preco);
    public boolean removeProcedimento(int codigo);
    public Procedimento buscaProcedimento(int codigo);

}
