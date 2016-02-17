package dei.estg.ipleiria.pt.ergodigital.Model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Nuno on 13/10/2015.
 */
public class Consulta implements Serializable{

    private static int Identificador=1;



    private int id;
    private Pessoa pessoa;
    private Date dataHora;
    private String turno;
    private String seccao;
    private String posto;                 //tarefa
    private int tempoTarefa;
    private int horasTrabalhoDiario;
    private String observacoes;
    private ArrayList<Resultado> listaResultados;
    private String ferramenta;





    public ArrayList<Resultado> getListaResultados()
    {
        return listaResultados;
    }




    public void addResultado(Resultado resultado) {
        listaResultados.add(resultado);
    }


    public void setIdentificador(int UltimoNumero)
    {
        Identificador=UltimoNumero;
    }

    public Consulta(Pessoa pessoa, String turno, String seccao, String posto, int tempoTarefa, int horasTrabalhoDiario, String observacoes,String ferramenta) {
        listaResultados= new ArrayList<Resultado>();
        this.id = Identificador++;
        this.pessoa = pessoa;
        Calendar i = Calendar.getInstance();
        this.dataHora = i.getTime();
        this.turno = turno;
        this.seccao = seccao;
        this.posto = posto;
        this.tempoTarefa = tempoTarefa;
        this.horasTrabalhoDiario = horasTrabalhoDiario;
        this.observacoes = observacoes;
        this.ferramenta =ferramenta;
    }

    public Consulta() {
        listaResultados= new ArrayList<Resultado>();
        this.id = Identificador++;
        Calendar i = Calendar.getInstance();
        this.dataHora = i.getTime();
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getSeccao() {
        return seccao;
    }

    public void setSeccao(String seccao) {
        this.seccao = seccao;
    }

    public String getPosto() {
        return posto;
    }

    public void setPosto(String posto) {
        this.posto = posto;
    }

    public int getTempoTarefa() {
        return tempoTarefa;
    }

    public void setTempoTarefa(int tempoTarefa) {
        this.tempoTarefa = tempoTarefa;
    }

    public int getHorasTrabalhoDiario() {
        return horasTrabalhoDiario;
    }

    public void setHorasTrabalhoDiario(int horasTrabalhoDiario) {
        this.horasTrabalhoDiario = horasTrabalhoDiario;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }


    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat();
        StringBuilder sb = new StringBuilder();
        sb.append("ID: "+id+" "+ferramenta+" "+dateFormat.format(dataHora));
        return sb.toString();
    }

    public void setFerramenta(String ferramenta) {
        this.ferramenta = ferramenta;
    }

    public String getFerramenta() {
        return ferramenta;
    }
}
