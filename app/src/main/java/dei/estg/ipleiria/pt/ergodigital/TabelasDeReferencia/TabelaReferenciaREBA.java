package dei.estg.ipleiria.pt.ergodigital.TabelasDeReferencia;

/**
 * Created by Nuno on 14/12/2015.
 */
public class TabelaReferenciaREBA {

    private int[][][] rebaTabelaA;
    private int[][][] rebaTabelaB;
    private int[][] rebaTabelaC;



    public TabelaReferenciaREBA() {
        rebaTabelaA = new int[5][3][4];
        rebaTabelaB = new int[6][2][3];
        rebaTabelaC = new int[12][12];

        create();
    }
    private void create() {



    }



    public int devolveTabelaA(int tronco, int pescoco, int pernas){

        //return rebaTabelaA[tronco-1][pescoco-1][pernas-1];
        return 5;

    }


    public int devolveTabelaB(int braco, int antebraco, int pulso){

       // return rebaTabelaB[braco-1][antebraco-1][pulso-1];
        return 5;

    }



    public int devolveTabelaC(int scoreA, int scoreB){

         //      return rebaTabelaC[scoreA][scoreB];
        return 5;


    }





}
