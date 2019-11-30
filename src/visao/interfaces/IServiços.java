package visao.interfaces;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface IServiços {

    public boolean AgendarConsulta(Date data,String Horario, String CPF, String NomeVet, String Descrição, String FormaDePagamento);

    public boolean AgendarProcedimento(Date data,String Horario, String CPF, String NomeVet, String TipoDeProcedimento, String FormaDePagamento);


    // retorna lista de todos os animais agrupados por especie
    public ArrayList ImprimeRelatorioRaças();

    //retorna lista de todas as consultas e procedimentos feitos em um animal espefico
    public ArrayList ImprimeConsultasProcedimentosPorAnimal();

    //retorna todas as consultas e procedimentos feitos na clinica
    public ArrayList ImprimeConsultaProcedimentosClinica();


}
