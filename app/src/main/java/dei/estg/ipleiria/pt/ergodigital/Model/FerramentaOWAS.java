package dei.estg.ipleiria.pt.ergodigital.Model;

/**
 * Created by Nuno on 15/10/2015.
 */
public class FerramentaOWAS extends Ferramenta {

    private int[] owas;

    public FerramentaOWAS(int id, String nome) {
        super(id, nome);
        owas = new int[4];
    }

    public void setTorso(int i) {
        owas[0]=i;
    }
    public void setBraco(int i) {
        owas[1]=i;
    }
    public void setPernas(int i) {
        owas[2]=i;
    }
    public void setLevantamentoCargas(int i) {
        owas[3]=i;
    }
    public int getTorso() {
        return owas[0];
    }
    public int getBraco() {
        return owas[1];
    }
    public int getPernas() {
        return owas[2];
    }
    public int getLevantamentoCargas() {
        return owas[3];
    }
}
