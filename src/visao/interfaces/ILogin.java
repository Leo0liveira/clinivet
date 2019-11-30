//TODO implementar em controles
package visao.interfaces;

import modelo.Funcionario;

public interface ILogin {

    public Funcionario autentica (String usuario, String senha);
}
