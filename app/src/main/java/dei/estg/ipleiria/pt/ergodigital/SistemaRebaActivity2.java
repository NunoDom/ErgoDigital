package dei.estg.ipleiria.pt.ergodigital;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import dei.estg.ipleiria.pt.ergodigital.Model.Consulta;
import dei.estg.ipleiria.pt.ergodigital.Model.GestaoUtentes;
import dei.estg.ipleiria.pt.ergodigital.Model.Resultado;
import dei.estg.ipleiria.pt.ergodigital.TabelasDeReferencia.TabelaReferenciaREBA;

public class SistemaRebaActivity2 extends AppCompatActivity {

    Resultado[] avaliacao;
    Consulta consulta;
    int resultadoA=-1;
    Spinner spinner1;
    Spinner spinner2;
    Spinner spinner3;
    Spinner spinner4;
    Spinner spinnerLado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_reba2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        spinnerLado =  (Spinner)findViewById(R.id.cbRebaLado);
        spinner1 = (Spinner) findViewById(R.id.cbRebaBraco);
         spinner2 = (Spinner) findViewById(R.id.cbRebaAntebraco);
         spinner3 = (Spinner) findViewById(R.id.cbRebaPulso);
         spinner4 = (Spinner) findViewById(R.id.cbRebaPega);

        if ((getIntent().hasExtra("avaliacao"))&&(getIntent().hasExtra("resultadoA"))) {
            Bundle extras = getIntent().getExtras();
            avaliacao = (Resultado[])extras.getSerializable("avaliacao");
            resultadoA=extras.getInt("resultadoA");
        }else{
            Toast.makeText(getApplicationContext(), "ERRO: 201", Toast.LENGTH_SHORT).show();
        }



        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0)
                    ((CheckBox) findViewById(R.id.chckboxRebaCorrecaoBraco3)).setEnabled(false);
                else
                    ((CheckBox) findViewById(R.id.chckboxRebaCorrecaoBraco3)).setEnabled(true);

        actualizarImagens();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                actualizarImagens();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                actualizarImagens();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                actualizarImagens();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerLado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                LinearLayout layoutRula1Activity = (LinearLayout) findViewById(R.id.layoutReba2);
                if (position == 0)//SE NÃO HOUVER ESCOLHA DO LADO NÃO APARECE OS RESTO DOS DADOS PARA PRENCHIMENTO
                {
                    layoutRula1Activity.setVisibility(View.GONE);
                }else//position > 0)//SE HOUVER A ESCOLHA DE UM LADO
                {
                    layoutRula1Activity.setVisibility(View.VISIBLE);

                    if (spinnerLado.isFocused()) {
                        TextView spinnerText = (TextView) parent.getChildAt(0);
                        spinnerText.setTextColor(Color.BLACK);
                        spinnerLado.setFocusable(false);
                        spinnerLado.setFocusableInTouchMode(false);
                        spinnerLado.clearFocus();

                    }

                }
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
                    if(verificaCampos()){
                    analisar();
                    }
                }
            });
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);



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



    public void actualizarImagens()
    {
        ImageView imageBraco = (ImageView)findViewById(R.id.imvRebaBraco);
        ImageView imageAntebraco = (ImageView)findViewById(R.id.imvRebaAntebraco);
        ImageView imagePunho =(ImageView)findViewById(R.id.imvRebaPulso);

        int braco =spinner1.getSelectedItemPosition()+1;
        int antebraco = spinner2.getSelectedItemPosition()+1;
        int punho = spinner3.getSelectedItemPosition()+1;
        int giro = spinner4.getSelectedItemPosition()+1;
        int lado = spinnerLado.getSelectedItemPosition();

        if (lado==1) {

            switch (braco) {
                case 1:
                    imageBraco.setImageResource(R.drawable.ic_reba_braco1);
                    break;
                case 2:
                    imageBraco.setImageResource(R.drawable.ic_reba_d_braco2);
                    break;
                case 3:
                    imageBraco.setImageResource(R.drawable.ic_reba_d_braco3);
                    break;
                case 4:
                    imageBraco.setImageResource(R.drawable.ic_reba_d_braco4);
                    break;
            }


            switch (antebraco) {
                case 1:
                    imageAntebraco.setImageResource(R.drawable.ic_reba_d_antebraco1);
                    break;
                case 2:
                    imageAntebraco.setImageResource(R.drawable.ic_reba_d_antebraco2);
                    break;
            }

            switch (punho) {
                case 1:
                    imagePunho.setImageResource(R.drawable.ic_reba_d_pulso1);
                    break;
                case 2:
                    imagePunho.setImageResource(R.drawable.ic_reba_d_pulso2);
                    break;

            }
        }
        else{
            switch (braco) {
                case 1:
                    imageBraco.setImageResource(R.drawable.ic_reba_braco1);
                    break;
                case 2:
                    imageBraco.setImageResource(R.drawable.ic_reba_e_braco2);
                    break;
                case 3:
                    imageBraco.setImageResource(R.drawable.ic_reba_e_braco3);
                    break;
                case 4:
                    imageBraco.setImageResource(R.drawable.ic_reba_e_braco4);
                    break;

            }
            switch (antebraco) {
                case 1:
                    imageAntebraco.setImageResource(R.drawable.ic_reba_e_antebraco1);
                    break;
                case 2:
                    imageAntebraco.setImageResource(R.drawable.ic_reba_e_antebraco2);
                    break;

            }

            switch (punho) {
                case 1:
                    imagePunho.setImageResource(R.drawable.ic_reba_e_pulso1);
                    break;
                case 2:
                    imagePunho.setImageResource(R.drawable.ic_reba_e_pulso2);
                    break;

            }
        }


    }



    private void analisar()
    {

        TabelaReferenciaREBA tab = new TabelaReferenciaREBA();


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

        avaliacao[5] = resultadoBraco;
        avaliacao[6]=resultadoAntebraco;
        avaliacao[7]=resultadoPulso;
        avaliacao[8]=resultadPega;
        avaliacao[9]=resultadoBfinal;
        avaliacao[10]=resultadoFinal;

        //Toast.makeText(getApplicationContext(), "RESULTADO A: " + resultadoA + "\nRESULTADO B: " + resultadoB + "\nRESULTADO FINAL: " + resultadoC, Toast.LENGTH_LONG).show();
        ;

        Consulta consulta;
        SharedPreferences mPrefs = getSharedPreferences("dados", 0);
        int idConsulta = mPrefs.getInt("idConsulta", -1);

        if (idConsulta > 0) {
            consulta = GestaoUtentes.getInstance().getConsulta(idConsulta);

            if (consulta.getPessoa() != null) {
                consulta.getPessoa().addConsulta(consulta);
            }
            for (int c=0;c<avaliacao.length;c++){
                Resultado resultado= new Resultado((avaliacao[c].getTitulo()),(avaliacao[c].getValor()));
                consulta.addResultado(resultado);
            }

            consulta.setFerramenta("REBA");
            Intent intent= new Intent(this,ActivityResultado.class);
            intent.putExtra("consulta",consulta);
            startActivity(intent);

            Intent returnIntent = new Intent();
            setResult(SistemaRebaActivity.RESULT_OK, returnIntent);
            finish();
        }else
        {
            Toast.makeText(getApplicationContext(), "ERRO nao existe consulta", Toast.LENGTH_SHORT).show();
        }




    }
}

