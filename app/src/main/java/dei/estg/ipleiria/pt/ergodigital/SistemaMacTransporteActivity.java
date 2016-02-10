package dei.estg.ipleiria.pt.ergodigital;

import android.app.Activity;
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
import android.widget.ToggleButton;

import dei.estg.ipleiria.pt.ergodigital.Model.Resultado;

public class SistemaMacTransporteActivity extends AppCompatActivity {

    Resultado[] resultados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_mac_transporte);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        resultados = new Resultado[11];
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (verificaCampos(view)) {

                    calcularResultados(view);
                    Intent intent = new Intent(SistemaMacTransporteActivity.this, SistemaMacTransporte2Activity.class);
                    intent.putExtra("resultados", resultados);
                    startActivityForResult(intent, 1);
                }
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        ToggleButton butaoImagem = (ToggleButton)findViewById(R.id.tgGamTransporteGrafico);

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

        ImageView imagem= (ImageView)findViewById(R.id.imagemGraficoTransporte);
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.layoutGraficoGamTransporte);

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
        RadioGroup radioGroup= (RadioGroup)findViewById(R.id.rgGamTransporteDistanciaMaos);
        if (radioGroup.getCheckedRadioButtonId() != -1)
        {
            return true;
        }
        else
        {
            LinearLayout linearLayout = (LinearLayout)findViewById(R.id.layoutGamTransporteDistanciaMaosTitulo);
            TextView linha = (TextView)linearLayout.getChildAt(0);
            linha.setTextColor(Color.RED);
            linha.setFocusable(true);
            linha.setFocusableInTouchMode(true);
            linha.requestFocus();

            return false;
        }


    }

    private void calcularResultados(View view) {

        Spinner spinner1 = (Spinner) findViewById(R.id.cbGamTransportePontuacaoFrequenciaPeso);

        switch(spinner1.getSelectedItemPosition())
        {
            case 0: resultados[0]=new Resultado(getString(R.string.GamElevacaoFrequenciaPesoCargaTitulo),"Green"); break;
            case 1: resultados[0]=new Resultado(getString(R.string.GamElevacaoFrequenciaPesoCargaTitulo),"Amber"); break;
            case 2: resultados[0]=new Resultado(getString(R.string.GamElevacaoFrequenciaPesoCargaTitulo),"Red"); break;
            case 3: resultados[0]=new Resultado(getString(R.string.GamElevacaoFrequenciaPesoCargaTitulo),"Purple"); break;
        }
        RadioButton radioButton1 = (RadioButton) findViewById(R.id.rbGamTransporteDistanciaMaos1);
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.rbGamTransporteDistanciaMaos2);
        RadioButton radioButton3 = (RadioButton) findViewById(R.id.rbGamTransporteDistanciaMaos3);
        RadioButton radioButton4 = (RadioButton) findViewById(R.id.rbGamTransporteDistanciaMaos4);

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
