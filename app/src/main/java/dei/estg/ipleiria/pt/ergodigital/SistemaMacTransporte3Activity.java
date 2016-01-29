package dei.estg.ipleiria.pt.ergodigital;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SistemaMacTransporte3Activity extends AppCompatActivity {

    int resultadoA;
    int resultadoB;
    int resultadoC;
    int resultadoD;
    int resultadoE;
    int resultadoF;
    int resultadoG;
    int resultadoH;
    int resultadoI;
    RadioGroup radioGroup1;
    RadioGroup radioGroup2;
    RadioGroup radioGroup3;
    RadioGroup radioGroup4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_mac_transporte3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getIntent().hasExtra("resultadoA")) {
            Bundle extras = getIntent().getExtras();
            resultadoA = extras.getInt("resultadoA");
            resultadoB = extras.getInt("resultadoB");
            resultadoC = extras.getInt("resultadoC");
            resultadoD = extras.getInt("resultadoD");
            resultadoE = extras.getInt("resultadoE");
        }

        radioGroup1= (RadioGroup)findViewById(R.id.rgGamTransporteSuperficiePavimento);
        radioGroup2= (RadioGroup)findViewById(R.id.rgFactoresRisco);
        radioGroup3= (RadioGroup)findViewById(R.id.rgGamTransporteDistancia);
        radioGroup4= (RadioGroup)findViewById(R.id.rgGamTransporteObstaculos);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(verificaCampos(view)) {

                    calcularResultados(view);

                    Toast.makeText(SistemaMacTransporte3Activity.this, "Resultado A:" + resultadoA + "\nResultado B:" + resultadoB + "\nResultado C:" + resultadoC + "\nResultado D:" + resultadoD + "\nResultado E:" + resultadoE + "\nResultado F:" + resultadoF + "\nResultado G:" + resultadoG + "\nResultado H:" + resultadoH+ "\nResultado I:" + resultadoI, Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(getApplicationContext(), SistemaMacElevacaoResultActivity.class);
                    intent.putExtra("resultadoA",resultadoA);
                    intent.putExtra("resultadoB",resultadoB);
                    intent.putExtra("resultadoC",resultadoC);
                    intent.putExtra("resultadoD", resultadoD);
                    intent.putExtra("resultadoE", resultadoE);
                    intent.putExtra("resultadoF", resultadoF);
                    intent.putExtra("resultadoG", resultadoG);
                    intent.putExtra("resultadoH", resultadoH);
                    intent.putExtra("resultadoI", resultadoI);

                    startActivity(intent);

                }
            }
        });




        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }



    private void calcularResultados(View view) {
        RadioButton radioButton1 = (RadioButton)findViewById(R.id.rbGamTransporteSuperficiePavimento1);
        RadioButton radioButton2 = (RadioButton)findViewById(R.id.rbGamTransporteSuperficiePavimento2);
        RadioButton radioButton3 = (RadioButton)findViewById(R.id.rbGamTransporteSuperficiePavimento3);

        if(radioButton1.isChecked())
        {
            resultadoF=0;
        }else {
            if (radioButton2.isChecked()) {

                resultadoF=1;
            } else {
                if (radioButton3.isChecked()) {
                    resultadoF=2;
                }
            }
        }

        RadioButton radioButton4 = (RadioButton)findViewById(R.id.rbGamTransporteOutrosFactoresOpcao1);
        RadioButton radioButton5 = (RadioButton)findViewById(R.id.rbGamTransporteOutrosFactoresOpcao2);

        if(radioButton4.isChecked())
        {
            resultadoH=1;
        }else {
            if (radioButton5.isChecked()) {

                resultadoH=2;
            }
        }





        RadioButton radioButton6 = (RadioButton)findViewById(R.id.rbGamTransporteDistancia1);
        RadioButton radioButton7 = (RadioButton)findViewById(R.id.rbGamTransporteDistancia2);
        RadioButton radioButton8 = (RadioButton)findViewById(R.id.rbGamTransporteDistancia3);

        if(radioButton6.isChecked())
        {
            resultadoG=0;
        }else {
            if (radioButton7.isChecked()) {

                resultadoG=1;
            } else {
                if (radioButton8.isChecked()) {
                    resultadoG=2;
                }
            }
        }

        RadioButton radioButton9 = (RadioButton)findViewById(R.id.rbGamTransporteObstaculos1);
        RadioButton radioButton10 = (RadioButton)findViewById(R.id.rbGamTransporteObstaculos2);
        RadioButton radioButton11= (RadioButton)findViewById(R.id.rbGamTransporteObstaculos3);
        RadioButton radioButton12 = (RadioButton)findViewById(R.id.rbGamTransporteObstaculos4);

        if(radioButton9.isChecked())
        {
            resultadoG=0;
        }else {
            if (radioButton10.isChecked()) {

                resultadoG=2;
            } else {
                if (radioButton11.isChecked()) {
                    resultadoG=2;
                }else{
                    if(radioButton12.isChecked())
                    {
                        resultadoG=4;
                    }
                }
            }
        }



    }


    private boolean verificaCampos(View view)
    {
        if (radioGroup1.getCheckedRadioButtonId() < 0)
        {
            TextView radioGroupText=(TextView)radioGroup1.getChildAt(0);
            radioGroupText.setTextColor(Color.RED);
            radioGroup1.setFocusable(true);
            radioGroup1.setFocusableInTouchMode(true);
            radioGroup1.requestFocus();

            return false;
        }

        if (radioGroup2.getCheckedRadioButtonId() <0)
        {
            TextView radioGroupText=(TextView)radioGroup2.getChildAt(0);
            radioGroupText.setTextColor(Color.RED);
            radioGroup2.setFocusable(true);
            radioGroup2.setFocusableInTouchMode(true);
            radioGroup2.requestFocus();

            return false;
        }

        if (radioGroup3.getCheckedRadioButtonId() <0)
        {
            TextView radioGroupText=(TextView)radioGroup3.getChildAt(0);
            radioGroupText.setTextColor(Color.RED);
            radioGroup3.setFocusable(true);
            radioGroup3.setFocusableInTouchMode(true);
            radioGroup3.requestFocus();

            return false;
        }

        if (radioGroup4.getCheckedRadioButtonId() <0)
        {
            TextView radioGroupText=(TextView)radioGroup4.getChildAt(0);
            radioGroupText.setTextColor(Color.RED);
            radioGroup4.setFocusable(true);
            radioGroup4.setFocusableInTouchMode(true);
            radioGroup4.requestFocus();

            return false;
        }

        return true;
    }



}
