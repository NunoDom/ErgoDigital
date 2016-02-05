package dei.estg.ipleiria.pt.ergodigital;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import dei.estg.ipleiria.pt.ergodigital.Model.Consulta;
import dei.estg.ipleiria.pt.ergodigital.Model.Resultado;
import dei.estg.ipleiria.pt.ergodigital.TabelasDeReferencia.TabelaReferenciaREBA;

public class SistemaRebaActivity2 extends AppCompatActivity {

    Consulta consulta;
    int resultadoA=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_reba2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        if (getIntent().hasExtra("consulta")) {
            Bundle extras = getIntent().getExtras();
            consulta = (Consulta)extras.getSerializable("consulta");
            resultadoA = Integer.parseInt(consulta.getListaResultados().get(consulta.getListaResultados().size()-1).getValor());
        }
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
        Spinner spinnerLado =  (Spinner)findViewById(R.id.cbRebaLado);
        spinnerLado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                TextView spinnerText = (TextView) parent.getChildAt(0);
                spinnerText.setTextColor(Color.BLACK);
                parent.setFocusable(false);
                parent.setFocusableInTouchMode(false);
                parent.clearFocus();
                actualizarImagens();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(verificaCampos())
                    analisar();
                }
            });
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);



    }

    private void actualizarImagens() {

    }


    public boolean verificaCampos()
    {
        Spinner spinnerLado =  (Spinner)findViewById(R.id.cbRebaLado);

        if(spinnerLado.getSelectedItemPosition()==0)
        {
            TextView spinnerText = (TextView)spinnerLado.getChildAt(0);
            spinnerText.setTextColor(Color.RED);
            spinnerLado.setFocusable(true);
            spinnerLado.setFocusableInTouchMode(true);
            spinnerLado.requestFocus();
            return false;
        }

        return true;

    }





    private void analisar()
    {

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
        int pega =spinner3.getSelectedItemPosition();

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
        resultadoB += pega;

        int resultadoC = tab.devolveTabelaC(resultadoA, resultadoB);


        Resultado resultadoBraco = new Resultado("Braço:",braco+"- "+spinner1.getSelectedItem().toString());
        Resultado resultadoAntebraco = new Resultado("Antebraço:",antebraco+"- "+spinner2.getSelectedItem().toString());
        Resultado resultadoPulso = new Resultado("Pulso: ",+pulso+"- "+spinner3.getSelectedItem().toString());
        Resultado resultadPega = new Resultado("Pega: ",+pega+"- "+spinner4.getSelectedItem().toString());
        Resultado resultadoBfinal = new Resultado("Resultado B \n", resultadoB+"");
        Resultado resultadoFinal = new Resultado("Resultado da Avaliação \n", resultadoC+"");

        consulta.addResultado(resultadoBraco);
        consulta.addResultado(resultadoAntebraco);
        consulta.addResultado(resultadoPulso);
        consulta.addResultado(resultadPega);
        consulta.addResultado(resultadoFinal);

        //Toast.makeText(getApplicationContext(), "RESULTADO A: " + resultadoA + "\nRESULTADO B: " + resultadoB + "\nRESULTADO FINAL: " + resultadoC, Toast.LENGTH_LONG).show();


        Intent intent= new Intent(this,ActivityResultado.class);
        intent.putExtra("consulta",consulta);
        startActivity(intent);

    }
}

