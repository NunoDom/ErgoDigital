package dei.estg.ipleiria.pt.ergodigital;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SistemaMacTransporte2Activity extends AppCompatActivity {

    int resultadoA;
    int resultadoB;
    int resultadoC;
    int resultadoD;
    int resultadoE;



    RadioGroup radioGroup1;
    RadioGroup radioGroup2;
    RadioGroup radioGroup3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_mac_transporte2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getIntent().hasExtra("resultadoA")) {
            Bundle extras = getIntent().getExtras();
            resultadoA = extras.getInt("resultadoA");
            resultadoB = extras.getInt("resultadoB");
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

                    Toast.makeText(SistemaMacTransporte2Activity.this, "ResultadoC: " + resultadoC + "\nResultadoD: " + resultadoD + "\nResultadoE: " + resultadoE, Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SistemaMacTransporte2Activity.this, SistemaMacTransporte3Activity.class);
                    intent.putExtra("resultadoA",resultadoA);
                    intent.putExtra("resultadoB",resultadoB);
                    intent.putExtra("resultadoC",resultadoC);
                    intent.putExtra("resultadoD",resultadoD);
                    intent.putExtra("resultadoE",resultadoE);

                    startActivity(intent);
                }
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



    private void calcularResultados(View view) {
        RadioButton radioButton1 = (RadioButton) findViewById(R.id.rbGamTransporteVertical1);
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.rbGamTransporteVertical2);
        RadioButton radioButton3 = (RadioButton) findViewById(R.id.rbGamTransporteVertical3);

        if (radioButton1.isChecked()) {
            resultadoC = 0;
        }
        if (radioButton2.isChecked()) {

            resultadoC = 1;
        }
        if (radioButton3.isChecked()) {
            resultadoC = 3;
        }


        RadioButton radioButton4 = (RadioButton) findViewById(R.id.rbGamTransporteConstrangimentoPosicao1);
        RadioButton radioButton5 = (RadioButton) findViewById(R.id.rbGamTransporteConstrangimentoPosicao2);
        RadioButton radioButton6 = (RadioButton) findViewById(R.id.rbGamTransporteConstrangimentoPosicao3);

        if (radioButton4.isChecked()) {
            resultadoD = 0;
        }
        if (radioButton5.isChecked()) {

            resultadoD = 1;
        }
        if (radioButton6.isChecked()) {
            resultadoD = 2;
        }


        RadioButton radioButton7 = (RadioButton) findViewById(R.id.rbGamTransporteAderenciaCarga1);
        RadioButton radioButton8 = (RadioButton) findViewById(R.id.rbGamTransporteAderenciaCarga2);
        RadioButton radioButton9 = (RadioButton) findViewById(R.id.rbGamTransporteAderenciaCarga3);

        if (radioButton7.isChecked()) {
            resultadoE = 0;
        }
        if (radioButton8.isChecked()) {

            resultadoE = 1;
        }
        if (radioButton9.isChecked()) {
            resultadoE = 3;
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
