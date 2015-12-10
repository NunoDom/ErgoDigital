package dei.estg.ipleiria.pt.ergodigital;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import dei.estg.ipleiria.pt.ergodigital.TabelasDeReferencia.TabelaReferenciaRULA;

public class SistemaRulaActivity3 extends AppCompatActivity {

    int ResultadoA;
    int ResultadoB;
    int Musculatura=1;
    int Forca=1;
    int Lado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_rula3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getIntent().hasExtra("ResultadoA")){
            Bundle extras = getIntent().getExtras();
            ResultadoA=extras.getInt("ResultadoA");
            ResultadoA=extras.getInt("ResultadoB");
            Lado = extras.getInt("Lado");
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TabelaReferenciaRULA tab = new TabelaReferenciaRULA();

                Intent intent = new Intent();

                int resultadoC= ResultadoA+Musculatura+Forca;
                int resultadoD= ResultadoB+Musculatura+Forca;
                int ResultadoTotal = tab.devolveTabelaC(resultadoC, resultadoD);

                Toast.makeText(getApplicationContext(), "resultadoA: " + resultadoC+"\n resultadoB: "+ ResultadoB, Toast.LENGTH_SHORT).show();
                String message="";
                if (ResultadoTotal==1 ||ResultadoTotal==2)
                {
                    message="Postura aceitável, se não for mantida ou repetida por longos períodos de tempo";
                }
                if (ResultadoTotal==3 ||ResultadoTotal==4)
                {
                    message="Postura a investigar e poderão ser necessárias alterações";
                }
                if (ResultadoTotal==5 ||ResultadoTotal==6)
                {
                    message="Postura a investigar e alterar rapidamente";
                }
                if (ResultadoTotal==7)
                {
                    message="Postura a investigar e alterar urgentemente";
                }
                Toast.makeText(getApplicationContext(), "Resultado Total : " + ResultadoTotal+"\n "+message, Toast.LENGTH_SHORT).show();


            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
