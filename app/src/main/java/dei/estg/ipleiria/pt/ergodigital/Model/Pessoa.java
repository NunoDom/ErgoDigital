package dei.estg.ipleiria.pt.ergodigital.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Nuno on 13/10/2015.
 */
public class Pessoa  implements Serializable{

    private String nomeCompleto;
    private GregorianCalendar dataNascimento;
    private Integer genero;
    private int altura;
    private int peso;


    private ArrayList<FuncaoEmpresa> HistoricoFuncoesEmp;

    private List<Consulta> consultas;



    public Pessoa(String nomeCompleto, int dia, int mes, int ano, Integer genero, int altura, int peso) {
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = new GregorianCalendar(ano,mes,dia);
        this.genero = genero;
        this.altura = altura;
        this.peso = peso;
    }



    public String getName() {
        return nomeCompleto;
    }

    public void setName(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public GregorianCalendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(GregorianCalendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getGenero() {
        return genero;
    }

    public void setGenero(Integer genero) {
        this.genero = genero;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }



    public String getPrimeiroNome() {
        String[] separated = nomeCompleto.split(" ");
        separated[0]= separated[0].trim();
        return separated[0];
    }



    public String getUltimoNome() {
        String[] separated = nomeCompleto.split(" ");
        int max =separated.length-1;
        separated[max]= separated[max].trim();
        return separated[max];
    }
    public String getNomeMeio() {

        String[] separated = nomeCompleto.split(" ");

        separated[0]= separated[0].trim();
        int max =separated.length-1;

        String nomeMeio="";
        for(int i=1;i<max;i++)
        {
            nomeMeio+=separated[i].trim();
        }
        return nomeMeio;
    }

    private int getIdade()
    {


        GregorianCalendar cal = new GregorianCalendar();
        int y, m, d, a;

        y = cal.get(dataNascimento.YEAR);
        m = cal.get(dataNascimento.MONTH);
        d = cal.get(dataNascimento.DAY_OF_MONTH);
        //cal.set(GregorianCalendar.YEAR, GregorianCalendar.MONTH, GregorianCalendar.DAY_OF_MONTH);
        a = y - cal.get(GregorianCalendar.YEAR);
        if ((m < cal.get(GregorianCalendar.MONTH))
                || ((m == cal.get(GregorianCalendar.MONTH)) && (d < cal
                .get(GregorianCalendar.DAY_OF_MONTH)))) {
            --a;
        }
        if(a < 0)
            throw new IllegalArgumentException("Age < 0");
        return a;

    }



    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }


    @Override
    public String toString() {
        return getPrimeiroNome()+" "+getUltimoNome()+", "+getIdade();
    }
}
