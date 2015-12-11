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
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import dei.estg.ipleiria.pt.ergodigital.TabelasDeReferencia.TabelaReferenciaOWAS;
import dei.estg.ipleiria.pt.ergodigital.TabelasDeReferencia.TabelaReferenciaRULA;

public class SistemaRulaActivity extends AppCompatActivity {

    int lado;

    int braco;
    int antebraco;
    int punho;
    int giro;

    int resultado;

    int bracoCorrecao;
    int antebroCorrecao;
    int punhoCorrecao;
    int giroCorrecao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_rula);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.rula_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SistemaRulaActivity.this,Pop.class);
                startActivity(intent);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



    Spinner spinner1= (Spinner)findViewById(R.id.cbRULAbraco);
    Spinner spinner2= (Spinner)findViewById(R.id.cbRULAantebraco);
    Spinner spinner3= (Spinner)findViewById(R.id.cbRulaPunho);
    Spinner spinner4= (Spinner)findViewById(R.id.cbRULA_giroPunho);
    Spinner spinner5= (Spinner)findViewById(R.id.cbRulaLado);


    spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            braco = position+1;
            actualizarImagens();

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    });

    spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            antebraco = position+1;
            actualizarImagens();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    });

    spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            punho = position+1;
            actualizarImagens();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    });



        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                giro = position+1;
                actualizarImagens();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                lado = position;
                actualizarImagens();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




}


    public void actualizarImagens()
    {
        ImageView imageBraco = (ImageView)findViewById(R.id.ivRULAbraco);
        ImageView imageAntebraco = (ImageView)findViewById(R.id.ivRULAantebraco);
        ImageView imagePunho =(ImageView)findViewById(R.id.ivRULApunho);
        CheckBox ch1= (CheckBox) findViewById(R.id.chckboxRulaBraco1);
        CheckBox ch2= (CheckBox) findViewById(R.id.chckboxRulaBraco2);
        CheckBox ch3= (CheckBox) findViewById(R.id.chckboxRulaBraco3);

        if (lado==0){
            switch (braco) {
                case 1:
                    imageBraco.setImageResource(R.drawable.ic_rula_rua1);
                    ch1.setEnabled(false);
                    ch2.setEnabled(false);
                    ch3.setEnabled(true);
                    break;
                case 2:
                    imageBraco.setImageResource(R.drawable.ic_rula_rua2);
                    ch1.setEnabled(false);
                    ch2.setEnabled(false);
                    ch3.setEnabled(false);
                    break;
                case 3:
                    imageBraco.setImageResource(R.drawable.ic_rula_rua3);
                    ch1.setEnabled(true);
                    ch2.setEnabled(true);
                    ch3.setEnabled(false);
                    break;
                case 4:
                    imageBraco.setImageResource(R.drawable.ic_rula_rua4);
                    ch1.setEnabled(true);
                    ch2.setEnabled(true);
                    ch3.setEnabled(false);
                    break;
                case 5:
                    imageBraco.setImageResource(R.drawable.ic_rula_rua5);
                    ch1.setEnabled(true);
                    ch2.setEnabled(true);
                    ch3.setEnabled(false);
                    break;

            }
            switch (antebraco) {
                case 1:
                    imageAntebraco.setImageResource(R.drawable.ic_rula_rla1);
                    break;
                case 2:
                    imageAntebraco.setImageResource(R.drawable.ic_rula_rla2);
                    break;
                case 3:
                    imageAntebraco.setImageResource(R.drawable.ic_rula_rla3);
                    break;

            }
            switch (punho) {
                case 1:
                    imagePunho.setImageResource(R.drawable.ic_rula_rw1);
                    break;
                case 2:
                    imagePunho.setImageResource(R.drawable.ic_rula_rw2);
                    break;
                case 3:
                    imagePunho.setImageResource(R.drawable.ic_rula_rw3);
                    break;
                case 4:
                    imagePunho.setImageResource(R.drawable.ic_rula_rw4);
                    break;

            }
        }
        else{
            switch (braco) {
                case 1:
                    imageBraco.setImageResource(R.drawable.ic_rula_lua1);
                    break;
                case 2:
                    imageBraco.setImageResource(R.drawable.ic_rula_lua2);
                    break;
                case 3:
                    imageBraco.setImageResource(R.drawable.ic_rula_lua3);
                    break;
                case 4:
                    imageBraco.setImageResource(R.drawable.ic_rula_lua4);
                    break;
                case 5:
                    imageBraco.setImageResource(R.drawable.ic_rula_lua5);
                    break;

            }
            switch (antebraco) {
                case 1:
                    imageAntebraco.setImageResource(R.drawable.ic_rula_lla1);
                    break;
                case 2:
                    imageAntebraco.setImageResource(R.drawable.ic_rula_lla2);
                    break;
                case 3:
                    imageAntebraco.setImageResource(R.drawable.ic_rula_lla3);
                    break;

            }

            switch (punho) {
                case 1:
                    imagePunho.setImageResource(R.drawable.ic_rula_lw1);
                    break;
                case 2:
                    imagePunho.setImageResource(R.drawable.ic_rula_lw2);
                    break;
                case 3:
                    imagePunho.setImageResource(R.drawable.ic_rula_lw3);
                    break;
                //case 4:
                //    imagePunho.setImageResource(R.drawable.ic_rula_lw4);
                //    break;

            }
        }


    }

    public void click(View view)
    {


        TabelaReferenciaRULA tab = new TabelaReferenciaRULA();


        if (braco>0&&antebraco>0&&punho>0&&giro>0 ) {

            CheckBox chckboxRulaBraco1 = (CheckBox)findViewById(R.id.chckboxRulaBraco1);
            CheckBox chckboxRulaBraco2 = (CheckBox)findViewById(R.id.chckboxRulaBraco2);
            CheckBox chckboxRulaBraco3 = (CheckBox)findViewById(R.id.chckboxRulaBraco3);
            CheckBox chckboxRulaABraco1 = (CheckBox)findViewById(R.id.chckboxRulaABraco1);
            CheckBox chckboxRulaPunho1 = (CheckBox)findViewById(R.id.chckboxRulaPunho1);

            if (chckboxRulaBraco1.isChecked())
            {
                braco+=1;
            }
            if (chckboxRulaBraco2.isChecked())
            {
                braco+=1;
            }
            if (chckboxRulaBraco3.isChecked())
            {
                braco-=1;
            }
            if (chckboxRulaABraco1.isChecked())
            {
                antebraco+=1;
            }
            if (chckboxRulaPunho1.isChecked())
            {
                punho+=1;
            }

            resultado = tab.devolveTabelaA(braco, antebraco, punho, giro);

            Toast.makeText(getApplicationContext(), "Braco : "+braco, Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(), "Antebraço : "+antebraco, Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(), "Punho : "+punho, Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(), "Giro : "+giro, Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(), "resultado: "+resultado,

                    Toast.LENGTH_SHORT).show();


        }

        Intent intent = new Intent(this, SistemaRulaActivity2.class);
        intent.putExtra("Lado",lado);
        intent.putExtra("ResultadoA",resultado);
        startActivity(intent);

    }


    public void OnClickChckboxBraco1(View view) {
        CheckBox ch2= (CheckBox) findViewById(R.id.chckboxRulaBraco2);
        ch2.setChecked(false);

    }

    public void OnClickChckboxBraco2(View view) {
        CheckBox ch1= (CheckBox) findViewById(R.id.chckboxRulaBraco1);
        ch1.setChecked(false);
    }
}
