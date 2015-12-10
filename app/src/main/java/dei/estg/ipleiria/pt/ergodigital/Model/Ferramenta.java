package dei.estg.ipleiria.pt.ergodigital.Model;

/**
 * Created by Nuno on 15/10/2015.
 */
public abstract class Ferramenta {
    private int id;
    private String nome;

    public Ferramenta(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
