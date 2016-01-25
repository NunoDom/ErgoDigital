package dei.estg.ipleiria.pt.ergodigital;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class SistemaMacElevacaoResultActivity extends AppCompatActivity {


    int resultadoA;
    int resultadoB;
    int resultadoC;
    int resultadoD;
    int resultadoE;
    int resultadoF;
    int resultadoG;
    int resultadoH;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_mac_elevacao_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        if (getIntent().hasExtra("resultadoA")) {
            Bundle extras = getIntent().getExtras();
            resultadoA = extras.getInt("resultadoA");
            resultadoB = extras.getInt("resultadoB");
            resultadoC = extras.getInt("resultadoC");
            resultadoD = extras.getInt("resultadoD");
            resultadoE = extras.getInt("resultadoE");
            resultadoF = extras.getInt("resultadoF");
            resultadoG = extras.getInt("resultadoG");
            resultadoH = extras.getInt("resultadoH");
        }





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


    ImageView imageViewQuadrado1= (ImageView)findViewById(R.id.imageViewQuadrado1);
    if(resultadoH>10)
    {
        imageViewQuadrado1.setColorFilter(Color.YELLOW);
    }else
        imageViewQuadrado1.setColorFilter(Color.RED);
}





}
