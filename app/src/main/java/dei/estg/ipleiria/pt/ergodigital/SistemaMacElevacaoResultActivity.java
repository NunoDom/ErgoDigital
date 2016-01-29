package dei.estg.ipleiria.pt.ergodigital;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;

public class SistemaMacElevacaoResultActivity extends AppCompatActivity {


    int resultadoA=-1;
    int resultadoB=-1;
    int resultadoC=-1;
    int resultadoD=-1;
    int resultadoE=-1;
    int resultadoF=-1;
    int resultadoG=-1;
    int resultadoH=-1;
    int resultadoI=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_mac_elevacao_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Bundle extras = getIntent().getExtras();
        if (getIntent().hasExtra("resultadoA")) {
            resultadoA = extras.getInt("resultadoA");
            resultadoB = extras.getInt("resultadoB");
            resultadoC = extras.getInt("resultadoC");
            resultadoD = extras.getInt("resultadoD");
            resultadoE = extras.getInt("resultadoE");
            resultadoF = extras.getInt("resultadoF");
            resultadoG = extras.getInt("resultadoG");
            resultadoH = extras.getInt("resultadoH");
        }
        if (getIntent().hasExtra("resultadoI")){
        resultadoI = extras.getInt("resultadoI");
        }

        mostrarCores();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarCores();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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


    imageViewReasultadoA.setBackgroundResource(setCor(resultadoA));
    imageViewReasultadoB.setBackgroundResource(setCor(resultadoB));
    imageViewReasultadoC.setBackgroundResource(setCor(resultadoC));
    imageViewReasultadoD.setBackgroundResource(setCor(resultadoD));
    imageViewReasultadoE.setBackgroundResource(setCor(resultadoE));
    imageViewReasultadoF.setBackgroundResource(setCor(resultadoF));
    imageViewReasultadoG.setBackgroundResource(setCor(resultadoG));
    imageViewReasultadoH.setBackgroundResource(setCor(resultadoH));
    imageViewReasultadoI.setBackgroundResource(setCor(resultadoI));
}

    public int setCor(int color)
    {

    if(color==0) {
        return R.color.green;
    }
        if(color==1) {
            return R.color.orange;
        }

       if(color==2) {
           return R.color.red;
       }
        if(color==3) {
            return R.color.purple;
        }
        return R.color.black;
    }



}
