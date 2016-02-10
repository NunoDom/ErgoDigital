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
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import dei.estg.ipleiria.pt.ergodigital.Model.Consulta;
import dei.estg.ipleiria.pt.ergodigital.Model.GestaoUtentes;
import dei.estg.ipleiria.pt.ergodigital.Model.Resultado;

public class SistemaMacElevacaoActivity extends AppCompatActivity {

    Resultado[] resultados;
    Consulta consulta;
    Spinner spinnerPontuacao;
    RadioButton radioButtonOpcao1;
    RadioGroup radioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_mac_elevacao);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        radioGroup= (RadioGroup)findViewById(R.id.rgGamElevacaoDistanciaMaos);

        resultados = new Resultado[11];

        SharedPreferences mPrefs = getSharedPreferences("dados", 0);
        int idConsulta = mPrefs.getInt("idConsulta", -1);

        if (idConsulta>0){
            consulta = GestaoUtentes.getInstance().getConsulta(idConsulta);
        }





        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (verificaCampos(view)) {

                    calcularResultados();

                    Intent intent = new Intent(SistemaMacElevacaoActivity.this, SistemaMacElevacao2Activity.class);
                    intent.putExtra("resultados", resultados);
                    startActivityForResult(intent,1);
                }
            }
        });



        ToggleButton butaoImagem = (ToggleButton)findViewById(R.id.tgGamElevacaoGrafico);

        butaoImagem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                clickToggleButtonGrafico(isChecked);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                Intent returnIntent = new Intent();
                setResult(SistemaMacMainActivity.RESULT_OK, returnIntent);
                finish();
            }
        }
    }

    private void clickToggleButtonGrafico(Boolean estado)
    {

        ImageView imagem= (ImageView)findViewById(R.id.imagemGraficoElevacao);
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.layoutGraficoGamElevacao);

        if(estado) {
            //Toast.makeText(this,"ON",Toast.LENGTH_SHORT).show();;
            linearLayout.setVisibility(View.VISIBLE);
            imagem.setVisibility(View.VISIBLE);
        }else {
            //Toast.makeText(this,"OFF",Toast.LENGTH_SHORT).show();
            linearLayout.setVisibility(View.GONE);
            imagem.setVisibility(View.GONE);
        }

    }


    private boolean verificaCampos(View view)
    {

        if (radioGroup.getCheckedRadioButtonId() != -1)
        {
            return true;
        }
        else
        {
            LinearLayout linearLayout = (LinearLayout)findViewById(R.id.layoutGamElevacaoDistanciaMaosTitulo);
            TextView linha = (TextView)linearLayout.getChildAt(0);
            linha.setTextColor(Color.RED);
            linha.setFocusable(true);
            linha.setFocusableInTouchMode(true);
            linha.requestFocus();

            return false;
        }


    }


    private void calcularResultados() {




        Spinner spinner1 = (Spinner) findViewById(R.id.cbGamElevacaoPontuacaoFrequenciaPeso);

        switch(spinner1.getSelectedItemPosition())
        {
            case 0: resultados[0]=new Resultado(getString(R.string.GamElevacaoFrequenciaPesoCargaTitulo),"Green"); break;
            case 1: resultados[0]=new Resultado(getString(R.string.GamElevacaoFrequenciaPesoCargaTitulo),"Amber"); break;
            case 2: resultados[0]=new Resultado(getString(R.string.GamElevacaoFrequenciaPesoCargaTitulo),"Red"); break;
            case 3: resultados[0]=new Resultado(getString(R.string.GamElevacaoFrequenciaPesoCargaTitulo),"Purple"); break;
        }
        RadioButton radioButton1 = (RadioButton) findViewById(R.id.rbGamElevacaoDistanciaMaos1);
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.rbGamElevacaoDistanciaMaos2);
        RadioButton radioButton3 = (RadioButton) findViewById(R.id.rbGamElevacaoDistanciaMaos3);
        RadioButton radioButton4 = (RadioButton) findViewById(R.id.rbGamElevacaoDistanciaMaos4);

        if (radioButton1.isChecked()) {
            resultados[1]=new Resultado(getString(R.string.GamElevacaoFrequenciaPesoCargaTitulo),"Green");
        }
        if (radioButton2.isChecked()) {
            resultados[1]=new Resultado(getString(R.string.GamElevacaoFrequenciaPesoCargaTitulo),"Amber");
        }
        if (radioButton3.isChecked()) {
            resultados[1]=new Resultado(getString(R.string.GamElevacaoFrequenciaPesoCargaTitulo),"Red");
        }
        if (radioButton4.isChecked()) {
            resultados[1]=new Resultado(getString(R.string.GamElevacaoDistanciaMaosTitulo),"Purple");
        }


    }



}
