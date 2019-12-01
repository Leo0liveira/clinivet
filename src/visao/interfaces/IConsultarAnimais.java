package visao.interfaces;

import java.util.Date;

public interface IConsultarAnimais {
    public boolean salvarDados(int idAnimal, int idVeterinario, String tipo, Date data, String horario);

}
