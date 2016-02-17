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

import dei.estg.ipleiria.pt.ergodigital.Model.Consulta;
import dei.estg.ipleiria.pt.ergodigital.Model.Resultado;

public class SistemaMacEquipa2Activity extends AppCompatActivity {

    Resultado[] resultados;
    Consulta consulta;
    RadioGroup radioGroup1;
    RadioGroup radioGroup2;
    RadioGroup radioGroup3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_mac_equipa2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        if (getIntent().hasExtra("resultados")) {
            Bundle extras = getIntent().getExtras();
            resultados = (Resultado[])extras.getSerializable("resultados");
        }else
        {
            Toast.makeText(SistemaMacEquipa2Activity.this, "Missing resultados", Toast.LENGTH_LONG).show();
        }

        radioGroup1= (RadioGroup)findViewById(R.id.rgGamEquipaVertical);
        radioGroup2= (RadioGroup)findViewById(R.id.rgGamEquipaTorcaoTronco);
        radioGroup3= (RadioGroup)findViewById(R.id.rgGamEquipaConstrangimentoPosicao);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(verificaCampos(view)) {
                    calcularResultados();
                    Intent intent = new Intent(SistemaMacEquipa2Activity.this, SistemaMacEquipa3Activity.class);
                    intent.putExtra("resultados",resultados);
                    startActivityForResult(intent,1);
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
                setResult(SistemaMacEquipaActivity.RESULT_OK, returnIntent);
                finish();
            }
        }
    }

    private void calcularResultados() {
        RadioButton radioButton1 = (RadioButton) findViewById(R.id.rbGamEquipaVertical1);
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.rbGamEquipaVertical2);
        RadioButton radioButton3 = (RadioButton) findViewById(R.id.rbGamEquipaVertical3);

        if (radioButton1.isChecked()) {
            resultados[2]=new Resultado(getString(R.string.GamElevacaoVerticalTitulo),"Green");
        }
        if (radioButton2.isChecked()) {

            resultados[2]=new Resultado(getString(R.string.GamElevacaoVerticalTitulo),"Ambar");
        }
        if (radioButton3.isChecked()) {
            resultados[2]=new Resultado(getString(R.string.GamElevacaoVerticalTitulo),"Red");
        }


        RadioButton radioButton4 = (RadioButton) findViewById(R.id.rbGamEquipaTorcaoTronco1);
        RadioButton radioButton5 = (RadioButton) findViewById(R.id.rbGamEquipaTorcaoTronco2);
        RadioButton radioButton6 = (RadioButton) findViewById(R.id.rbGamEquipaTorcaoTronco3);

        if (radioButton4.isChecked()) {
            resultados[3]=new Resultado(getString(R.string.GamElevacaoTorcaoTroncoTitulo),"Green");
        }
        if (radioButton5.isChecked()) {

            resultados[3]=new Resultado(getString(R.string.GamElevacaoTorcaoTroncoTitulo),"Ambar");
        }
        if (radioButton6.isChecked()) {
            resultados[3]=new Resultado(getString(R.string.GamElevacaoTorcaoTroncoTitulo),"Red");
        }


        RadioButton radioButton7 = (RadioButton) findViewById(R.id.rbGamEquipaConstrangimentoPosicao1);
        RadioButton radioButton8 = (RadioButton) findViewById(R.id.rbGamEquipaConstrangimentoPosicao2);
        RadioButton radioButton9 = (RadioButton) findViewById(R.id.rbGamEquipaConstrangimentoPosicao3);

        if (radioButton7.isChecked()) {
            resultados[4]=new Resultado(getString(R.string.GamElevacaoConstrangimentTitulo),"Green");
        }
        if (radioButton8.isChecked()) {

            resultados[4]=new Resultado(getString(R.string.GamElevacaoConstrangimentTitulo),"Ambar");
        }
        if (radioButton9.isChecked()) {
            resultados[4]=new Resultado(getString(R.string.GamElevacaoConstrangimentTitulo),"Red");
        }


    }


    private boolean verificaCampos(View view)
    {
        if (radioGroup1.getCheckedRadioButtonId() < 0)
        {

            LinearLayout linearLayout = (LinearLayout)findViewById(R.id.layoutGamEquipaVertical);
            TextView linha = (TextView)linearLayout.getChildAt(0);
            linha.setTextColor(Color.RED);
            linha.setFocusable(true);
            linha.setFocusableInTouchMode(true);
            linha.requestFocus();

            return false;
        }

        if (radioGroup2.getCheckedRadioButtonId() <0)
        {
            LinearLayout linearLayout = (LinearLayout)findViewById(R.id.layoutGamEquipaTorcaoTronco);
            TextView linha = (TextView)linearLayout.getChildAt(0);
            linha.setTextColor(Color.RED);
            linha.setFocusable(true);
            linha.setFocusableInTouchMode(true);
            linha.requestFocus();

            return false;
        }

        if (radioGroup3.getCheckedRadioButtonId() <0)
        {
            LinearLayout linearLayout = (LinearLayout)findViewById(R.id.linearGamEquipaConstrangimento);
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
