package dei.estg.ipleiria.pt.ergodigital.Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Nuno on 24/01/2016.
 */
public enum GerirPessoas {
    INSTANCE;

private ArrayList<Pessoa> listaPessoas;


    private GerirPessoas() {
        listaPessoas= new ArrayList<Pessoa>();
    }



    public boolean addPessoa(Pessoa pessoa){
            getListaPessoas().add(pessoa);
        return true;
    }

    public ArrayList<Pessoa> getListaPessoas() {
        return listaPessoas;
    }

    public void setListaPessoas(ArrayList<Pessoa> listaPessoas) {
        this.listaPessoas = listaPessoas;
    }



}
