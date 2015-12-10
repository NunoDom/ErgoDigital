package dei.estg.ipleiria.pt.ergodigital;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import dei.estg.ipleiria.pt.ergodigital.TabelasDeReferencia.TabelaReferenciaRULA;

public class SistemaRulaActivity2 extends AppCompatActivity {

    int ResultadoA;
    int Lado;
    int ResultadoB;
    int pescoco=1;
    int tronco=1;
    int pernas=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_rula2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                actualizaResultados();

                Toast.makeText(getApplicationContext(), "resultado: " + ResultadoB,

                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SistemaRulaActivity2.this, SistemaRulaActivity3.class);
                intent.putExtra("ResultadoA",ResultadoA);
                intent.putExtra("ResultadoB",ResultadoB);
                intent.putExtra("Lado",Lado);
                startActivity(intent);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        if (getIntent().hasExtra("ResultadoA")){
        Bundle extras = getIntent().getExtras();
        ResultadoA=extras.getInt("ResultadoA");
        Lado = extras.getInt("Lado");
        }

        Spinner spinner1 = (Spinner) findViewById(R.id.cbRulaPescoco);


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pescoco = position +1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Spinner spinner2 = (Spinner) findViewById(R.id.cbRulaTronco);


        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tronco = position +1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });








    }


public void actualizaResultados()
{
    TabelaReferenciaRULA tab = new TabelaReferenciaRULA();
    CheckBox chckboxRulaPescoco1 = (CheckBox)findViewById(R.id.chckboxRulaPescoco);
    CheckBox chckboxRulaTronco1 = (CheckBox)findViewById(R.id.chckboxRulaTronco1);
    CheckBox chckboxRulaTronco2 = (CheckBox)findViewById(R.id.chckboxRulaTronco2);
    CheckBox chckboxRulaPernas1 = (CheckBox)findViewById(R.id.chckboxRulaPernas1);
    CheckBox chckboxRulaPernas2 = (CheckBox)findViewById(R.id.chckboxRulaPernas2);

    if(chckboxRulaPescoco1.isChecked())
    {
        pescoco+=1;
    }
    if(chckboxRulaTronco1.isChecked())
    {
        tronco+=1;
    }
    if(chckboxRulaTronco2.isChecked())
    {
        tronco+=1;
    }
    if(chckboxRulaPernas1.isChecked())
    {
        pernas+=1;
    }
    if(chckboxRulaPernas2.isChecked())
    {
        pernas+=1;
    }

    ResultadoB=tab.devolveTabelaB(pescoco,tronco,pernas);

}

}
