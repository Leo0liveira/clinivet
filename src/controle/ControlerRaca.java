package controle;

public class controlerRaca
{
    private RacaDAO RDAO = new RacaDAO();

    public boolean adicionaRaca(String descricao)
    {
        // id auto-incremental
        Raca raca = new Raca(0, descricao);

        if(RDAO.cadastrar(raca))
            System.out.println("Cadastrado");
        else
            System.out.println("Não Cadastrado");
        
    }
    
    public boolean alteraRaca(int id, String descricao)
    {
        Raca raca = new Raca(id, descricao);

        if(RDAO.alterar(raca))
            System.out.println("Alterado");
        else
            System.out.println("Não alterado");
    }
    public boolean removeRaca(int codigo)
    {
    	if(RDAO.remover(raca))
            System.out.println("Removido");
        else
            System.out.println("Não removido");
    }
    public Raca buscaRaca(int id)
    {
        Raca raca = null;
        try {

            ResultSet rs = RDAO.recuperar(id);
            while(rs.next())
            {
                raca = new raca(rs.getInt("id"), rs.getString("descricao"));
            }

        } catch (SQLException e) {
           return null;
        }
        catch (NaoEncontradoExeception e) {
           return null;
        }
        catch (ClassNotFoundException e) {
           return null;
        }

        return raca;
        
    }
}