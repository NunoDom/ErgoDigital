package dei.estg.ipleiria.pt.ergodigital.TabelasDeReferencia;

import java.util.Arrays;

/**
 * Created by Nuno on 18/01/2016.
 */
public class TabelaReferenciaKIM {
    private double[][] tabKIM;

    public TabelaReferenciaKIM() {
        tabKIM = new double[5][7];
        //Arrays.fill(tabKIM, -1);
        create();
    }



    private void create() {

        //carga rolada
        tabKIM[0][0]=0.5;
        tabKIM[0][1]=1;
        tabKIM[0][2]=1.5;
        tabKIM[0][3]=2;
        tabKIM[0][4]=3;
        tabKIM[0][5]=4;
        tabKIM[0][6]=5;

        //carrinho de mao
        tabKIM[1][0]=0.5;
        tabKIM[1][1]=1;
        tabKIM[1][2]=2;
        tabKIM[1][3]=4;

        //carruagem, rolo , carro de transporte sem rolamentos fixos
        tabKIM[2][0]=0.5;
        tabKIM[2][1]=1;
        tabKIM[2][2]=2;
        tabKIM[2][3]=3;
        tabKIM[2][4]=4;
        tabKIM[2][5]=5;

        //veiculos em carris
        tabKIM[3][0]=0.5;
        tabKIM[3][1]=1;
        tabKIM[3][2]=1.5;
        tabKIM[3][3]=2;
        tabKIM[3][4]=3;
        tabKIM[3][5]=4;
        tabKIM[3][6]=5;

        //manipuladores , cordas, balanceiros
        tabKIM[4][0]=0.5;
        tabKIM[3][1]=1;
        tabKIM[3][2]=2;
        tabKIM[3][3]=4;
            }

    public double devolve(int tipoCarga, int pesoCarga){

        return tabKIM[tipoCarga-1][pesoCarga-1];

    }







}





