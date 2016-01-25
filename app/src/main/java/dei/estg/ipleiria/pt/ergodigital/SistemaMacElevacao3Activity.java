package dei.estg.ipleiria.pt.ergodigital;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;



public class SistemaMacElevacao3Activity extends AppCompatActivity {

    int resultadoA;
    int resultadoB;
    int resultadoC;
    int resultadoD;
    int resultadoE;
    int resultadoF;
    int resultadoG;
    int resultadoH;
    RadioGroup radioGroup1;
    RadioGroup radioGroup2;
    RadioGroup radioGroup3;

    private GestureDetectorCompat gestureDetectorCompat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_mac_elevacao3);
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

        radioGroup1= (RadioGroup)findViewById(R.id.rgGamElevacaoAderenciaCarga);
        radioGroup2= (RadioGroup)findViewById(R.id.rgGamElevacaoSuperficiePavimento);
        radioGroup3= (RadioGroup)findViewById(R.id.rgGamElevacaoOutrosFactores);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(verificaCampos(view)) {

                    calcularResultados(view);

                    Toast.makeText(SistemaMacElevacao3Activity.this,"Resultado A:"+resultadoA+"\nResultado B:"+resultadoB+"\nResultado C:"+resultadoC+"\nResultado D:"+resultadoD+"\nResultado E:"+resultadoE+"\nResultado F:"+resultadoF+"\nResultado G:"+resultadoG+"\nResultado H:"+resultadoH,Toast.LENGTH_LONG).show();


                    Toast.makeText(SistemaMacElevacao3Activity.this,"ResultadoC: "+resultadoC+"\nResultadoD: "+resultadoD+"\nResultadoE: "+resultadoE,Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), SistemaMacElevacaoResultActivity.class);
                    intent.putExtra("resultadoA",resultadoA);
                    intent.putExtra("resultadoB",resultadoB);
                    intent.putExtra("resultadoC",resultadoC);
                    intent.putExtra("resultadoD", resultadoD);
                    intent.putExtra("resultadoE", resultadoE);
                    intent.putExtra("resultadoF", resultadoF);
                    intent.putExtra("resultadoG", resultadoG);
                    intent.putExtra("resultadoH", resultadoH);


                    startActivity(intent);

                }
            }
        });




        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }



    private void calcularResultados(View view) {
        RadioButton radioButton1 = (RadioButton)findViewById(R.id.rbGamElevacaoAderenciaCarga1);
        RadioButton radioButton2 = (RadioButton)findViewById(R.id.rbGamElevacaoAderenciaCarga2);
        RadioButton radioButton3 = (RadioButton)findViewById(R.id.rbGamElevacaoAderenciaCarga3);

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

        RadioButton radioButton4 = (RadioButton)findViewById(R.id.rbGamElevacaoSuperficiePavimento1);
        RadioButton radioButton5 = (RadioButton)findViewById(R.id.rbGamElevacaoSuperficiePavimento2);
        RadioButton radioButton6 = (RadioButton)findViewById(R.id.rbGamElevacaoSuperficiePavimento3);

        if(radioButton4.isChecked())
        {
            resultadoG=0;
        }else {
            if (radioButton5.isChecked()) {

                resultadoG=1;
            } else {
                if (radioButton6.isChecked()) {
                    resultadoG=2;
                }
            }
        }
        RadioButton radioButton7 = (RadioButton)findViewById(R.id.rbGamElevacaoOutrosFactoresOpcao1);
        RadioButton radioButton8 = (RadioButton)findViewById(R.id.rbGamElevacaoOutrosFactoresOpcao2);

        if(radioButton7.isChecked())
        {
            resultadoH=1;
        }else {
            if (radioButton8.isChecked()) {

                resultadoH=2;
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

        return true;
    }



}
