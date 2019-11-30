package visao.interfaces;

import com.sun.xml.internal.ws.api.databinding.ClientCallBridge;
import modelo.Animal;
import modelo.Cliente;
import modelo.Funcionario;
import modelo.Procedimento;

public interface IADM {

    public Cliente getCliente (String Nome);
    public Cliente getCliente (int Id);

    public Animal getAnimal (String Nome);
    public Animal getAnimal (int Id);

    public Procedimento getProcedimento (String Nome);
    public Procedimento getProcedimento (int Id);

    public Funcionario getFuncionario (String Nome);
    public Funcionario getFuncionario (int Id);
}
