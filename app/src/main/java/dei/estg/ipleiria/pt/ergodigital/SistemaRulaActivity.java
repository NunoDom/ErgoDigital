package dei.estg.ipleiria.pt.ergodigital;

import android.app.Activity;
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
import dei.estg.ipleiria.pt.ergodigital.TabelasDeReferencia.TabelaReferenciaRULA;

public class SistemaRulaActivity extends AppCompatActivity {

    Consulta consulta;
    Spinner spinner1;
    Spinner spinner2;
    Spinner spinner3;
    Spinner spinner4;
    Spinner spinner5;
    static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_rula);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        SharedPreferences mPrefs = getSharedPreferences("dados", 0);
        int idConsulta = mPrefs.getInt("idConsulta", -1);

        if (idConsulta>0){
            consulta = GestaoUtentes.getInstance().getConsulta(idConsulta);
        }


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.rula_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click(view);
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
                LinearLayout layoutRula1Activity = (LinearLayout) findViewById(R.id.layoutRula1Activity);
                if (position == 0)//SE NÃO HOUVER ESCOLHA DO LADO NÃO APARECE OS RESTO DOS DADOS PARA PRENCHIMENTO
                {
                    layoutRula1Activity.setVisibility(View.GONE);
                }else//position > 0)//SE HOUVER A ESCOLHA DE UM LADO
                {
                    layoutRula1Activity.setVisibility(View.VISIBLE);

                    if (spinner5.isFocused()) {
                        TextView spinnerText = (TextView) parent.getChildAt(0);
                        spinnerText.setTextColor(Color.BLACK);
                        spinner5.setFocusable(false);
                        spinner5.setFocusableInTouchMode(false);
                        spinner5.clearFocus();

                    }

               }
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

        int braco = spinner1.getSelectedItemPosition()+1;
        int antebraco = spinner2.getSelectedItemPosition()+1;
        int punho = spinner3.getSelectedItemPosition()+1;
        int lado = spinner5.getSelectedItemPosition();

        if (lado==1) {

            switch (braco) {
                case 1:
                    imageBraco.setImageResource(R.drawable.ic_rula_rua1);
                    break;
                case 2:
                    imageBraco.setImageResource(R.drawable.ic_rula_rua2);
                    break;
                case 3:
                    imageBraco.setImageResource(R.drawable.ic_rula_rua3);
                    break;
                case 4:
                    imageBraco.setImageResource(R.drawable.ic_rula_rua4);
                    break;
                case 5:
                    imageBraco.setImageResource(R.drawable.ic_rula_rua5);
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

            int braco = (int) spinner1.getSelectedItemId() + 1;
            int antebraco = (int) spinner2.getSelectedItemId() + 1;
            int punho = (int) spinner3.getSelectedItemId() + 1;
            int giro = (int) spinner4.getSelectedItemId() + 1;
            //int lado = (int) spinner5.getSelectedItemId() - 1;


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

                    TextView tvBraco= (TextView)findViewById(R.id.tvRulaBraco);
                    TextView tvAntebraco= (TextView)findViewById(R.id.tvRULAantebraco);
                    TextView tvPunho= (TextView)findViewById(R.id.tvRulaPunho);
                    TextView tvRotacaoPunho= (TextView)findViewById(R.id.tvRulaGiroPunho);




                    Resultado resultadoLado = new Resultado("", spinner5.getSelectedItem().toString()+"");
                    Resultado resultadoBraco = new Resultado(tvBraco.getText().toString()+": ",braco+"- "+spinner1.getSelectedItem().toString());
                    Resultado resultadoAntebraco = new Resultado(tvAntebraco.getText().toString()+": ",antebraco+"- "+spinner2.getSelectedItem().toString());
                    Resultado resultadoPunho = new Resultado(tvPunho.getText().toString()+": ",+punho+"- "+spinner3.getSelectedItem().toString());
                    Resultado resultadoGiro = new Resultado(tvRotacaoPunho.getText().toString()+": ",+giro+"- "+spinner4.getSelectedItem().toString());

                    Resultado[] avaliacao = new Resultado[11];

                    avaliacao[0]=resultadoLado;
                    avaliacao[1]=resultadoBraco;
                    avaliacao[2]=resultadoAntebraco;
                    avaliacao[3]=resultadoPunho;
                    avaliacao[4]=resultadoGiro;


                   // if(consulta.getPessoa()!=null) {

                    //    consulta.getPessoa().addConsulta(consulta);
                  //  }
                    Intent intent= new Intent(this,SistemaRulaActivity2.class);
                    intent.putExtra("avaliacao", avaliacao);
                   // startActivity(intent);

                    resultado = tab.devolveTabelaA(braco, antebraco, punho, giro);
                    //Intent intent = new Intent(this, SistemaRulaActivity2.class);
                    //intent.putExtra("Lado", lado);
                    intent.putExtra("ResultadoA", resultado);
                    startActivityForResult(intent, 1);

                } else {
                    Toast.makeText(getApplicationContext(), "erro", Toast.LENGTH_SHORT).show();
                }
                //Toast.makeText(getApplicationContext(), "Braco : " + braco + "\nAntebraço : " + antebraco + "\nPunho : " + punho + "\nGiro : " + giro, Toast.LENGTH_SHORT).show();


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

    public void OnClickChckboxBraco1(View view) {
        CheckBox ch2= (CheckBox) findViewById(R.id.chckboxRulaBraco2);
        ch2.setChecked(false);

    }

    public void OnClickChckboxBraco2(View view) {
        CheckBox ch1= (CheckBox) findViewById(R.id.chckboxRulaBraco1);
        ch1.setChecked(false);
    }
}
