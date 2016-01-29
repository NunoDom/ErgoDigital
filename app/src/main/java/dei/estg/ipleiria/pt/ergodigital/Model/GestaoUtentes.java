package dei.estg.ipleiria.pt.ergodigital.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Nuno on 24/01/2016.
 */
public class GestaoUtentes implements Serializable{

private static GestaoUtentes instance;
private static int numPessoas;
private ArrayList<Pessoa> listaPessoas;


    public GestaoUtentes()
    {
        listaPessoas= new ArrayList<Pessoa>();
    }


    public static GestaoUtentes getInstance() {
        if (instance == null)
            instance = new GestaoUtentes();
        return instance;

    }


    public static void setInstance(GestaoUtentes gestaoUtentes) {
        instance = gestaoUtentes;
    }

    public boolean addPessoa(String nome,Date dataNascimento, int genero, int altura,int peso){
        numPessoas++;
        Pessoa pessoa = new Pessoa(numPessoas,nome,dataNascimento,genero,altura,peso);
        listaPessoas.add(pessoa);
        return true;
    }

    public ArrayList<Pessoa> getListaPessoas() {
        ArrayList<Pessoa> listaAux = new ArrayList<Pessoa>();
        for (Pessoa i:listaPessoas) {
            listaAux.add(i);
        }
        return listaAux;
    }

    public void setListaPessoas(ArrayList<Pessoa> listaPessoas) {
        this.listaPessoas = listaPessoas;
    }

    public Pessoa getPessoa(int id) {
        for (Pessoa i:listaPessoas) {
            if(i.getId()==id)
            {
                return i;
            }
        }
        return null;
    }

    public ArrayList<Pessoa> getPessoa(String primeiroNome) {
        ArrayList<Pessoa> arrayPessoas= new ArrayList<Pessoa>();
        for (Pessoa i:listaPessoas) {
            if(i.getPrimeiroNome().equals(primeiroNome))
            {
                arrayPessoas.add(i);
            }
        }
        return arrayPessoas;
    }
    public ArrayList<Pessoa> getPessoaContains(String parteNome) {
        ArrayList<Pessoa> arrayPessoas= new ArrayList<Pessoa>();
        for (Pessoa i:listaPessoas) {
            if((i.getName().contains(parteNome)))
            {
                arrayPessoas.add(i);
            }
        }
        return arrayPessoas;
    }


    public boolean alterarPessoa(int id,String nome, Date date, Integer genero, int altura, int peso) {
        for (Pessoa i:listaPessoas) {
            if(i.getId()==id)
            {
                i.setName(nome);
                i.setDataNascimento(date);
                i.setAltura(altura);
                i.setGenero(genero);
                i.setPeso(peso);
                return true;
            }
        }
        return false;
    }

    public boolean removerPessoa(int id) {
        try{
            listaPessoas.remove(getPessoa(id));
            return true;
        } catch (Exception ex) {return false;}

    }
}