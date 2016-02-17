package dei.estg.ipleiria.pt.ergodigital;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import dei.estg.ipleiria.pt.ergodigital.Model.Consulta;
import dei.estg.ipleiria.pt.ergodigital.Model.Resultado;

public class SistemaMacEquipaActivity extends AppCompatActivity {


    Spinner spinner1;
    Spinner spinner2;
    Resultado[] resultados;
    Consulta consulta;
    RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_mac_equipa);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        resultados = new Resultado[11];

        spinner1= (Spinner)findViewById(R.id.cbGamEquipaPontuacaoFrequenciaPesoNumeroPessoas);
        spinner2= (Spinner)findViewById(R.id.cbGamEquipaPontuacaoFrequenciaPesoPesoCarga);
        radioGroup  =(RadioGroup)findViewById(R.id.rgGamEquipaDistanciaMaos);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ArrayAdapter<CharSequence> adapter = null;
                switch (position) {
                    case 0:
                        adapter = ArrayAdapter.createFromResource(SistemaMacEquipaActivity.this, R.array.GamEquipaPontuacaoFrequenciaPesoEscalaPeso2Pessoas, android.R.layout.simple_spinner_dropdown_item);
                        break;
                    case 1:
                        adapter = ArrayAdapter.createFromResource(SistemaMacEquipaActivity.this, R.array.GamEquipaPontuacaoFrequenciaPesoEscalaPeso3Pessoas, android.R.layout.simple_spinner_dropdown_item);
                        break;
                    case 2:
                        adapter = ArrayAdapter.createFromResource(SistemaMacEquipaActivity.this, R.array.GamEquipaPontuacaoFrequenciaPesoEscalaPeso4Pessoas, android.R.layout.simple_spinner_dropdown_item);
                        break;
                }
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner2.setAdapter(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (verificarCampos(view)) {
                    calcularResultados();
                    Intent intent = new Intent(SistemaMacEquipaActivity.this, SistemaMacEquipa2Activity.class);
                    intent.putExtra("resultados", resultados);
                    startActivityForResult(intent, 1);
                }
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



    private boolean verificarCampos(View view) {
        if (radioGroup.getCheckedRadioButtonId() != -1)
        {
            return true;
        }
        else
        {
            TextView linha = (TextView)findViewById(R.id.txtViewGamEquipaDistanciaMaosTitulo);
            linha.setTextColor(Color.RED);
            linha.setFocusable(true);
            linha.setFocusableInTouchMode(true);
            linha.requestFocus();

            return false;
        }
    }

    private void calcularResultados() {

        if(spinner1.getSelectedItemPosition()==0) //2 pax
        {
            if(spinner2.getSelectedItemPosition()==0)
            {
                resultados[0]=new Resultado(getString(R.string.GamElevacaoFrequenciaPesoCargaTitulo),"Green");
            }
            if(spinner2.getSelectedItemPosition()==1)
            {
                resultados[0]=new Resultado(getString(R.string.GamElevacaoFrequenciaPesoCargaTitulo),"Ambar");
            }
            if(spinner2.getSelectedItemPosition()==2)
            {
                resultados[0]=new Resultado(getString(R.string.GamElevacaoFrequenciaPesoCargaTitulo),"Red");
            }
            if(spinner2.getSelectedItemPosition()==3)
            {
                resultados[0]=new Resultado(getString(R.string.GamElevacaoFrequenciaPesoCargaTitulo),"Purple");
            }

        }
        if(spinner1.getSelectedItemPosition()==1)//3pax
        {
            if(spinner2.getSelectedItemPosition()==0)
            {
                resultados[0]=new Resultado(getString(R.string.GamElevacaoFrequenciaPesoCargaTitulo),"Green");
            }
            if(spinner2.getSelectedItemPosition()==1)
            {
                resultados[0]=new Resultado(getString(R.string.GamElevacaoFrequenciaPesoCargaTitulo),"Ambar");
            }
            if(spinner2.getSelectedItemPosition()==2)
            {
                resultados[0]=new Resultado(getString(R.string.GamElevacaoFrequenciaPesoCargaTitulo),"Red");
            }
            if(spinner2.getSelectedItemPosition()==3)
            {
                resultados[0]=new Resultado(getString(R.string.GamElevacaoFrequenciaPesoCargaTitulo),"Purple");
            }

        }
        if(spinner1.getSelectedItemPosition()==2)//4pax
        {
            if(spinner2.getSelectedItemPosition()==0)
            {
                resultados[0]=new Resultado(getString(R.string.GamElevacaoFrequenciaPesoCargaTitulo),"Ambar");
            }
            if(spinner2.getSelectedItemPosition()==1)
            {
                resultados[0]=new Resultado(getString(R.string.GamElevacaoFrequenciaPesoCargaTitulo),"Red");
            }
            if(spinner2.getSelectedItemPosition()==2)
            {
                resultados[0]=new Resultado(getString(R.string.GamElevacaoFrequenciaPesoCargaTitulo),"Purple");
            }
        }


        RadioButton radioButton1 = (RadioButton) findViewById(R.id.rbGamEquipaDistanciaMaos1);
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.rbGamEquipaDistanciaMaos2);
        RadioButton radioButton3 = (RadioButton) findViewById(R.id.rbGamEquipaDistanciaMaos3);
        RadioButton radioButton4 = (RadioButton) findViewById(R.id.rbGamEquipaDistanciaMaos4);

        if (radioButton1.isChecked()) {
            resultados[1]=new Resultado(getString(R.string.GamElevacaoDistanciaMaosTitulo),"Green");
        }
        if (radioButton2.isChecked()) {
            resultados[1]=new Resultado(getString(R.string.GamElevacaoDistanciaMaosTitulo),"Ambar");
        }
        if (radioButton3.isChecked()) {
            resultados[1]=new Resultado(getString(R.string.GamElevacaoDistanciaMaosTitulo),"Red");
        }
        if (radioButton4.isChecked()) {
            resultados[1]=new Resultado(getString(R.string.GamElevacaoDistanciaMaosTitulo),"Purple");
        }








    }

}
