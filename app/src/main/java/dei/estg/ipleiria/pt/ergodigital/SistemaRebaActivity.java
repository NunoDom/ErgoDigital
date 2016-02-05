package dei.estg.ipleiria.pt.ergodigital;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Spinner;

import dei.estg.ipleiria.pt.ergodigital.Model.Consulta;
import dei.estg.ipleiria.pt.ergodigital.Model.Resultado;
import dei.estg.ipleiria.pt.ergodigital.TabelasDeReferencia.TabelaReferenciaREBA;

public class SistemaRebaActivity extends AppCompatActivity {

    Consulta consulta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_reba);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getIntent().hasExtra("consulta")) {
            Bundle extras = getIntent().getExtras();
            consulta = (Consulta)extras.getSerializable("consulta");
            /*
            if(valor>0) {
                Pessoa pessoa = GestaoUtentes.getInstance().getPessoa(extras.getInt("idUtente"));
                consulta = pessoa.getId();
            }*/

        }



        //GestaoUtentes.getInstance().addConsulta("REBA");
        //consulta = GestaoUtentes.getInstance().getListaConsultas().get(GestaoUtentes.getInstance().getListaConsultas().size()-1);





        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TabelaReferenciaREBA tab = new TabelaReferenciaREBA();

                Spinner spinner1 = (Spinner)findViewById(R.id.cbRebaTronco);
                Spinner spinner2 = (Spinner)findViewById(R.id.cbRebaPescoco);
                Spinner spinner3 = (Spinner)findViewById(R.id.cbRebaPernas);
                Spinner spinnerCarga = (Spinner)findViewById(R.id.cbRebaCarga);

                CheckBox checkBox1 = (CheckBox)findViewById(R.id.chckboxRebaCorrecaoTronco);
                CheckBox checkBox2 = (CheckBox)findViewById(R.id.chckboxRebaCorrecaoPescoco);
                CheckBox checkBox3 = (CheckBox)findViewById(R.id.chckboxRebaCorrecaoPernas1);
                CheckBox checkBox4 = (CheckBox)findViewById(R.id.chckboxRebaCorrecaoPernas2);
                CheckBox checkBox5 = (CheckBox)findViewById(R.id.chckboxRebaCorrecaoCarga);

                int tronco = spinner1.getSelectedItemPosition()+1;
                int pescoco = spinner2.getSelectedItemPosition()+1;
                int pernas = spinner3.getSelectedItemPosition()+1;
                int carga =spinnerCarga.getSelectedItemPosition();

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
                Resultado resultadoPescoco = new Resultado("Percoço:",pescoco+"- "+spinner2.getSelectedItem().toString());
                Resultado resultadoPernas = new Resultado("Pernas:",pernas+"- "+spinner3.getSelectedItem().toString());
                Resultado resultadoCarga  =  new Resultado("Carga:",carga+"- "+spinner1.getSelectedItem().toString());
                Resultado resultadoAfinal =  new Resultado(getString(R.string.ResultadoA),resultadoA+"");

                consulta.addResultado(resultadoTronco);
                consulta.addResultado(resultadoPescoco);
                consulta.addResultado(resultadoPernas);
                consulta.addResultado(resultadoCarga);
                consulta.addResultado(resultadoAfinal);


                Intent intent = new Intent(getApplicationContext(),SistemaRebaActivity2.class);
                intent.putExtra("consulta",consulta);
                startActivity(intent);
               finish();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



    public void clickRebaSeguinte(View view)
    {
//teste
    }

    public void clickChckboxRebaCorrecaoPernas1(View view) {
        ((CheckBox)findViewById(R.id.chckboxRebaCorrecaoPernas2)).setChecked(false);

    }
    public void clickChckboxRebaCorrecaoPernas2(View view) {
        ((CheckBox)findViewById(R.id.chckboxRebaCorrecaoPernas1)).setChecked(false);
    }
}
