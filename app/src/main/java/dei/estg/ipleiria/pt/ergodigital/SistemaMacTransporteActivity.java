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
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class SistemaMacTransporteActivity extends AppCompatActivity {

    Integer resultadoA;
    Integer resultadoB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_mac_transporte);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (verificaCampos(view)) {

                    calcularResultados(view);
                    Toast.makeText(SistemaMacTransporteActivity.this, "Resultado A: " + resultadoA + "\nResultado B: " + resultadoB, Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(SistemaMacTransporteActivity.this, SistemaMacTransporte2Activity.class);
                    intent.putExtra("resultadoA", resultadoA);
                    intent.putExtra("resultadoB", resultadoB);
                    startActivity(intent);
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
            case 0: resultadoA=0; break;
            case 1: resultadoA=4; break;
            case 2: resultadoA=6; break;
            case 3: resultadoA=10; break;
        }
        RadioButton radioButton1 = (RadioButton) findViewById(R.id.rbGamTransporteDistanciaMaos1);
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.rbGamTransporteDistanciaMaos2);
        RadioButton radioButton3 = (RadioButton) findViewById(R.id.rbGamTransporteDistanciaMaos3);
        RadioButton radioButton4 = (RadioButton) findViewById(R.id.rbGamTransporteDistanciaMaos4);

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
