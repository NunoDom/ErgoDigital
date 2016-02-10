package dei.estg.ipleiria.pt.ergodigital;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Spinner;

import dei.estg.ipleiria.pt.ergodigital.Model.Consulta;
import dei.estg.ipleiria.pt.ergodigital.Model.GestaoUtentes;
import dei.estg.ipleiria.pt.ergodigital.Model.Resultado;
import dei.estg.ipleiria.pt.ergodigital.TabelasDeReferencia.TabelaReferenciaREBA;

public class SistemaRebaActivity extends AppCompatActivity {

    int tronco;
    int pescoco;
    int pernas;
    int carga;
    Consulta consulta;


    Spinner spinner1;
    Spinner spinner2;
    Spinner spinner3;
    Spinner spinnerCarga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_reba);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SharedPreferences mPrefs = getSharedPreferences("dados", 0);
        int idConsulta = mPrefs.getInt("idConsulta", -1);

        if (idConsulta>0){
            consulta = GestaoUtentes.getInstance().getConsulta(idConsulta);
        }

        spinner1 = (Spinner)findViewById(R.id.cbRebaTronco);
        spinner2 = (Spinner)findViewById(R.id.cbRebaPescoco);
        spinner3 = (Spinner)findViewById(R.id.cbRebaPernas);
        spinnerCarga = (Spinner)findViewById(R.id.cbRebaCarga);




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickRebaSeguinte();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);





                int carga =spinnerCarga.getSelectedItemPosition();

                spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        tronco = position+1;
                        ImageView image = (ImageView)findViewById(R.id.imvRebaTronco);
                        switch (tronco) {
                            case 1:
                                image.setImageResource(R.drawable.ic_reba_t1);
                                break;
                            case 2:
                                image.setImageResource(R.drawable.ic_reba_t2);
                                break;
                            case 3:
                                image.setImageResource(R.drawable.ic_reba_t3);
                                break;
                            case 4:
                                image.setImageResource(R.drawable.ic_reba_t4);
                                break;
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });




                spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        pescoco = position + 1;
                        ImageView image = (ImageView) findViewById(R.id.imvRebaPescoco);
                        switch (pescoco) {
                            case 1:
                                image.setImageResource(R.drawable.ic_reba_n1);
                                break;
                            case 2:
                                image.setImageResource(R.drawable.ic_reba_n2);
                                break;
                            case 3:
                                image.setImageResource(R.drawable.ic_reba_n3);
                                break;
                        }

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        pernas = position + 1;
                        ImageView image = (ImageView) findViewById(R.id.imvRebaPernas);
                        switch (pernas) {
                            case 1:
                                image.setImageResource(R.drawable.ic_reba_p1);
                                break;
                            case 2:
                                image.setImageResource(R.drawable.ic_reba_p2);
                                break;
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });



            }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                Intent returnIntent = new Intent();
                setResult(AvaliacaoPosturalActivity.RESULT_OK, returnIntent);
                finish();
            }
        }
    }

    public void clickRebaSeguinte()
    {
        TabelaReferenciaREBA tab = new TabelaReferenciaREBA();
        CheckBox checkBox1 = (CheckBox)findViewById(R.id.chckboxRebaCorrecaoTronco);
        CheckBox checkBox2 = (CheckBox)findViewById(R.id.chckboxRebaCorrecaoPescoco);
        CheckBox checkBox3 = (CheckBox)findViewById(R.id.chckboxRebaCorrecaoPernas1);
        CheckBox checkBox4 = (CheckBox)findViewById(R.id.chckboxRebaCorrecaoPernas2);
        CheckBox checkBox5 = (CheckBox)findViewById(R.id.chckboxRebaCorrecaoCarga);




        if (checkBox1.isChecked())
        {
            tronco+=1;
        }
        if (checkBox2.isChecked())
        {
            pescoco+=1;
        }

        if (checkBox3.isChecked())
        {
            pernas+=1;
        }

        if (checkBox4.isChecked())
        {
            pernas+=2;
        }


        Integer resultadoA=tab.devolveTabelaA(tronco,pescoco,pernas);
        resultadoA+=carga;

        if (checkBox5.isChecked())
        {
            resultadoA+=1;
        }



        Resultado resultadoTronco = new Resultado("Tronco:",tronco+"- "+spinner1.getSelectedItem().toString());
        Resultado resultadoPescoco = new Resultado("Pescoço:",pescoco+"- "+spinner2.getSelectedItem().toString());
        Resultado resultadoPernas = new Resultado("Pernas:",pernas+"- "+spinner3.getSelectedItem().toString());
        Resultado resultadoCarga  =  new Resultado("Carga:",carga+"- "+spinner1.getSelectedItem().toString());
        Resultado resultadoAfinal =  new Resultado(getString(R.string.ResultadoA),resultadoA+"");


        Resultado[] avaliacao = new Resultado[11];

        //consulta.addResultado(resultadoTronco);
        //consulta.addResultado(resultadoPescoco);
        //consulta.addResultado(resultadoPernas);
        //consulta.addResultado(resultadoCarga);
        //consulta.addResultado(resultadoAfinal);


        avaliacao[0]=resultadoTronco;
        avaliacao[1]=resultadoPescoco;
        avaliacao[2]=resultadoPernas;
        avaliacao[3]=resultadoCarga;
        avaliacao[4]=resultadoAfinal;

        Intent intent = new Intent(getApplicationContext(),SistemaRebaActivity2.class);
        intent.putExtra("avaliacao", avaliacao);
        intent.putExtra("resultadoA", resultadoA);
        startActivityForResult(intent, 1);



    }

    public void clickChckboxRebaCorrecaoPernas1(View view) {
        ((CheckBox)findViewById(R.id.chckboxRebaCorrecaoPernas2)).setChecked(false);

    }
    public void clickChckboxRebaCorrecaoPernas2(View view) {
        ((CheckBox)findViewById(R.id.chckboxRebaCorrecaoPernas1)).setChecked(false);
    }
}
