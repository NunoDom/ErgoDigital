package dei.estg.ipleiria.pt.ergodigital.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Nuno on 13/10/2015.
 */
public class Consulta implements Serializable{
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
    public ArrayList<Resultado> getListaResultados() {
        return listaResultados;
    }

    public void setListaResultados(ArrayList<Resultado> listaResultados) {
        this.listaResultados = listaResultados;
    }




    public void addResultado(Resultado resultado) {
        listaResultados.add(resultado);
    }


    public Consulta(int id, Pessoa pessoa, Date dataHora, String turno, String seccao, String posto, int tempoTarefa, int horasTrabalhoDiario, String observacoes) {
        this.id = id;
        this.pessoa = pessoa;
        this.dataHora = dataHora;
        this.turno = turno;
        this.seccao = seccao;
        this.posto = posto;
        this.tempoTarefa = tempoTarefa;
        this.horasTrabalhoDiario = horasTrabalhoDiario;
        this.observacoes = observacoes;
    }

    public Consulta(int id) {
        listaResultados= new ArrayList<Resultado>();
        this.id = id;
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
        StringBuilder sb = new StringBuilder();
        sb.append("ID: "+id);
        for (Resultado value : listaResultados) {
            sb.append(value);
        }
        return sb.toString();
    }

}
