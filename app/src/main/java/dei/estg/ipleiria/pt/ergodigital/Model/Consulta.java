package dei.estg.ipleiria.pt.ergodigital.Model;

import java.util.Date;

/**
 * Created by Nuno on 13/10/2015.
 */
public class Consulta {
    private int id;
    private Pessoa pessoa;
    private Date data;                    //data e hora
    private String turno;
    private String seccao;
    private String posto;                 //tarefa
    private int tempoTarefa;
    private int horasTrabalhoDiario;
    private String observacoes;



    public Consulta(int id) {
        this.id = id;
    }
}
