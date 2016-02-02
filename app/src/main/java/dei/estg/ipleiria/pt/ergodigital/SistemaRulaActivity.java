package dei.estg.ipleiria.pt.ergodigital;

import android.content.Intent;
import android.graphics.Color;
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
import android.widget.TextView;
import android.widget.Toast;

import dei.estg.ipleiria.pt.ergodigital.Model.GestaoUtentes;
import dei.estg.ipleiria.pt.ergodigital.Model.Pessoa;
import dei.estg.ipleiria.pt.ergodigital.TabelasDeReferencia.TabelaReferenciaOWAS;
import dei.estg.ipleiria.pt.ergodigital.TabelasDeReferencia.TabelaReferenciaRULA;

public class SistemaRulaActivity extends AppCompatActivity {

    int idUtente=-1;
    Spinner spinner1;
    Spinner spinner2;
    Spinner spinner3;
    Spinner spinner4;
    Spinner spinner5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_rula);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        spinner5 = (Spinner) findViewById(R.id.cbRulaLado);

        if (getIntent().hasExtra("idUtente")) {
            Bundle extras = getIntent().getExtras();
            int valor = extras.getInt("idUtente");
            if(valor>0) {
                Pessoa pessoa = GestaoUtentes.getInstance().getPessoa(extras.getInt("idUtente"));
                idUtente = pessoa.getId();
            }
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.rula_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click(view);
                //Intent intent = new Intent(SistemaRulaActivity.this,Pop.class);
                //startActivity(intent);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        spinner1 = (Spinner) findViewById(R.id.cbRULAbraco);
        spinner2 = (Spinner) findViewById(R.id.cbRULAantebraco);
        spinner3 = (Spinner) findViewById(R.id.cbRulaPunho);
        spinner4 = (Spinner) findViewById(R.id.cbRULA_giroPunho);
        spinner5 = (Spinner) findViewById(R.id.cbRulaLado);


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                controlCheckBoxBraco(position);
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


        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                TextView spinnerText = (TextView) parent.getChildAt(0);
                spinnerText.setTextColor(Color.BLACK);
                spinner5.setFocusable(false);
                spinner5.setFocusableInTouchMode(false);
                spinner5.clearFocus();
                actualizarImagens();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
private void controlCheckBoxBraco(int posicao)
    {
        CheckBox ch1= (CheckBox) findViewById(R.id.chckboxRulaBraco1);
        CheckBox ch2= (CheckBox) findViewById(R.id.chckboxRulaBraco2);
        CheckBox ch3= (CheckBox) findViewById(R.id.chckboxRulaBraco3);

        ch1.setChecked(false);
        ch2.setChecked(false);
        ch3.setChecked(false);

        if(posicao==0)
        {
            ch1.setEnabled(true);
            ch2.setEnabled(true);
            ch3.setEnabled(false);
        }else
        {
            ch1.setEnabled(true);
            ch2.setEnabled(true);
            ch3.setEnabled(true);
        }
    }


    public void actualizarImagens()
    {
        ImageView imageBraco = (ImageView)findViewById(R.id.ivRULAbraco);
        ImageView imageAntebraco = (ImageView)findViewById(R.id.ivRULAantebraco);
        ImageView imagePunho =(ImageView)findViewById(R.id.ivRULApunho);


        //Spinner spinner1= (Spinner)findViewById(R.id.cbRULAbraco);
        //Spinner spinner2= (Spinner)findViewById(R.id.cbRULAantebraco);
        //Spinner spinner3= (Spinner)findViewById(R.id.cbRulaPunho);
        //Spinner spinner4= (Spinner)findViewById(R.id.cbRULA_giroPunho);
        //Spinner spinner5= (Spinner)findViewById(R.id.cbRulaLado);

        int braco = (int)spinner1.getSelectedItemId()+1;
        int antebraco = (int)spinner2.getSelectedItemId()+1;
        int punho = (int)spinner3.getSelectedItemId()+1;
        int giro = (int)spinner4.getSelectedItemId()+1;
        int lado = (int)spinner5.getSelectedItemId();



        if (lado==1){
                    switch (braco) {
                        case 1:
                            imageBraco.setImageResource(R.drawable.ic_rula_rua1);
                            //ch1.setEnabled(true);
                            //ch2.setEnabled(false);
                            //ch3.setEnabled(false);
                            break;
                        case 2:
                            imageBraco.setImageResource(R.drawable.ic_rula_rua2);
                            //ch1.setEnabled(true);
                            //ch2.setEnabled(true);
                            //ch3.setEnabled(true);
                            break;
                        case 3:
                            imageBraco.setImageResource(R.drawable.ic_rula_rua3);
                            //ch1.setEnabled(true);
                            //ch2.setEnabled(true);
                            //ch3.setEnabled(true);
                            break;
                        case 4:
                            imageBraco.setImageResource(R.drawable.ic_rula_rua4);
                            //ch1.setEnabled(true);
                            //ch2.setEnabled(true);
                            //ch3.setEnabled(true);
                            break;
                        case 5:
                            imageBraco.setImageResource(R.drawable.ic_rula_rua5);
                            //ch1.setEnabled(true);
                            //ch2.setEnabled(true);
                            //ch3.setEnabled(true);
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

            }
        }


    }

    public void click(View view)
    {

        if(verificaCampos()) {
            int resultado;

            TabelaReferenciaRULA tab = new TabelaReferenciaRULA();
            Spinner spinner1 = (Spinner) findViewById(R.id.cbRULAbraco);
            Spinner spinner2 = (Spinner) findViewById(R.id.cbRULAantebraco);
            Spinner spinner3 = (Spinner) findViewById(R.id.cbRulaPunho);
            Spinner spinner4 = (Spinner) findViewById(R.id.cbRULA_giroPunho);


            int braco = (int) spinner1.getSelectedItemId() + 1;
            int antebraco = (int) spinner2.getSelectedItemId() + 1;
            int punho = (int) spinner3.getSelectedItemId() + 1;
            int giro = (int) spinner4.getSelectedItemId() + 1;
            int lado = (int) spinner5.getSelectedItemId() - 1;


            if (braco > 0 && antebraco > 0 && punho > 0 && giro > 0) {

                CheckBox chckboxRulaBraco1 = (CheckBox) findViewById(R.id.chckboxRulaBraco1);
                CheckBox chckboxRulaBraco2 = (CheckBox) findViewById(R.id.chckboxRulaBraco2);
                CheckBox chckboxRulaBraco3 = (CheckBox) findViewById(R.id.chckboxRulaBraco3);
                CheckBox chckboxRulaABraco1 = (CheckBox) findViewById(R.id.chckboxRulaABraco1);
                CheckBox chckboxRulaPunho1 = (CheckBox) findViewById(R.id.chckboxRulaPunho1);

                if (chckboxRulaBraco1.isChecked()) {
                    braco += 1;
                }
                if (chckboxRulaBraco2.isChecked()) {
                    braco += 1;
                }
                if (chckboxRulaBraco3.isChecked()) {
                    braco -= 1;
                }
                if (chckboxRulaABraco1.isChecked()) {
                    antebraco += 1;
                }
                if (chckboxRulaPunho1.isChecked()) {
                    punho += 1;
                }

                if (braco <= 6 && antebraco <= 3 && punho <= 4 && giro <= 2) {
                    resultado = tab.devolveTabelaA(braco, antebraco, punho, giro);
                    Intent intent = new Intent(this, SistemaRulaActivity2.class);
                    intent.putExtra("Lado", lado);
                    intent.putExtra("ResultadoA", resultado);
                    startActivity(intent);
                    //finish();

                } else {
                    Toast.makeText(getApplicationContext(), "erro", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(getApplicationContext(), "Braco : " + braco + "\nAntebraço : " + antebraco + "\nPunho : " + punho + "\nGiro : " + giro, Toast.LENGTH_SHORT).show();


            } else {
                Toast.makeText(getApplicationContext(), "erro", Toast.LENGTH_SHORT).show();
            }


        }
    }



    public boolean verificaCampos()
    {

        if(spinner5.getSelectedItemPosition()==0)
        {
            TextView spinnerText = (TextView)spinner5.getChildAt(0);
            spinnerText.setTextColor(Color.RED);
            spinner5.setFocusable(true);
            spinner5.setFocusableInTouchMode(true);
            spinner5.requestFocus();
            return false;
        }

        return true;

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
