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

        //TABELA A

        //TABELA TRONCO 1 // PESCOCO 1 //
        rebaTabelaA[0][0][0]=1;
        rebaTabelaA[0][0][1]=2;
        rebaTabelaA[0][0][2]=3;
        rebaTabelaA[0][0][3]=4;


        //TABELA TRONCO 1 // PESCOCO 2 //
        rebaTabelaA[0][1][0]=1;
        rebaTabelaA[0][1][1]=2;
        rebaTabelaA[0][1][2]=3;
        rebaTabelaA[0][1][3]=4;

        //TABELA TRONCO 1 // PESCOCO 3 //
        rebaTabelaA[0][2][0]=3;
        rebaTabelaA[0][2][1]=3;
        rebaTabelaA[0][2][2]=5;
        rebaTabelaA[0][2][3]=6;





        //TABELA TRONCO  // PESCOCO 1 //
        rebaTabelaA[1][0][0]=2;
        rebaTabelaA[1][0][1]=3;
        rebaTabelaA[1][0][2]=4;
        rebaTabelaA[1][0][3]=5;


        //TABELA TRONCO 2 // PESCOCO 2 //
        rebaTabelaA[1][1][0]=3;
        rebaTabelaA[1][1][1]=4;
        rebaTabelaA[1][1][2]=5;
        rebaTabelaA[1][1][3]=6;

        //TABELA TRONCO 2 // PESCOCO 3 //
        rebaTabelaA[1][2][0]=3;
        rebaTabelaA[1][2][1]=3;
        rebaTabelaA[1][2][2]=5;
        rebaTabelaA[1][2][3]=6;







        //TABELA TRONCO 3 // PESCOCO 1 //
        rebaTabelaA[2][0][0]=2;
        rebaTabelaA[2][0][1]=4;
        rebaTabelaA[2][0][2]=5;
        rebaTabelaA[2][0][3]=6;


        //TABELA TRONCO 3 // PESCOCO 2 //
        rebaTabelaA[2][1][0]=4;
        rebaTabelaA[2][1][1]=5;
        rebaTabelaA[2][1][2]=6;
        rebaTabelaA[2][1][3]=7;

        //TABELA TRONCO 3 // PESCOCO 3 //
        rebaTabelaA[2][2][0]=5;
        rebaTabelaA[2][2][1]=6;
        rebaTabelaA[2][2][2]=7;
        rebaTabelaA[2][2][3]=8;







        //TABELA TRONCO 4 // PESCOCO 1 //
        rebaTabelaA[3][0][0]=3;
        rebaTabelaA[3][0][1]=5;
        rebaTabelaA[3][0][2]=6;
        rebaTabelaA[3][0][3]=7;


        //TABELA TRONCO 4 // PESCOCO 2 //
        rebaTabelaA[3][1][0]=5;
        rebaTabelaA[3][1][1]=6;
        rebaTabelaA[3][1][2]=7;
        rebaTabelaA[3][1][3]=8;

        //TABELA TRONCO 4 // PESCOCO 3 //
        rebaTabelaA[3][2][0]=6;
        rebaTabelaA[3][2][1]=7;
        rebaTabelaA[3][2][2]=8;
        rebaTabelaA[3][2][3]=9;



        //TABELA TRONCO 5 // PESCOCO 1 //
        rebaTabelaA[4][0][0]=4;
        rebaTabelaA[4][0][1]=6;
        rebaTabelaA[4][0][2]=7;
        rebaTabelaA[4][0][3]=8;


        //TABELA TRONCO 5 // PESCOCO 2 //
        rebaTabelaA[4][1][0]=6;
        rebaTabelaA[4][1][1]=7;
        rebaTabelaA[4][1][2]=8;
        rebaTabelaA[4][1][3]=9;

        //TABELA TRONCO 5 // PESCOCO 3 //
        rebaTabelaA[4][2][0]=7;
        rebaTabelaA[4][2][1]=8;
        rebaTabelaA[4][2][2]=9;
        rebaTabelaA[4][2][3]=9;




//TABELA B


        //TABELA BRACO 1 // ANTEBRACO 1 //
        rebaTabelaB[0][0][0]=1;
        rebaTabelaB[0][0][1]=2;
        rebaTabelaB[0][0][2]=2;

        //TABELA BRACO 1 // ANTEBRACO 2 //
        rebaTabelaB[0][1][0]=1;
        rebaTabelaB[0][1][1]=2;
        rebaTabelaB[0][1][2]=3;

        //TABELA BRACO 2 // ANTEBRACO 1 //
        rebaTabelaB[1][0][0]=1;
        rebaTabelaB[1][0][1]=2;
        rebaTabelaB[1][0][2]=3;

        //TABELA BRACO 2 // ANTEBRACO 2 //
        rebaTabelaB[1][1][0]=2;
        rebaTabelaB[1][1][1]=3;
        rebaTabelaB[1][1][2]=4;


        //TABELA BRACO 3 // ANTEBRACO 1 //
        rebaTabelaB[2][0][0]=3;
        rebaTabelaB[2][0][1]=4;
        rebaTabelaB[2][0][2]=5;

        //TABELA BRACO 3 // ANTEBRACO 2 //
        rebaTabelaB[2][1][0]=4;
        rebaTabelaB[2][1][1]=5;
        rebaTabelaB[2][1][2]=5;

        //TABELA BRACO 4 // ANTEBRACO 1 //
        rebaTabelaB[3][0][0]=4;
        rebaTabelaB[3][0][1]=5;
        rebaTabelaB[3][0][2]=5;

        //TABELA BRACO 4 // ANTEBRACO 2 //
        rebaTabelaB[3][1][0]=5;
        rebaTabelaB[3][1][1]=6;
        rebaTabelaB[3][1][2]=7;

        //TABELA BRACO 5 // ANTEBRACO 1 //
        rebaTabelaB[4][0][0]=6;
        rebaTabelaB[4][0][1]=7;
        rebaTabelaB[4][0][2]=8;

        //TABELA BRACO 5 // ANTEBRACO 2 //
        rebaTabelaB[4][1][0]=7;
        rebaTabelaB[4][1][1]=8;
        rebaTabelaB[4][1][2]=8;

        //TABELA BRACO 6 // ANTEBRACO 1 //
        rebaTabelaB[5][0][0]=7;
        rebaTabelaB[5][0][1]=8;
        rebaTabelaB[5][0][2]=8;

        //TABELA BRACO 6 // ANTEBRACO 2 //
        rebaTabelaB[5][1][0]=8;
        rebaTabelaB[5][1][1]=9;
        rebaTabelaB[5][1][2]=9;

        //TABELA C

        rebaTabelaC[0][0]=1;
        rebaTabelaC[0][1]=1;
        rebaTabelaC[0][2]=1;
        rebaTabelaC[0][3]=2;
        rebaTabelaC[0][4]=3;
        rebaTabelaC[0][5]=3;
        rebaTabelaC[0][6]=4;
        rebaTabelaC[0][7]=5;
        rebaTabelaC[0][8]=6;
        rebaTabelaC[0][9]=7;
        rebaTabelaC[0][10]=7;
        rebaTabelaC[0][11]=7;

        rebaTabelaC[1][0]=1;
        rebaTabelaC[1][1]=2;
        rebaTabelaC[1][2]=2;
        rebaTabelaC[1][3]=3;
        rebaTabelaC[1][4]=4;
        rebaTabelaC[1][5]=4;
        rebaTabelaC[1][6]=5;
        rebaTabelaC[1][7]=6;
        rebaTabelaC[1][8]=6;
        rebaTabelaC[1][9]=7;
        rebaTabelaC[1][10]=7;
        rebaTabelaC[1][11]=8;

        rebaTabelaC[2][0]=2;
        rebaTabelaC[2][1]=3;
        rebaTabelaC[2][2]=3;
        rebaTabelaC[2][3]=3;
        rebaTabelaC[2][4]=4;
        rebaTabelaC[2][5]=5;
        rebaTabelaC[2][6]=6;
        rebaTabelaC[2][7]=7;
        rebaTabelaC[2][8]=7;
        rebaTabelaC[2][9]=8;
        rebaTabelaC[2][10]=8;
        rebaTabelaC[2][11]=8;

        rebaTabelaC[3][0]=3;
        rebaTabelaC[3][1]=4;
        rebaTabelaC[3][2]=4;
        rebaTabelaC[3][3]=4;
        rebaTabelaC[3][4]=5;
        rebaTabelaC[3][5]=6;
        rebaTabelaC[3][6]=7;
        rebaTabelaC[3][7]=8;
        rebaTabelaC[3][8]=8;
        rebaTabelaC[3][9]=9;
        rebaTabelaC[3][10]=9;
        rebaTabelaC[3][11]=9;

        rebaTabelaC[4][0]=4;
        rebaTabelaC[4][1]=4;
        rebaTabelaC[4][2]=4;
        rebaTabelaC[4][3]=5;
        rebaTabelaC[4][4]=6;
        rebaTabelaC[4][5]=7;
        rebaTabelaC[4][6]=8;
        rebaTabelaC[4][7]=8;
        rebaTabelaC[4][8]=9;
        rebaTabelaC[4][9]=9;
        rebaTabelaC[4][10]=9;
        rebaTabelaC[4][11]=9;

        rebaTabelaC[5][0]=6;
        rebaTabelaC[5][1]=6;
        rebaTabelaC[5][2]=6;
        rebaTabelaC[5][3]=7;
        rebaTabelaC[5][4]=8;
        rebaTabelaC[5][5]=8;
        rebaTabelaC[5][6]=9;
        rebaTabelaC[5][7]=9;
        rebaTabelaC[5][8]=10;
        rebaTabelaC[5][9]=10;
        rebaTabelaC[5][10]=10;
        rebaTabelaC[5][11]=10;

        rebaTabelaC[6][0]=7;
        rebaTabelaC[6][1]=7;
        rebaTabelaC[6][2]=8;
        rebaTabelaC[6][3]=9;
        rebaTabelaC[6][4]=9;
        rebaTabelaC[6][5]=9;
        rebaTabelaC[6][6]=10;
        rebaTabelaC[6][7]=10;
        rebaTabelaC[6][8]=10;
        rebaTabelaC[6][9]=11;
        rebaTabelaC[6][10]=11;
        rebaTabelaC[6][11]=11;

        rebaTabelaC[7][0]=8;
        rebaTabelaC[7][1]=8;
        rebaTabelaC[7][2]=8;
        rebaTabelaC[7][3]=9;
        rebaTabelaC[7][4]=10;
        rebaTabelaC[7][5]=10;
        rebaTabelaC[7][6]=10;
        rebaTabelaC[7][7]=10;
        rebaTabelaC[7][8]=11;
        rebaTabelaC[7][9]=11;
        rebaTabelaC[7][10]=11;
        rebaTabelaC[7][11]=11;


        rebaTabelaC[8][0]=9;
        rebaTabelaC[8][1]=9;
        rebaTabelaC[8][2]=9;
        rebaTabelaC[8][3]=10;
        rebaTabelaC[8][4]=10;
        rebaTabelaC[8][5]=10;
        rebaTabelaC[8][6]=11;
        rebaTabelaC[8][7]=11;
        rebaTabelaC[8][8]=11;
        rebaTabelaC[8][9]=12;
        rebaTabelaC[8][10]=12;
        rebaTabelaC[8][11]=12;

        rebaTabelaC[9][0]=10;
        rebaTabelaC[9][1]=10;
        rebaTabelaC[9][2]=10;
        rebaTabelaC[9][3]=11;
        rebaTabelaC[9][4]=11;
        rebaTabelaC[9][5]=11;
        rebaTabelaC[9][6]=11;
        rebaTabelaC[9][7]=12;
        rebaTabelaC[9][8]=12;
        rebaTabelaC[9][9]=12;
        rebaTabelaC[9][10]=12;
        rebaTabelaC[9][11]=12;

        rebaTabelaC[10][0]=11;
        rebaTabelaC[10][1]=11;
        rebaTabelaC[10][2]=11;
        rebaTabelaC[10][3]=12;
        rebaTabelaC[10][4]=12;
        rebaTabelaC[10][5]=12;
        rebaTabelaC[10][6]=12;
        rebaTabelaC[10][7]=12;
        rebaTabelaC[10][8]=12;
        rebaTabelaC[10][9]=12;
        rebaTabelaC[10][10]=12;
        rebaTabelaC[10][11]=12;

        rebaTabelaC[11][0]=12;
        rebaTabelaC[11][1]=12;
        rebaTabelaC[11][2]=12;
        rebaTabelaC[11][3]=12;
        rebaTabelaC[11][4]=12;
        rebaTabelaC[11][5]=12;
        rebaTabelaC[11][6]=12;
        rebaTabelaC[11][7]=12;
        rebaTabelaC[11][8]=12;
        rebaTabelaC[11][9]=12;
        rebaTabelaC[11][10]=12;
        rebaTabelaC[11][11]=12;



    }



    public int devolveTabelaA(int tronco, int pescoco, int pernas){

        return rebaTabelaA[tronco-1][pescoco-1][pernas-1];
        //return 5;

    }


    public int devolveTabelaB(int braco, int antebraco, int pulso){

       return rebaTabelaB[braco-1][antebraco-1][pulso-1];
       //return 5;

    }



    public int devolveTabelaC(int scoreA, int scoreB){

              return rebaTabelaC[scoreA-1][scoreB-1];
        //return 5;


    }





}
