package dei.estg.ipleiria.pt.ergodigital.TabelasDeReferencia;

/**
 * Created by Nuno on 12/11/2015.
 */
public class TabelaReferenciaRULA {
    private int[][][][] rulaTabelaA;
    private int[][][] rulaTabelaB;
    private int[][] rulaTabelaC;
    private int[][]rulaTabelaD;


    public TabelaReferenciaRULA() {
        rulaTabelaA = new int[6][3][4][2];
        rulaTabelaB = new int[6][6][2];
        rulaTabelaC = new int[8][7];
        rulaTabelaD = new int[8][7];

        create();
    }

    private void create() {


        //TABELA A

        //TABELA OMBRO 1 // COTOVELO 1 // PUNHO 1
        rulaTabelaA[0][0][0][0]=1;
        rulaTabelaA[0][0][0][1]=2;
        //TABELA OMBRO 1 // COTOVELO 1 // PUNHO 2
        rulaTabelaA[0][0][1][0]=1;
        rulaTabelaA[0][0][1][1]=2;
        //TABELA OMBRO 1 // COTOVELO 1 // PUNHO 3
        rulaTabelaA[0][0][2][0]=2;
        rulaTabelaA[0][0][2][1]=2;
        //TABELA OMBRO 1 // COTOVELO 1 // PUNHO 4
        rulaTabelaA[0][0][3][0]=2;
        rulaTabelaA[0][0][3][1]=2;

        //TABELA OMBRO 1 // COTOVELO 2 // PUNHO 1
        rulaTabelaA[0][1][0][0]=2;
        rulaTabelaA[0][1][0][1]=2;
        //TABELA OMBRO 1 // COTOVELO 2 // PUNHO 2
        rulaTabelaA[0][1][1][0]=2;
        rulaTabelaA[0][1][1][1]=2;
        //TABELA OMBRO 1 // COTOVELO 2 // PUNHO 3
        rulaTabelaA[0][1][2][0]=2;
        rulaTabelaA[0][1][2][1]=2;
        //TABELA OMBRO 1 // COTOVELO 2 // PUNHO 4
        rulaTabelaA[0][1][3][0]=2;
        rulaTabelaA[0][1][3][1]=2;

        //TABELA OMBRO 1 // COTOVELO 3 // PUNHO 1
        rulaTabelaA[0][2][0][0]=2;
        rulaTabelaA[0][2][0][1]=3;
        //TABELA OMBRO 1 // COTOVELO 3 // PUNHO 2
        rulaTabelaA[0][2][1][0]=2;
        rulaTabelaA[0][2][1][1]=3;
        //TABELA OMBRO 1 // COTOVELO 3 // PUNHO 3
        rulaTabelaA[0][2][2][0]=3;
        rulaTabelaA[0][2][2][1]=3;
        //TABELA OMBRO 1 // COTOVELO 3 // PUNHO 4
        rulaTabelaA[0][2][3][0]=3;
        rulaTabelaA[0][2][3][1]=3;


        //TABELA OMBRO 2 // COTOVELO 1 // PUNHO 1
        rulaTabelaA[1][0][0][0]=2;
        rulaTabelaA[1][0][0][1]=3;
        //TABELA OMBRO 2 // COTOVELO 1 // PUNHO 2
        rulaTabelaA[1][0][1][0]=2;
        rulaTabelaA[1][0][1][1]=3;
        //TABELA OMBRO 2 // COTOVELO 1 // PUNHO 3
        rulaTabelaA[1][0][2][0]=3;
        rulaTabelaA[1][0][2][1]=3;
        //TABELA OMBRO 2 // COTOVELO 1 // PUNHO 4
        rulaTabelaA[1][0][3][0]=3;
        rulaTabelaA[1][0][3][1]=3;

        //TABELA OMBRO 2 // COTOVELO 2 // PUNHO 1
        rulaTabelaA[1][1][0][0]=3;
        rulaTabelaA[1][1][0][1]=3;
        //TABELA OMBRO 2 // COTOVELO 2 // PUNHO 2
        rulaTabelaA[1][1][1][0]=3;
        rulaTabelaA[1][1][1][1]=3;
        //TABELA OMBRO 2 // COTOVELO 2 // PUNHO 3
        rulaTabelaA[1][1][2][0]=3;
        rulaTabelaA[1][1][2][1]=3;
        //TABELA OMBRO 2 // COTOVELO 2 // PUNHO 4
        rulaTabelaA[1][1][3][0]=3;
        rulaTabelaA[1][1][3][1]=3;

        //TABELA OMBRO 2 // COTOVELO 3 // PUNHO 1
        rulaTabelaA[1][2][0][0]=3;
        rulaTabelaA[1][2][0][1]=4;
        //TABELA OMBRO 2 // COTOVELO 3 // PUNHO 2
        rulaTabelaA[1][2][1][0]=3;
        rulaTabelaA[1][2][1][1]=4;
        //TABELA OMBRO 2 // COTOVELO 3 // PUNHO 3
        rulaTabelaA[1][2][2][0]=4;
        rulaTabelaA[1][2][2][1]=4;
        //TABELA OMBRO 2 // COTOVELO 3 // PUNHO 4
        rulaTabelaA[1][2][3][0]=4;
        rulaTabelaA[1][2][3][1]=4;

 //------------------------------------------------------------ <<<<>>>

        //TABELA OMBRO 3 // COTOVELO 1 // PUNHO 1
        rulaTabelaA[2][0][0][0]=3;
        rulaTabelaA[2][0][0][1]=3;
        //TABELA OMBRO 3 // COTOVELO 1 // PUNHO 2
        rulaTabelaA[2][0][1][0]=3;
        rulaTabelaA[2][0][1][1]=3;
        //TABELA OMBRO 3 // COTOVELO 1 // PUNHO 3
        rulaTabelaA[2][0][2][0]=4;
        rulaTabelaA[2][0][2][1]=4;
        //TABELA OMBRO 3 // COTOVELO 1 // PUNHO 4
        rulaTabelaA[2][0][3][0]=4;
        rulaTabelaA[2][0][3][1]=4;

        //TABELA OMBRO 3 // COTOVELO 2 // PUNHO 1
        rulaTabelaA[2][1][0][0]=3;
        rulaTabelaA[2][1][0][1]=4;
        //TABELA OMBRO 3 // COTOVELO 2 // PUNHO 2
        rulaTabelaA[2][1][1][0]=3;
        rulaTabelaA[2][1][1][1]=4;
        //TABELA OMBRO 3 // COTOVELO 2 // PUNHO 3
        rulaTabelaA[2][1][2][0]=4;
        rulaTabelaA[2][1][2][1]=4;
        //TABELA OMBRO 3 // COTOVELO 2 // PUNHO 4
        rulaTabelaA[2][1][3][0]=4;
        rulaTabelaA[2][1][3][1]=4;

        //TABELA OMBRO 3 // COTOVELO 3 // PUNHO 1
        rulaTabelaA[2][2][0][0]=4;
        rulaTabelaA[2][2][0][1]=4;
        //TABELA OMBRO 3 // COTOVELO 3 // PUNHO 2
        rulaTabelaA[2][2][1][0]=4;
        rulaTabelaA[2][2][1][1]=4;
        //TABELA OMBRO 3 // COTOVELO 3 // PUNHO 3
        rulaTabelaA[2][2][2][0]=4;
        rulaTabelaA[2][2][2][1]=4;
        //TABELA OMBRO 3 // COTOVELO 3 // PUNHO 4
        rulaTabelaA[2][2][3][0]=4;
        rulaTabelaA[2][2][3][1]=4;

 // ------------------------------------------------------------

        //TABELA OMBRO 4 // COTOVELO 1 // PUNHO 1
        rulaTabelaA[3][0][0][0]=4;
        rulaTabelaA[3][0][0][1]=4;
        //TABELA OMBRO 4 // COTOVELO 1 // PUNHO 2
        rulaTabelaA[3][0][1][0]=4;
        rulaTabelaA[3][0][1][1]=4;
        //TABELA OMBRO 4 // COTOVELO 1 // PUNHO 3
        rulaTabelaA[3][0][2][0]=4;
        rulaTabelaA[3][0][2][1]=4;
        //TABELA OMBRO 4 // COTOVELO 1 // PUNHO 4
        rulaTabelaA[3][0][3][0]=4;
        rulaTabelaA[3][0][3][1]=4;

        //TABELA OMBRO 4 // COTOVELO 2 // PUNHO 1
        rulaTabelaA[3][1][0][0]=4;
        rulaTabelaA[3][1][0][1]=4;
        //TABELA OMBRO 4 // COTOVELO 2 // PUNHO 2
        rulaTabelaA[3][1][1][0]=4;
        rulaTabelaA[3][1][1][1]=4;
        //TABELA OMBRO 4 // COTOVELO 2 // PUNHO 3
        rulaTabelaA[3][1][2][0]=4;
        rulaTabelaA[3][1][2][1]=4;
        //TABELA OMBRO 4 // COTOVELO 2 // PUNHO 4
        rulaTabelaA[3][1][3][0]=4;
        rulaTabelaA[3][1][3][1]=4;

        //TABELA OMBRO 4 // COTOVELO 3 // PUNHO 1
        rulaTabelaA[3][2][0][0]=4;
        rulaTabelaA[3][2][0][1]=4;
        //TABELA OMBRO 4 // COTOVELO 3 // PUNHO 2
        rulaTabelaA[3][2][1][0]=4;
        rulaTabelaA[3][2][1][1]=4;
        //TABELA OMBRO 4 // COTOVELO 3 // PUNHO 3
        rulaTabelaA[3][2][2][0]=4;
        rulaTabelaA[3][2][2][1]=5;
        //TABELA OMBRO 4 // COTOVELO 3 // PUNHO 4
        rulaTabelaA[3][2][3][0]=4;
        rulaTabelaA[3][2][3][1]=5;

// ------------------------------------------------------------

        //TABELA OMBRO 5 // COTOVELO 1 // PUNHO 1
        rulaTabelaA[4][0][0][0]=5;
        rulaTabelaA[4][0][0][1]=5;
        //TABELA OMBRO 5 // COTOVELO 1 // PUNHO 2
        rulaTabelaA[4][0][1][0]=5;
        rulaTabelaA[4][0][1][1]=5;
        //TABELA OMBRO 5 // COTOVELO 1 // PUNHO 3
        rulaTabelaA[4][0][2][0]=5;
        rulaTabelaA[4][0][2][1]=5;
        //TABELA OMBRO 5 // COTOVELO 1 // PUNHO 4
        rulaTabelaA[4][0][3][0]=5;
        rulaTabelaA[4][0][3][1]=5;

        //TABELA OMBRO 5 // COTOVELO 2 // PUNHO 1
        rulaTabelaA[4][1][0][0]=5;
        rulaTabelaA[4][1][0][1]=6;
        //TABELA OMBRO 5 // COTOVELO 2 // PUNHO 2
        rulaTabelaA[4][1][1][0]=5;
        rulaTabelaA[4][1][1][1]=6;
        //TABELA OMBRO 5 // COTOVELO 2 // PUNHO 3
        rulaTabelaA[4][1][2][0]=6;
        rulaTabelaA[4][1][2][1]=4;
        //TABELA OMBRO 5 // COTOVELO 2 // PUNHO 4
        rulaTabelaA[4][1][3][0]=6;
        rulaTabelaA[4][1][3][1]=6;

        //TABELA OMBRO 5 // COTOVELO 3 // PUNHO 1
        rulaTabelaA[4][2][0][0]=6;
        rulaTabelaA[4][2][0][1]=6;
        //TABELA OMBRO 5 // COTOVELO 3 // PUNHO 2
        rulaTabelaA[4][2][1][0]=6;
        rulaTabelaA[4][2][1][1]=6;
        //TABELA OMBRO 5 // COTOVELO 3 // PUNHO 3
        rulaTabelaA[4][2][2][0]=6;
        rulaTabelaA[4][2][2][1]=7;
        //TABELA OMBRO 5 // COTOVELO 3 // PUNHO 4
        rulaTabelaA[4][2][3][0]=6;
        rulaTabelaA[4][2][3][1]=7;

// ------------------------------------------------------------

        //TABELA OMBRO 6 // COTOVELO 1 // PUNHO 1
        rulaTabelaA[5][0][0][0]=7;
        rulaTabelaA[5][0][0][1]=7;
        //TABELA OMBRO 6 // COTOVELO 1 // PUNHO 2
        rulaTabelaA[5][0][1][0]=7;
        rulaTabelaA[5][0][1][1]=7;
        //TABELA OMBRO 6 // COTOVELO 1 // PUNHO 3
        rulaTabelaA[5][0][2][0]=7;
        rulaTabelaA[5][0][2][1]=7;
        //TABELA OMBRO 6 // COTOVELO 1 // PUNHO 4
        rulaTabelaA[5][0][3][0]=7;
        rulaTabelaA[5][0][3][1]=7;

        //TABELA OMBRO 6 // COTOVELO 2 // PUNHO 1
        rulaTabelaA[5][1][0][0]=8;
        rulaTabelaA[5][1][0][1]=8;
        //TABELA OMBRO 6 // COTOVELO 2 // PUNHO 2
        rulaTabelaA[5][1][1][0]=8;
        rulaTabelaA[5][1][1][1]=8;
        //TABELA OMBRO 6 // COTOVELO 2 // PUNHO 3
        rulaTabelaA[5][1][2][0]=8;
        rulaTabelaA[5][1][2][1]=8;
        //TABELA OMBRO 6 // COTOVELO 2 // PUNHO 4
        rulaTabelaA[5][1][3][0]=8;
        rulaTabelaA[5][1][3][1]=8;

        //TABELA OMBRO 6 // COTOVELO 3 // PUNHO 1
        rulaTabelaA[5][2][0][0]=9;
        rulaTabelaA[5][2][0][1]=9;
        //TABELA OMBRO 6 // COTOVELO 3 // PUNHO 2
        rulaTabelaA[5][2][1][0]=9;
        rulaTabelaA[5][2][1][1]=9;
        //TABELA OMBRO 6 // COTOVELO 3 // PUNHO 3
        rulaTabelaA[5][2][2][0]=9;
        rulaTabelaA[5][2][2][1]=9;
        //TABELA OMBRO 6 // COTOVELO 3 // PUNHO 4
        rulaTabelaA[5][2][3][0]=9;
        rulaTabelaA[5][2][3][1]=9;





// ------------------------------------------------------------
// ------------------------------------------------------------
// ------------------------------------------------------------



        //TABELA B

        //TABELA PESCOÇO 1 // TRONCO 1
        rulaTabelaB[0][0][0]=1;
        rulaTabelaB[0][0][1]=3;
        //TABELA PESCOÇO 1 // TRONCO 2
        rulaTabelaB[0][1][0]=2;
        rulaTabelaB[0][1][1]=3;
        //TABELA PESCOÇO 1 // TRONCO 3
        rulaTabelaB[0][2][0]=3;
        rulaTabelaB[0][2][1]=4;
        //TABELA PESCOÇO 1 // TRONCO 4
        rulaTabelaB[0][3][0]=5;
        rulaTabelaB[0][3][1]=5;
        //TABELA PESCOÇO 1 // TRONCO 5
        rulaTabelaB[0][4][0]=6;
        rulaTabelaB[0][4][1]=6;
        //TABELA PESCOÇO 1 // TRONCO 6
        rulaTabelaB[0][5][0]=7;
        rulaTabelaB[0][5][1]=7;


        //TABELA PESCOÇO 2 // TRONCO 1
        rulaTabelaB[1][0][0]=2;
        rulaTabelaB[1][0][1]=3;
        //TABELA PESCOÇO 2 // TRONCO 2
        rulaTabelaB[1][1][0]=2;
        rulaTabelaB[1][1][1]=3;
        //TABELA PESCOÇO 2 // TRONCO 3
        rulaTabelaB[1][2][0]=4;
        rulaTabelaB[1][2][1]=5;
        //TABELA PESCOÇO 2 // TRONCO 4
        rulaTabelaB[1][3][0]=5;
        rulaTabelaB[1][3][1]=5;
        //TABELA PESCOÇO 2 // TRONCO 5
        rulaTabelaB[1][4][0]=6;
        rulaTabelaB[1][4][1]=7;
        //TABELA PESCOÇO 2 // TRONCO 6
        rulaTabelaB[1][5][0]=7;
        rulaTabelaB[1][5][1]=7;


        //TABELA PESCOÇO 3 // TRONCO 1
        rulaTabelaB[2][0][0]=3;
        rulaTabelaB[2][0][1]=3;
        //TABELA PESCOÇO 3 // TRONCO 2
        rulaTabelaB[2][1][0]=3;
        rulaTabelaB[2][1][1]=4;
        //TABELA PESCOÇO 3 // TRONCO 3
        rulaTabelaB[2][2][0]=4;
        rulaTabelaB[2][2][1]=5;
        //TABELA PESCOÇO 3 // TRONCO 4
        rulaTabelaB[2][3][0]=5;
        rulaTabelaB[2][3][1]=6;
        //TABELA PESCOÇO 3 // TRONCO 5
        rulaTabelaB[2][4][0]=6;
        rulaTabelaB[2][4][1]=7;
        //TABELA PESCOÇO 3 // TRONCO 6
        rulaTabelaB[2][5][0]=7;
        rulaTabelaB[2][5][1]=7;

        //TABELA PESCOÇO 4 // TRONCO 1
        rulaTabelaB[3][0][0]=5;
        rulaTabelaB[3][0][1]=5;
        //TABELA PESCOÇO 4 // TRONCO 2
        rulaTabelaB[3][1][0]=5;
        rulaTabelaB[3][1][1]=6;
        //TABELA PESCOÇO 4 // TRONCO 3
        rulaTabelaB[3][2][0]=6;
        rulaTabelaB[3][2][1]=7;
        //TABELA PESCOÇO 4 // TRONCO 4
        rulaTabelaB[3][3][0]=7;
        rulaTabelaB[3][3][1]=7;
        //TABELA PESCOÇO 4 // TRONCO 5
        rulaTabelaB[3][4][0]=7;
        rulaTabelaB[3][4][1]=7;
        //TABELA PESCOÇO 4 // TRONCO 6
        rulaTabelaB[3][5][0]=8;
        rulaTabelaB[3][5][1]=8;

        //TABELA PESCOÇO 5 // TRONCO 1
        rulaTabelaB[4][0][0]=7;
        rulaTabelaB[4][0][1]=7;
        //TABELA PESCOÇO 5 // TRONCO 2
        rulaTabelaB[4][1][0]=7;
        rulaTabelaB[4][1][1]=7;
        //TABELA PESCOÇO 5 // TRONCO 3
        rulaTabelaB[4][2][0]=7;
        rulaTabelaB[4][2][1]=8;
        //TABELA PESCOÇO 5 // TRONCO 4
        rulaTabelaB[4][3][0]=8;
        rulaTabelaB[4][3][1]=8;
        //TABELA PESCOÇO 5 // TRONCO 5
        rulaTabelaB[4][4][0]=8;
        rulaTabelaB[4][4][1]=8;
        //TABELA PESCOÇO 5 // TRONCO 6
        rulaTabelaB[4][5][0]=8;
        rulaTabelaB[4][5][1]=8;

        //TABELA PESCOÇO 6 // TRONCO 1
        rulaTabelaB[5][0][0]=8;
        rulaTabelaB[5][0][1]=8;
        //TABELA PESCOÇO 6 // TRONCO 2
        rulaTabelaB[5][1][0]=8;
        rulaTabelaB[5][1][1]=8;
        //TABELA PESCOÇO 6 // TRONCO 3
        rulaTabelaB[5][2][0]=8;
        rulaTabelaB[5][2][1]=8;
        //TABELA PESCOÇO 6 // TRONCO 4
        rulaTabelaB[5][3][0]=8;
        rulaTabelaB[5][3][1]=9;
        //TABELA PESCOÇO 6 // TRONCO 5
        rulaTabelaB[5][4][0]=9;
        rulaTabelaB[5][4][1]=9;
        //TABELA PESCOÇO 6 // TRONCO 6
        rulaTabelaB[5][5][0]=9;
        rulaTabelaB[5][5][1]=9;

// ------------------------------------------------------------
// ------------------------------------------------------------
// ------------------------------------------------------------
        //TABELA C
        //TABELA SUPERIOR 1
        rulaTabelaC[0][0]=1;
        rulaTabelaC[0][1]=2;
        rulaTabelaC[0][2]=3;
        rulaTabelaC[0][3]=3;
        rulaTabelaC[0][4]=4;
        rulaTabelaC[0][5]=5;
        rulaTabelaC[0][6]=5;

        //TABELA SUPERIOR 2
        rulaTabelaC[1][0]=2;
        rulaTabelaC[1][1]=2;
        rulaTabelaC[1][2]=3;
        rulaTabelaC[1][3]=4;
        rulaTabelaC[1][4]=4;
        rulaTabelaC[1][5]=5;
        rulaTabelaC[1][6]=5;

        //TABELA SUPERIOR 3
        rulaTabelaC[2][0]=3;
        rulaTabelaC[2][1]=3;
        rulaTabelaC[2][2]=3;
        rulaTabelaC[2][3]=4;
        rulaTabelaC[2][4]=4;
        rulaTabelaC[2][5]=5;
        rulaTabelaC[2][6]=6;


        //TABELA SUPERIOR 4
        rulaTabelaC[3][0]=3;
        rulaTabelaC[3][1]=3;
        rulaTabelaC[3][2]=3;
        rulaTabelaC[3][3]=4;
        rulaTabelaC[3][4]=5;
        rulaTabelaC[3][5]=6;
        rulaTabelaC[3][6]=6;

        //TABELA SUPERIOR 5
        rulaTabelaC[4][0]=4;
        rulaTabelaC[4][1]=4;
        rulaTabelaC[4][2]=4;
        rulaTabelaC[4][3]=5;
        rulaTabelaC[4][4]=6;
        rulaTabelaC[4][5]=7;
        rulaTabelaC[4][6]=7;

        //TABELA SUPERIOR 6
        rulaTabelaC[5][0]=4;
        rulaTabelaC[5][1]=4;
        rulaTabelaC[5][2]=5;
        rulaTabelaC[5][3]=6;
        rulaTabelaC[5][4]=6;
        rulaTabelaC[5][5]=7;
        rulaTabelaC[5][6]=7;

        //TABELA SUPERIOR 7
        rulaTabelaC[6][0]=5;
        rulaTabelaC[6][1]=5;
        rulaTabelaC[6][2]=6;
        rulaTabelaC[6][3]=6;
        rulaTabelaC[6][4]=7;
        rulaTabelaC[6][5]=7;
        rulaTabelaC[6][6]=7;


        //TABELA SUPERIOR 8
        rulaTabelaC[7][0]=5;
        rulaTabelaC[7][1]=5;
        rulaTabelaC[7][2]=6;
        rulaTabelaC[7][3]=7;
        rulaTabelaC[7][4]=7;
        rulaTabelaC[7][5]=7;
        rulaTabelaC[7][6]=7;



        //---------------------------------------------------------
        //----------------------------------------------------------
        //TABELA D

        //TABELA MEMBROS SUPERIORES 1 // PESCOCO,TRONCO e PERNAS
        rulaTabelaD[0][0]=1;
        rulaTabelaD[0][1]=2;
        rulaTabelaD[0][2]=3;
        rulaTabelaD[0][3]=3;
        rulaTabelaD[0][4]=4;
        rulaTabelaD[0][5]=5;
        rulaTabelaD[0][6]=5;

        //TABELA MEMBROS SUPERIORES 2 // PESCOCO,TRONCO e PERNAS
        rulaTabelaD[1][0]=2;
        rulaTabelaD[1][1]=2;
        rulaTabelaD[1][2]=3;
        rulaTabelaD[1][3]=4;
        rulaTabelaD[1][4]=4;
        rulaTabelaD[1][5]=5;
        rulaTabelaD[1][6]=5;

        //TABELA MEMBROS SUPERIORES 3 // PESCOCO,TRONCO e PERNAS
        rulaTabelaD[2][0]=3;
        rulaTabelaD[2][1]=3;
        rulaTabelaD[2][2]=3;
        rulaTabelaD[2][3]=4;
        rulaTabelaD[2][4]=4;
        rulaTabelaD[2][5]=5;
        rulaTabelaD[2][6]=6;

        //TABELA MEMBROS SUPERIORES 4 // PESCOCO,TRONCO e PERNAS
        rulaTabelaD[3][0]=3;
        rulaTabelaD[3][1]=3;
        rulaTabelaD[3][2]=3;
        rulaTabelaD[3][3]=4;
        rulaTabelaD[3][4]=5;
        rulaTabelaD[3][5]=6;
        rulaTabelaD[3][6]=6;

        //TABELA MEMBROS SUPERIORES 5 // PESCOCO,TRONCO e PERNAS
        rulaTabelaD[4][0]=4;
        rulaTabelaD[4][1]=4;
        rulaTabelaD[4][2]=4;
        rulaTabelaD[4][3]=5;
        rulaTabelaD[4][4]=6;
        rulaTabelaD[4][5]=7;
        rulaTabelaD[4][6]=7;

        //TABELA MEMBROS SUPERIORES 6 // PESCOCO,TRONCO e PERNAS
        rulaTabelaD[5][0]=4;
        rulaTabelaD[5][1]=5;
        rulaTabelaD[5][2]=4;
        rulaTabelaD[5][3]=5;
        rulaTabelaD[5][4]=5;
        rulaTabelaD[5][5]=7;
        rulaTabelaD[5][6]=7;

        //TABELA MEMBROS SUPERIORES 7 // PESCOCO,TRONCO e PERNAS
        rulaTabelaD[6][0]=5;
        rulaTabelaD[6][1]=5;
        rulaTabelaD[6][2]=6;
        rulaTabelaD[6][3]=6;
        rulaTabelaD[6][4]=7;
        rulaTabelaD[6][5]=7;
        rulaTabelaD[6][6]=7;

        //TABELA MEMBROS SUPERIORES 8 // PESCOCO,TRONCO e PERNAS
        rulaTabelaD[7][0]=5;
        rulaTabelaD[7][1]=5;
        rulaTabelaD[7][2]=6;
        rulaTabelaD[7][3]=7;
        rulaTabelaD[7][4]=7;
        rulaTabelaD[7][5]=7;
        rulaTabelaD[7][6]=7;

    }

    public int devolveTabelaA(int torso, int bracos, int pernas, int forca){

        return rulaTabelaA[torso-1][bracos-1][pernas-1][forca-1];

    }


    public int devolveTabelaB(int pescoco, int tronco, int extInferiores){

        return rulaTabelaB[pescoco-1][tronco-1][extInferiores-1];

    }

    public int devolveTabelaC(int superior, int inferior){

        if (inferior>7) {
            return rulaTabelaC[superior - 1][6];
        }else{
            return rulaTabelaC[superior - 1][inferior - 1];
        }
    }

    public int devolveTabelaD(int membrosSuperiores, int pescocoTroncoPernas){

        if (pescocoTroncoPernas>7) {
            return rulaTabelaC[membrosSuperiores - 1][6];
        }else{
            return rulaTabelaC[membrosSuperiores - 1][pescocoTroncoPernas - 1];
        }
    }

}

