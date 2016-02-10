package dei.estg.ipleiria.pt.ergodigital;

import android.app.Activity;
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
import android.widget.TextView;
import android.widget.Toast;

import dei.estg.ipleiria.pt.ergodigital.Model.Resultado;
import dei.estg.ipleiria.pt.ergodigital.TabelasDeReferencia.TabelaReferenciaRULA;

public class SistemaRulaActivity2 extends AppCompatActivity {

    Resultado[] avaliacao;
    int ResultadoA;
    int Lado;
    int ResultadoB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_rula2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        if ((getIntent().hasExtra("avaliacao"))&&(getIntent().hasExtra("ResultadoA"))) {
            Bundle extras = getIntent().getExtras();
            avaliacao = (Resultado[])extras.getSerializable("avaliacao");
            ResultadoA=extras.getInt("ResultadoA");
        }else{
            Toast.makeText(getApplicationContext(), "ERRO: 201", Toast.LENGTH_SHORT).show();
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                actualizaResultados();
                //sair();
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

private void sair()
{
    //Intent intent = this.getIntent();
    //intent.putExtra("SOMETHING", "EXTRAS");
    //this.setResult(RESULT_OK, intent);
    finish();
}


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                Intent returnIntent = new Intent();
                setResult(SistemaRulaActivity.RESULT_OK, returnIntent);
                finish();
            }
        }



    }

    @Override
    protected void onPause() {
      //  Intent intent = this.getIntent();
        //intent.putExtra("SOMETHING", "EXTRAS");
      //  this.setResult(1, intent);
        //finish();

      //  Toast.makeText(this,"ON PAUSE",Toast.LENGTH_SHORT).show();

        super.onPause();
        //Toast.makeText(this,"2",Toast.LENGTH_SHORT).show();
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

    //Toast.makeText(getApplicationContext(), "Pescoco : "+pescoco, Toast.LENGTH_SHORT).show();
    //Toast.makeText(getApplicationContext(), "Tronco : "+tronco, Toast.LENGTH_SHORT).show();
    //Toast.makeText(getApplicationContext(), "Pernas : "+pernas, Toast.LENGTH_SHORT).show();
    ResultadoB=tab.devolveTabelaB(pescoco,tronco,pernas);


    TextView tvPescoco= (TextView)findViewById(R.id.tvRulaPosicaoPescoco);
    TextView tvTronco= (TextView)findViewById(R.id.tvRulaPosicaoTronco);
    TextView tvPernas= (TextView)findViewById(R.id.tvRulaPosicaoPernas);


    Resultado resultadoPescoco = new Resultado(tvPescoco.getText().toString()+": ",pescoco+"- "+ spinner1.getSelectedItem().toString()+"");
    Resultado resultadoTronco= new Resultado(tvTronco.getText().toString()+": ",tronco+"- "+spinner2.getSelectedItem().toString());
    Resultado resultadoPernas = new Resultado(tvPernas.getText().toString()+": ",pernas+"- "+spinner3.getSelectedItem().toString());

    avaliacao[5]=resultadoPescoco;
    avaliacao[6]=resultadoTronco;
    avaliacao[7]=resultadoPernas;

    Intent intent = new Intent(SistemaRulaActivity2.this, SistemaRulaActivity3.class);
    intent.putExtra("avaliacao",avaliacao);
    intent.putExtra("ResultadoA",ResultadoA);
    intent.putExtra("ResultadoB", ResultadoB);
    startActivityForResult(intent, 1);



}

}
