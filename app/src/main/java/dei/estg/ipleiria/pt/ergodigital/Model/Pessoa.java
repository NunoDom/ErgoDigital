package dei.estg.ipleiria.pt.ergodigital.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Nuno on 13/10/2015.
 */
public class Pessoa  implements Serializable{

    private static int Identificador=1;


    private int id;
    private String nomeCompleto;
    private Date dataNascimento;
    private Integer genero;
    private int altura;
    private int peso;
    private ArrayList<FuncaoEmpresa> HistoricoFuncoesEmp;
    private ArrayList<Consulta> consultas;



    public Pessoa(String nomeCompleto, Date dataNascimento, Integer genero, int altura, int peso) {
        consultas = new ArrayList<>();
        this.id=Identificador++;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.altura = altura;
        this.peso = peso;
    }
    public Pessoa()
    {
        HistoricoFuncoesEmp = new ArrayList<FuncaoEmpresa>();
        consultas= new ArrayList<Consulta>();
    }



    public int getId() {
        return id;
    }


    public String getName() {
        return nomeCompleto;
    }

    public void setName(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
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
        if(max==0){
            return "";
        }else
        {


        return separated[max];
        }
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
        Calendar cal = Calendar.getInstance();
        cal.setTime(dataNascimento);


        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        Calendar today = Calendar.getInstance();

        cal.set(year, month, day);

        int age = today.get(Calendar.YEAR) - cal.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < cal.get(Calendar.DAY_OF_YEAR)){
            age--;
        }
        return age;

    }


    public void addConsulta(Consulta consulta)
    {
        consultas.add(consulta);
    }

    public ArrayList<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(ArrayList<Consulta> consultas) {
        this.consultas = consultas;
    }


    @Override
    public String toString() {
        return getPrimeiroNome()+" "+getUltimoNome()+", "+getIdade();
    }


}
