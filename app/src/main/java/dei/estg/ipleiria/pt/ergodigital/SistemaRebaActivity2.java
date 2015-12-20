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

import dei.estg.ipleiria.pt.ergodigital.TabelasDeReferencia.TabelaReferenciaREBA;

public class SistemaRebaActivity2 extends AppCompatActivity {

    int resultadoA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_reba2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Spinner spinner1 = (Spinner) findViewById(R.id.cbRebaBraco);


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0)
                    ((CheckBox) findViewById(R.id.chckboxRebaCorrecaoBraco3)).setEnabled(false);
                else
                    ((CheckBox) findViewById(R.id.chckboxRebaCorrecaoBraco3)).setEnabled(true);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });






        if (getIntent().hasExtra("ResultadoA")) {
            Bundle extras = getIntent().getExtras();
            resultadoA = extras.getInt("ResultadoA");
            //Lado = extras.getInt("Lado");


            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    TabelaReferenciaREBA tab = new TabelaReferenciaREBA();

                    Spinner spinner1 = (Spinner) findViewById(R.id.cbRebaBraco);
                    Spinner spinner2 = (Spinner) findViewById(R.id.cbRebaAntebraco);
                    Spinner spinner3 = (Spinner) findViewById(R.id.cbRebaPulso);
                    Spinner spinner4 = (Spinner) findViewById(R.id.cbRebaPega);

                    CheckBox checkBox1 = (CheckBox) findViewById(R.id.chckboxRebaCorrecaoBraco);
                    CheckBox checkBox2 = (CheckBox) findViewById(R.id.chckboxRebaCorrecaoBraco2);
                    CheckBox checkBox3 = (CheckBox) findViewById(R.id.chckboxRebaCorrecaoBraco3);
                    CheckBox checkBox4 = (CheckBox) findViewById(R.id.chckboxRebaCorrecaoPulso);

                    int braco = spinner1.getSelectedItemPosition() + 1;
                    int antebraco = spinner2.getSelectedItemPosition() + 1;
                    int pulso = spinner3.getSelectedItemPosition() + 1;

                    if (checkBox1.isChecked()) {
                        braco += 1;
                    }
                    if (checkBox2.isChecked()) {
                        braco += 1;
                    }

                    if (checkBox3.isChecked()) {
                        braco -= 1;
                    }

                    if (checkBox4.isChecked()) {
                        pulso += 1;
                    }


                    Integer resultadoB = tab.devolveTabelaB(braco, antebraco, pulso);
                    resultadoB += spinner4.getSelectedItemPosition();

                    int resultadoC = tab.devolveTabelaC(resultadoA, resultadoB);

                    //Intent intent = new Intent(getApplicationContext(),SistemaRebaActivity3.class);
                    //intent.putExtra("ResultadoFinal",resultadoC);
                    //startActivity(intent);

                    Toast.makeText(getApplicationContext(), "RESULTADO A: " + resultadoA + "\nRESULTADO B: " + resultadoB + "\nRESULTADO FINAL: " + resultadoC, Toast.LENGTH_LONG).show();


                }
            });
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }

    }
}

