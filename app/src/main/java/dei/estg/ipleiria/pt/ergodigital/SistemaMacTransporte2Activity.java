package dei.estg.ipleiria.pt.ergodigital;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import dei.estg.ipleiria.pt.ergodigital.Model.Resultado;

public class SistemaMacTransporte2Activity extends AppCompatActivity {

    Resultado[] resultados;
    RadioGroup radioGroup1;
    RadioGroup radioGroup2;
    RadioGroup radioGroup3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_mac_transporte2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getIntent().hasExtra("resultados")) {
            Bundle extras = getIntent().getExtras();
            resultados = (Resultado[])extras.getSerializable("resultados");
        }else
        {
            Toast.makeText(SistemaMacTransporte2Activity.this,"Missing resultados",Toast.LENGTH_LONG).show();
        }

        radioGroup1= (RadioGroup)findViewById(R.id.rgGamTransporteVertical);
        radioGroup2= (RadioGroup)findViewById(R.id.rgGamTransporteConstrangimentoPosicao);
        radioGroup3= (RadioGroup)findViewById(R.id.rgGamTransporteAderenciaCarga);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(verificaCampos(view)) {

                    calcularResultados(view);
                    Intent intent = new Intent(SistemaMacTransporte2Activity.this, SistemaMacTransporte3Activity.class);
                    intent.putExtra("resultados",resultados);
                    startActivityForResult(intent, 1);
                }
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                Intent returnIntent = new Intent();
                setResult(SistemaMacTransporteActivity.RESULT_OK, returnIntent);
                finish();
            }
        }
    }

    private void calcularResultados(View view) {
        RadioButton radioButton1 = (RadioButton) findViewById(R.id.rbGamTransporteVertical1);
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.rbGamTransporteVertical2);
        RadioButton radioButton3 = (RadioButton) findViewById(R.id.rbGamTransporteVertical3);

        if (radioButton1.isChecked()) {
            resultados[2]=new Resultado(getString(R.string.GamElevacaoVerticalTitulo),"Green");
        }
        if (radioButton2.isChecked()) {

            resultados[2]=new Resultado(getString(R.string.GamElevacaoVerticalTitulo),"Ambar");
        }
        if (radioButton3.isChecked()) {
            resultados[2]=new Resultado(getString(R.string.GamElevacaoVerticalTitulo),"Red");
        }


        RadioButton radioButton4 = (RadioButton) findViewById(R.id.rbGamTransporteConstrangimentoPosicao1);
        RadioButton radioButton5 = (RadioButton) findViewById(R.id.rbGamTransporteConstrangimentoPosicao2);
        RadioButton radioButton6 = (RadioButton) findViewById(R.id.rbGamTransporteConstrangimentoPosicao3);

        if (radioButton4.isChecked()) {
            resultados[4]=new Resultado(getString(R.string.GamElevacaoConstrangimentTitulo),"Green");
        }
        if (radioButton5.isChecked()) {

            resultados[4]=new Resultado(getString(R.string.GamElevacaoConstrangimentTitulo),"Ambar");
        }
        if (radioButton6.isChecked()) {
            resultados[4]=new Resultado(getString(R.string.GamElevacaoConstrangimentTitulo),"Red");
        }


        RadioButton radioButton7 = (RadioButton) findViewById(R.id.rbGamTransporteAderenciaCarga1);
        RadioButton radioButton8 = (RadioButton) findViewById(R.id.rbGamTransporteAderenciaCarga2);
        RadioButton radioButton9 = (RadioButton) findViewById(R.id.rbGamTransporteAderenciaCarga3);

        if(radioButton7.isChecked())
        {
            resultados[5]=new Resultado(getString(R.string.GamElevacaoAderenciaCargaTitulo),"Green");
        }
        if (radioButton8.isChecked()) {

            resultados[5]=new Resultado(getString(R.string.GamElevacaoAderenciaCargaTitulo),"Ambar");
        }
        if (radioButton9.isChecked()) {
            resultados[5]=new Resultado(getString(R.string.GamElevacaoAderenciaCargaTitulo),"Red");
        }


    }


    private boolean verificaCampos(View view)
    {
        if (radioGroup1.getCheckedRadioButtonId() < 0)
        {
            LinearLayout linearLayout = (LinearLayout)findViewById(R.id.layoutGamTransporteVertical);
            TextView linha = (TextView)linearLayout.getChildAt(0);
            linha.setTextColor(Color.RED);
            linha.setFocusable(true);
            linha.setFocusableInTouchMode(true);
            linha.requestFocus();

            return false;
        }

        if (radioGroup2.getCheckedRadioButtonId() <0)
        {
            LinearLayout linearLayout = (LinearLayout)findViewById(R.id.layoutGamTransporteConstrangimento);
            TextView linha = (TextView)linearLayout.getChildAt(0);
            linha.setTextColor(Color.RED);
            linha.setFocusable(true);
            linha.setFocusableInTouchMode(true);
            linha.requestFocus();

            return false;
        }

        if (radioGroup3.getCheckedRadioButtonId() <0)
        {
            LinearLayout linearLayout = (LinearLayout)findViewById(R.id.layoutGamTransporteAderencia);
            TextView linha = (TextView)linearLayout.getChildAt(0);
            linha.setTextColor(Color.RED);
            linha.setFocusable(true);
            linha.setFocusableInTouchMode(true);
            linha.requestFocus();

            return false;
        }

        return true;
    }


}
