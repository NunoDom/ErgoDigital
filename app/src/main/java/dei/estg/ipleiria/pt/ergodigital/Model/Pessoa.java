package dei.estg.ipleiria.pt.ergodigital.Model;

import java.util.Date;
import java.util.List;

/**
 * Created by Nuno on 13/10/2015.
 */
public class Pessoa {

    private String name;
    private Date dataNascimento;
    private String genero;
    private int altura;
    private int peso;

    private FuncaoEmpresa funcoesEmpresa; //lista
    private long anosEmpresa;
    private String HistoricoFuncoesEmp;

    private List<Consulta> consultas;



    public Pessoa(String name, Date dataNascimento, String genero, int altura, int peso, FuncaoEmpresa funcoesEmpresa, long anosEmpresa, String historicoFuncoesEmp) {
        this.name = name;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.altura = altura;
        this.peso = peso;
        this.funcoesEmpresa = funcoesEmpresa;
        this.anosEmpresa = anosEmpresa;
        HistoricoFuncoesEmp = historicoFuncoesEmp;
    }

    public Pessoa(List<Consulta> consultas) {
        this.consultas = consultas;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
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

    public FuncaoEmpresa getFuncoesEmpresa() {
        return funcoesEmpresa;
    }

    public void setFuncoesEmpresa(FuncaoEmpresa funcoesEmpresa) {
        this.funcoesEmpresa = funcoesEmpresa;
    }

    public long getAnosEmpresa() {
        return anosEmpresa;
    }

    public void setAnosEmpresa(long anosEmpresa) {
        this.anosEmpresa = anosEmpresa;
    }

    public String getHistoricoFuncoesEmp() {
        return HistoricoFuncoesEmp;
    }

    public void setHistoricoFuncoesEmp(String historicoFuncoesEmp) {
        HistoricoFuncoesEmp = historicoFuncoesEmp;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }


    @Override
    public String toString() {
        return "Pessoa{" +
                "HistoricoFuncoesEmp='" + HistoricoFuncoesEmp + '\'' +
                ", name='" + name + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", genero='" + genero + '\'' +
                ", altura=" + altura +
                ", peso=" + peso +
                ", funcoesEmpresa=" + funcoesEmpresa +
                ", anosEmpresa=" + anosEmpresa +
                '}';
    }
}
