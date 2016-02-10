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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import dei.estg.ipleiria.pt.ergodigital.Model.Consulta;
import dei.estg.ipleiria.pt.ergodigital.Model.GestaoUtentes;
import dei.estg.ipleiria.pt.ergodigital.Model.Resultado;

public class SistemaMacEquipa3Activity extends AppCompatActivity {

    Consulta consulta;
    Resultado[] resultados;
    RadioGroup radioGroup1;
    RadioGroup radioGroup2;
    RadioGroup radioGroup3;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_mac_equipa3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getIntent().hasExtra("resultados")) {
            Bundle extras = getIntent().getExtras();
            resultados = (Resultado[])extras.getSerializable("resultados");
        }else
        {
            Toast.makeText(SistemaMacEquipa3Activity.this, "Missing resultados", Toast.LENGTH_LONG).show();
            finish();
        }

        radioGroup1= (RadioGroup)findViewById(R.id.rgGamEquipaAderenciaCarga);
        radioGroup2= (RadioGroup)findViewById(R.id.rgGamEquipaSuperficiePavimento);
        radioGroup3= (RadioGroup)findViewById(R.id.rgGamEquipaOutrosFactores);
        spinner = (Spinner)findViewById(R.id.cbKimEquipaComunicacao);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(verificaCampos(view)) {

                    calcularResultados(view);

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
                    setResult(SistemaMacEquipa2Activity.RESULT_OK, returnIntent);
                    finish();


                }
            }
        });




        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }



    private void calcularResultados(View view) {
        RadioButton radioButton1 = (RadioButton)findViewById(R.id.rbGamEquipaAderenciaCarga1);
        RadioButton radioButton2 = (RadioButton)findViewById(R.id.rbGamEquipaAderenciaCarga2);
        RadioButton radioButton3 = (RadioButton)findViewById(R.id.rbGamEquipaAderenciaCarga3);

        if(radioButton1.isChecked())
        {
            resultados[5]=new Resultado(getString(R.string.GamElevacaoAderenciaCargaTitulo),"Green");
        }
        if (radioButton2.isChecked()) {

            resultados[5]=new Resultado(getString(R.string.GamElevacaoAderenciaCargaTitulo),"Ambar");
        }
        if (radioButton3.isChecked()) {
            resultados[5]=new Resultado(getString(R.string.GamElevacaoAderenciaCargaTitulo),"Red");
        }



        RadioButton radioButton4 = (RadioButton)findViewById(R.id.rbGamEquipaSuperficiePavimento1);
        RadioButton radioButton5 = (RadioButton)findViewById(R.id.rbGamEquipaSuperficiePavimento2);
        RadioButton radioButton6 = (RadioButton)findViewById(R.id.rbGamEquipaSuperficiePavimento3);

        if(radioButton4.isChecked())
        {
            resultados[6]=new Resultado(getString(R.string.GamElevacaoAderenciaCargaTitulo),"Green");
        }
        if (radioButton5.isChecked()) {

            resultados[6]=new Resultado(getString(R.string.GamElevacaoAderenciaCargaTitulo),"Ambar");
        }
        if (radioButton6.isChecked()) {
            resultados[6] = new Resultado(getString(R.string.GamElevacaoAderenciaCargaTitulo), "Red");


        }
        RadioButton radioButton7 = (RadioButton)findViewById(R.id.rbGamEquipaOutrosFactoresOpcao0);
        RadioButton radioButton8 = (RadioButton)findViewById(R.id.rbGamEquipaOutrosFactoresOpcao1);
        RadioButton radioButton9 = (RadioButton)findViewById(R.id.rbGamEquipaOutrosFactoresOpcao2);

        if(radioButton7.isChecked())
        {
            resultados[7] = new Resultado(getString(R.string.GamElevacaoOutrosFactoresTitulo), "Green");
        }
        if (radioButton8.isChecked()) {

            resultados[7] = new Resultado(getString(R.string.GamElevacaoOutrosFactoresTitulo), "Ambar");
        }
        if (radioButton9.isChecked()) {

            resultados[7] = new Resultado(getString(R.string.GamElevacaoOutrosFactoresTitulo), "Red");
        }

        switch (spinner.getSelectedItemPosition())
        {
            case 0:  resultados[10] = new Resultado(getString(R.string.GamEquipaComunicacaoTitulo), "Green"); break;
            case 1:  resultados[10] = new Resultado(getString(R.string.GamEquipaComunicacaoTitulo), "Ambar"); break;
            case 2:  resultados[10] = new Resultado(getString(R.string.GamEquipaComunicacaoTitulo), "Red"); break;
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
