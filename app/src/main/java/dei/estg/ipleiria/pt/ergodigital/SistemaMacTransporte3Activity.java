package dei.estg.ipleiria.pt.ergodigital;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import dei.estg.ipleiria.pt.ergodigital.Model.Consulta;
import dei.estg.ipleiria.pt.ergodigital.Model.GestaoUtentes;
import dei.estg.ipleiria.pt.ergodigital.Model.Resultado;

public class SistemaMacTransporte3Activity extends AppCompatActivity {

    Consulta consulta;
    Resultado[] resultados;
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

        if (getIntent().hasExtra("resultados")) {
            Bundle extras = getIntent().getExtras();
            resultados = (Resultado[])extras.getSerializable("resultados");
        }else
        {
            Toast.makeText(SistemaMacTransporte3Activity.this,"Missing resultados",Toast.LENGTH_LONG).show();
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

                    calcularResultados();
                    SharedPreferences mPrefs = getSharedPreferences("dados", 0);
                    int idConsulta = mPrefs.getInt("idConsulta", -1);

                    if (idConsulta>0){
                        consulta = GestaoUtentes.getInstance().getConsulta(idConsulta);

                        for (int c=0;c<resultados.length;c++){
                            if(resultados[c]!=null) {
                                Resultado resultado = new Resultado((resultados[c].getTitulo()), (resultados[c].getValor()));
                                consulta.addResultado(resultado);
                            }
                        }

                        if(consulta.getPessoa()!=null) {
                            consulta.getPessoa().addConsulta(consulta);
                        }
                        consulta.setFerramenta("MAC");
                    }



                    Intent intent = new Intent(getApplicationContext(), SistemaMacElevacaoResultActivity.class);
                    intent.putExtra("resultados",resultados);
                    startActivity(intent);

                    Intent returnIntent = new Intent();
                    setResult(SistemaMacElevacao2Activity.RESULT_OK, returnIntent);
                    finish();

                }
            }
        });




        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }



    private void calcularResultados() {
        RadioButton radioButton1 = (RadioButton) findViewById(R.id.rbGamTransporteSuperficiePavimento1);
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.rbGamTransporteSuperficiePavimento2);
        RadioButton radioButton3 = (RadioButton) findViewById(R.id.rbGamTransporteSuperficiePavimento3);

        if (radioButton1.isChecked()) {
            resultados[6] = new Resultado(getString(R.string.GamElevacaoSuperficiePavimentoTitulo),"Green");
        }
        if (radioButton2.isChecked()) {

            resultados[6] = new Resultado(getString(R.string.GamElevacaoSuperficiePavimentoTitulo),"Ambar");
            ;
        }
        if (radioButton3.isChecked()) {
            resultados[6] = new Resultado(getString(R.string.GamElevacaoSuperficiePavimentoTitulo),"Red");
        }


        RadioButton radioButton4 = (RadioButton) findViewById(R.id.rbGamTransporteOutrosFactoresOpcao0);
        RadioButton radioButton5 = (RadioButton) findViewById(R.id.rbGamTransporteOutrosFactoresOpcao1);
        RadioButton radioButton6 = (RadioButton) findViewById(R.id.rbGamTransporteOutrosFactoresOpcao2);

        if (radioButton4.isChecked()) {
            resultados[7] = new Resultado(getString(R.string.GamElevacaoOutrosFactoresTitulo), "Green");
        }
        if (radioButton5.isChecked()) {

            resultados[7] = new Resultado(getString(R.string.GamElevacaoOutrosFactoresTitulo), "Ambar");
        }
        if (radioButton6.isChecked()) {

            resultados[7] = new Resultado(getString(R.string.GamElevacaoOutrosFactoresTitulo), "Red");
        }


        RadioButton radioButton7 = (RadioButton) findViewById(R.id.rbGamTransporteDistancia1);
        RadioButton radioButton8 = (RadioButton) findViewById(R.id.rbGamTransporteDistancia2);
        RadioButton radioButton9 = (RadioButton) findViewById(R.id.rbGamTransporteDistancia3);

        if (radioButton7.isChecked()) {
            resultados[8] = new Resultado(getString(R.string.GamTransporteDistanciaTitulo), "Green");
        }
        if (radioButton8.isChecked()) {

            resultados[8] = new Resultado(getString(R.string.GamTransporteDistanciaTitulo), "Ambar");
        }
        if (radioButton9.isChecked()) {
            resultados[8] = new Resultado(getString(R.string.GamTransporteDistanciaTitulo), "Red");
        }


        RadioButton radioButton10 = (RadioButton) findViewById(R.id.rbGamTransporteObstaculos1);
        RadioButton radioButton11 = (RadioButton) findViewById(R.id.rbGamTransporteObstaculos2);
        RadioButton radioButton12 = (RadioButton) findViewById(R.id.rbGamTransporteObstaculos3);
        RadioButton radioButton13 = (RadioButton) findViewById(R.id.rbGamTransporteObstaculos4);

        if (radioButton10.isChecked()) {
            resultados[9] = new Resultado(getString(R.string.GamTransporteObstaculosTitulo), "Green");
        }
        if (radioButton11.isChecked()) {
            resultados[9] = new Resultado(getString(R.string.GamTransporteObstaculosTitulo), "Ambar");
        }
        if (radioButton12.isChecked()) {
            resultados[9] = new Resultado(getString(R.string.GamTransporteObstaculosTitulo), "Red");
        }
        if (radioButton13.isChecked()) {
            resultados[9] = new Resultado(getString(R.string.GamTransporteObstaculosTitulo), "Purple");
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
