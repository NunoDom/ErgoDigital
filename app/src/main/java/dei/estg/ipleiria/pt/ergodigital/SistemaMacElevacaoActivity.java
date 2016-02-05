package dei.estg.ipleiria.pt.ergodigital;

import android.content.Intent;
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
import android.widget.Toast;
import android.widget.ToggleButton;

import dei.estg.ipleiria.pt.ergodigital.Model.Consulta;

public class SistemaMacElevacaoActivity extends AppCompatActivity {

    Consulta consulta;
    Integer resultadoA;
    Integer resultadoB;

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

        if (getIntent().hasExtra("consulta")) {
            Bundle extras = getIntent().getExtras();
            consulta = (Consulta)extras.getSerializable("consulta");
        }




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (verificaCampos(view)) {

                    calcularResultados(view);
                    Toast.makeText(SistemaMacElevacaoActivity.this, "Resultado A: " + resultadoA + "\nResultado B: " + resultadoB, Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(SistemaMacElevacaoActivity.this, SistemaMacElevacao2Activity.class);
                    intent.putExtra("resultadoA", resultadoA);
                    intent.putExtra("resultadoB", resultadoB);
                    startActivity(intent);
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


    private void calcularResultados(View view) {

        Spinner spinner1 = (Spinner) findViewById(R.id.cbGamElevacaoPontuacaoFrequenciaPeso);

        switch(spinner1.getSelectedItemPosition())
        {
            case 0: resultadoA=0; break;
            case 1: resultadoA=4; break;
            case 2: resultadoA=6; break;
            case 3: resultadoA=10; break;
        }
        RadioButton radioButton1 = (RadioButton) findViewById(R.id.rbGamElevacaoDistanciaMaos1);
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.rbGamElevacaoDistanciaMaos2);
        RadioButton radioButton3 = (RadioButton) findViewById(R.id.rbGamElevacaoDistanciaMaos3);
        RadioButton radioButton4 = (RadioButton) findViewById(R.id.rbGamElevacaoDistanciaMaos4);

        if (radioButton1.isChecked()) {
            resultadoB = 0;
        }
        if (radioButton2.isChecked()) {
            resultadoB = 3;
        }
        if (radioButton3.isChecked()) {
            resultadoB = 3;
        }
        if (radioButton4.isChecked()) {
            resultadoB = 6;
        }


    }



}
