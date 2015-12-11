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
                finish();
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
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Spinner spinner2 = (Spinner) findViewById(R.id.cbRulaTronco);


        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


public void actualizaResultados()
{   TabelaReferenciaRULA tab = new TabelaReferenciaRULA();
    Spinner spinner1 = (Spinner) findViewById(R.id.cbRulaPescoco);
    Spinner spinner2 = (Spinner) findViewById(R.id.cbRulaTronco);
    Spinner spinner3 = (Spinner) findViewById(R.id.cbRulaPernas);

    int pescoco=spinner1.getSelectedItemPosition()+1;
    int tronco=spinner2.getSelectedItemPosition()+1;
    int pernas=spinner3.getSelectedItemPosition()+1;


    CheckBox chckboxRulaPescoco1 = (CheckBox)findViewById(R.id.chckboxRulaPescoco1);
    CheckBox chckboxRulaPescoco2 = (CheckBox)findViewById(R.id.chckboxRulaPescoco2);
    CheckBox chckboxRulaTronco1 = (CheckBox)findViewById(R.id.chckboxRulaTronco1);
    CheckBox chckboxRulaTronco2 = (CheckBox)findViewById(R.id.chckboxRulaTronco2);

    if(chckboxRulaPescoco1.isChecked())
    {
        pescoco+=1;
    }
    if(chckboxRulaPescoco2.isChecked())
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

    Toast.makeText(getApplicationContext(), "Pescoco : "+pescoco, Toast.LENGTH_SHORT).show();
    Toast.makeText(getApplicationContext(), "Tronco : "+tronco, Toast.LENGTH_SHORT).show();
    Toast.makeText(getApplicationContext(), "Pernas : "+pernas, Toast.LENGTH_SHORT).show();
    ResultadoB=tab.devolveTabelaB(pescoco,tronco,pernas);

}

}
