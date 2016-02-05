package dei.estg.ipleiria.pt.ergodigital;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import dei.estg.ipleiria.pt.ergodigital.Model.Consulta;
import dei.estg.ipleiria.pt.ergodigital.Model.Resultado;
import dei.estg.ipleiria.pt.ergodigital.TabelasDeReferencia.TabelaReferenciaRULA;

public class SistemaRulaActivity2 extends AppCompatActivity {

    Consulta consulta;
    int ResultadoA;
    int Lado;
    int ResultadoB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_rula2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        if ((getIntent().hasExtra("consulta"))&&(getIntent().hasExtra("ResultadoA"))) {
            Bundle extras = getIntent().getExtras();
            consulta = (Consulta)extras.getSerializable("consulta");
            ResultadoA=extras.getInt("ResultadoA");
        }else{
            Toast.makeText(getApplicationContext(), "ERRO: 201", Toast.LENGTH_SHORT).show();
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                actualizaResultados();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        Spinner spinner1 = (Spinner) findViewById(R.id.cbRulaPescoco);


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ImageView imagePescoco = (ImageView)findViewById(R.id.ivRulaPescoco);

                switch (position+1) {
                    case 1:
                        imagePescoco.setImageResource(R.drawable.ic_rula_n1);
                        break;
                    case 2:
                        imagePescoco.setImageResource(R.drawable.ic_rula_n2);
                        break;
                    case 3:
                        imagePescoco.setImageResource(R.drawable.ic_rula_n3);
                        break;
                    case 4:
                        imagePescoco.setImageResource(R.drawable.ic_rula_n4);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Spinner spinner2 = (Spinner) findViewById(R.id.cbRulaTronco);


        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ImageView imageTronco = (ImageView)findViewById(R.id.ivRulaTronco);

                switch (position+1) {
                    case 1:
                        imageTronco.setImageResource(R.drawable.ic_rula_t1);
                        break;
                    case 2:
                        imageTronco.setImageResource(R.drawable.ic_rula_t2);
                        break;
                    case 3:
                        imageTronco.setImageResource(R.drawable.ic_rula_t3);
                        break;
                    case 4:
                        imageTronco.setImageResource(R.drawable.ic_rula_t4);
                        break;
                }

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


    Resultado resultadoPescoco = new Resultado("Pescoco: ", spinner1.getSelectedItem().toString()+"");
    Resultado resultadoTronco= new Resultado("Tronco: ",tronco+"- "+spinner2.getSelectedItem().toString());
    Resultado resultadoPernas = new Resultado("Pernas: ",pernas+"- "+spinner3.getSelectedItem().toString());

    consulta.addResultado(resultadoPescoco);
    consulta.addResultado(resultadoTronco);
    consulta.addResultado(resultadoPernas);

    Intent intent = new Intent(SistemaRulaActivity2.this, SistemaRulaActivity3.class);
    intent.putExtra("consulta",consulta);
    intent.putExtra("ResultadoA",ResultadoA);
    intent.putExtra("ResultadoB", ResultadoB);
    intent.putExtra("Lado", Lado);
    startActivity(intent);



}

}
