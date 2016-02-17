package dei.estg.ipleiria.pt.ergodigital;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ImageView;

import java.util.ArrayList;

import dei.estg.ipleiria.pt.ergodigital.Model.Consulta;
import dei.estg.ipleiria.pt.ergodigital.Model.Resultado;

public class SistemaMacElevacaoResultActivity extends AppCompatActivity {


    Resultado[] resultados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_mac_elevacao_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Bundle extras = getIntent().getExtras();
        if (getIntent().hasExtra("resultados")) {
            resultados = (Resultado[])extras.getSerializable("resultados");
        }else {
            if (getIntent().hasExtra("consulta")) {
                Consulta consulta = (Consulta)extras.getSerializable("consulta");
                ArrayList<Resultado> resultadosList = consulta.getListaResultados();
                resultados = new Resultado[11];
                if(resultadosList.size()==8){
                    for(int i=0;i<resultadosList.size();i++)
                    resultados[i]=resultadosList.get(i);
                }
                if(resultadosList.size()==9){
                    Resultado resultadoTest =resultadosList.get(3);
                    if(resultadosList.get(3).getTitulo().equals(getString(R.string.GamElevacaoConstrangimentTitulo))) {
                        resultados[0] = resultadosList.get(0);
                        resultados[1] = resultadosList.get(1);
                        resultados[2] = resultadosList.get(2);
                        resultados[4] = resultadosList.get(3);
                        resultados[5] = resultadosList.get(4);
                        resultados[6] = resultadosList.get(5);
                        resultados[7] = resultadosList.get(6);
                        resultados[8] = resultadosList.get(7);
                        resultados[9] = resultadosList.get(8);
                    }else {
                        resultados[0] = resultadosList.get(0);
                        resultados[1] = resultadosList.get(1);
                        resultados[2] = resultadosList.get(2);
                        resultados[3] = resultadosList.get(3);
                        resultados[4] = resultadosList.get(4);
                        resultados[5] = resultadosList.get(5);
                        resultados[6] = resultadosList.get(6);
                        resultados[7] = resultadosList.get(7);
                        resultados[10] = resultadosList.get(8);
                    }
                }
            }
        }

        mostrarCores();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_resultados, menu);
        return true;



    }


private void mostrarCores()
{

    ImageView imageViewReasultadoA= (ImageView)findViewById(R.id.imageViewReasultadoA);
    ImageView imageViewReasultadoB= (ImageView)findViewById(R.id.imageViewReasultadoB);
    ImageView imageViewReasultadoC= (ImageView)findViewById(R.id.imageViewReasultadoC);
    ImageView imageViewReasultadoD= (ImageView)findViewById(R.id.imageViewReasultadoD);
    ImageView imageViewReasultadoE= (ImageView)findViewById(R.id.imageViewReasultadoE);
    ImageView imageViewReasultadoF= (ImageView)findViewById(R.id.imageViewReasultadoF);
    ImageView imageViewReasultadoG= (ImageView)findViewById(R.id.imageViewReasultadoG);
    ImageView imageViewReasultadoH= (ImageView)findViewById(R.id.imageViewReasultadoH);
    ImageView imageViewReasultadoI= (ImageView)findViewById(R.id.imageViewReasultadoI);
    ImageView imageViewReasultadoJ= (ImageView)findViewById(R.id.imageViewReasultadoJ);
    ImageView imageViewReasultadoK= (ImageView)findViewById(R.id.imageViewReasultadoK);


    imageViewReasultadoA.setBackgroundResource(setCor(resultados[0]));
    imageViewReasultadoB.setBackgroundResource(setCor(resultados[1]));
    imageViewReasultadoC.setBackgroundResource(setCor(resultados[2]));
    imageViewReasultadoD.setBackgroundResource(setCor(resultados[3]));
    imageViewReasultadoE.setBackgroundResource(setCor(resultados[4]));
    imageViewReasultadoF.setBackgroundResource(setCor(resultados[5]));
    imageViewReasultadoG.setBackgroundResource(setCor(resultados[6]));
    imageViewReasultadoH.setBackgroundResource(setCor(resultados[7]));
    imageViewReasultadoI.setBackgroundResource(setCor(resultados[8]));
    imageViewReasultadoJ.setBackgroundResource(setCor(resultados[9]));
    imageViewReasultadoK.setBackgroundResource(setCor(resultados[10]));
}

    public int setCor(Resultado resultado) {
        if (resultado != null) {
            if (resultado.getValor().equals("Green")) {
                return R.color.green;
            }
            if (resultado.getValor().equals("Ambar")) {
                return R.color.orange;
            }

            if (resultado.getValor().equals("Red")) {
                return R.color.red;
            }
            if (resultado.getValor().equals("Purple")) {
                return R.color.purple;
            }
            return R.color.black;
        }else{
        return R.color.black;
        }
    }



}
