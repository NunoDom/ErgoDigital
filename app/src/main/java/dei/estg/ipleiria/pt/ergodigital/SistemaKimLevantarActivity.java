package dei.estg.ipleiria.pt.ergodigital;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import dei.estg.ipleiria.pt.ergodigital.Model.Consulta;
import dei.estg.ipleiria.pt.ergodigital.Model.GestaoUtentes;
import dei.estg.ipleiria.pt.ergodigital.Model.Pessoa;
import dei.estg.ipleiria.pt.ergodigital.Model.Resultado;

public class SistemaKimLevantarActivity extends AppCompatActivity {
    String condicaoTrabalho;
    Spinner spinner1;
    Spinner spinner2;
    Spinner spinner3;
    Spinner spinner4;
    Spinner spinner5;
    TextView textview1;
    TextView textview2;
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;
    RadioGroup rgKimLevantarCondicoesTrabalho;
    Consulta consulta;
    int genero=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_kim_levantar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        rgKimLevantarCondicoesTrabalho =(RadioGroup) findViewById(R.id.rgKimLevantarCondicoesTrabalho);
        spinner1 = (Spinner) findViewById(R.id.cbKimTipoDeTrabalho);
        spinner2 = (Spinner) findViewById(R.id.cbKimDuracaoRepeticao);
        spinner3 = (Spinner) findViewById(R.id.cbKimSexo);
        spinner4 = (Spinner) findViewById(R.id.cbKimLevantarPontucaoCarga);
        spinner5 = (Spinner) findViewById(R.id.cbKimPosiçãoCarga);
        textview1 = (TextView) findViewById(R.id.txtViewTempoActividade);
        textview2 = (TextView) findViewById(R.id.textviewDescricaoPosicaoTrabalho);

        radioButton1 = (RadioButton) findViewById(R.id.rbKimLevantarCondicoesTrabalho1);
        radioButton2 = (RadioButton) findViewById(R.id.rbKimLevantarCondicoesTrabalho2);
        radioButton3 = (RadioButton) findViewById(R.id.rbKimLevantarCondicoesTrabalho3);


        SharedPreferences mPrefs = getSharedPreferences("dados", 0);
        int idConsulta = mPrefs.getInt("idConsulta", -1);
        if (idConsulta>0){
            consulta = GestaoUtentes.getInstance().getConsulta(idConsulta);
            int idUtente= mPrefs.getInt("idUtente", -1);
            if(idUtente>0){
                Pessoa pessoa = GestaoUtentes.getInstance().getPessoa(idUtente);
                genero=pessoa.getGenero();
                //actualizaAdapterPontuacaoCarga(genero);
            }
        }else
        {
            Toast.makeText(getApplicationContext(), "ERRO 404: Consulta id not found", Toast.LENGTH_SHORT).show();
        }



        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                if (position > 0){
                    actualizaAdapterPontuacaoTempo(position);
                }else
                {
                    spinner2.setAdapter(null);
                }



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });


        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView textviewGenero = (TextView) findViewById(R.id.txtViewKimLevantarGenero);

                if (genero < 0) {
                    if (position > 0) {
                        actualizaAdapterPontuacaoCarga(position);
                    } else {
                        spinner4.setAdapter(null);
                    }
                }else
                {
                    spinner3.setSelection(genero);
                    textviewGenero.setVisibility(View.GONE);
                    spinner3.setVisibility(View.GONE);
                    actualizaAdapterPontuacaoCarga(genero);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            ImageView image = (ImageView)findViewById(R.id.iv_kim_levantar_carga);

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 1:
                        image.setImageResource(R.drawable.ic_kim_lbt_1);
                        textview2.setText(getString(R.string.KimDescricaoPosicaoTrabalho1));
                        break;
                    case 2:
                        image.setImageResource(R.drawable.ic_kim_lbt_2);
                        textview2.setText(getString(R.string.KimDescricaoPosicaoTrabalho2));
                        break;
                    case 3:
                        image.setImageResource(R.drawable.ic_kim_lbt_3);
                        textview2.setText(getString(R.string.KimDescricaoPosicaoTrabalho3));
                        break;
                    case 4:
                        image.setImageResource(R.drawable.ic_kim_lbt_4);
                        textview2.setText(getString(R.string.KimDescricaoPosicaoTrabalho3));
                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        rgKimLevantarCondicoesTrabalho.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId>0) {
                    TextView spinnerText = (TextView)findViewById(R.id.tvKimLevantarCondicoesTrabalho);
                    spinnerText.setTextColor(Color.BLACK);
                    spinnerText.setFocusable(false);
                    spinnerText.setFocusableInTouchMode(false);
                    spinnerText.clearFocus();
                }
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(verificarCampos()) {
                    click_analisar();
                }
            }
        });







        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    private void actualizaAdapterPontuacaoTempo(int position) {


        ArrayAdapter<CharSequence> adapter = null;

        switch (position) {
            case 1:
                adapter = ArrayAdapter.createFromResource(this, R.array.KimElevacaoDeslocacao, android.R.layout.simple_spinner_dropdown_item);
                textview1.setText(getString(R.string.KimElevacaoPontuacaoTempoLabel));
                break;
            case 2:
                adapter = ArrayAdapter.createFromResource(this, R.array.KimaElevacaoPega, android.R.layout.simple_spinner_dropdown_item);
                textview1.setText(getString(R.string.KimPegaPontuacaoTempoLabel));

                break;
            case 3:
                adapter = ArrayAdapter.createFromResource(this, R.array.KimElevacaoTransporte, android.R.layout.simple_spinner_dropdown_item);
                textview1.setText(getString(R.string.KimTransportePontuacaoTempoLabel));

                break;
        }
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner2.setAdapter(adapter);

    }

    private void actualizaAdapterPontuacaoCarga(int position) {


        ArrayAdapter<CharSequence> adapter = null;

        switch (position) {
            case 1:
                adapter = ArrayAdapter.createFromResource(this, R.array.KimElevacaoCargaHomens, android.R.layout.simple_spinner_dropdown_item);
                break;
            case 2:
                adapter = ArrayAdapter.createFromResource(this, R.array.KimElevacaoCargaMulheres, android.R.layout.simple_spinner_dropdown_item);
                break;

        }
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter);

    }


    private void click_analisar() {
        int pontuacaoCarga = 0;
        int pontuacaoPosicao = 0;
        int pontuacaoCondicosTrabalho = 0;
        int pontuacaoTempo = 0;
        int resultadoFinal=0;

        if(verificarCampos()) {


            switch (spinner2.getSelectedItemPosition()) {

                case 0:
                    pontuacaoTempo = 1;
                    break;
                case 1:
                    pontuacaoTempo = 2;
                    break;
                case 2:
                    pontuacaoTempo = 4;
                    break;
                case 3:
                    pontuacaoTempo = 6;
                    break;
                case 4:
                    pontuacaoTempo = 8;
                    break;
                case 5:
                    pontuacaoTempo = 10;
                    break;

            }

            switch (spinner4.getSelectedItemPosition()) {

                case 0:
                    pontuacaoCarga= 1;
                    break;
                case 1:
                    pontuacaoCarga= 2;
                    break;
                case 2:
                    pontuacaoCarga= 4;
                    break;
                case 3:
                    pontuacaoCarga= 7;
                    break;
                case 4:
                    pontuacaoCarga= 25;
                    break;

            }


            switch (spinner5.getSelectedItemPosition()) {

                case 1:
                    pontuacaoPosicao= 1;
                    break;
                case 2:
                    pontuacaoPosicao= 2;
                    break;
                case 3:
                    pontuacaoPosicao= 4;
                    break;
                case 4:
                    pontuacaoPosicao= 8;
                    break;

            }



        if(radioButton1.isChecked())
        {
            condicaoTrabalho=radioButton1.getText().toString();
            pontuacaoCondicosTrabalho=0;
        }
        if(radioButton2.isChecked())
        {
            condicaoTrabalho=radioButton2.getText().toString();
            pontuacaoCondicosTrabalho=1;
        }
        if(radioButton3.isChecked())
        {
            condicaoTrabalho=radioButton3.getText().toString();
            pontuacaoCondicosTrabalho=2;
        }
        }
resultadoFinal=(pontuacaoCarga+pontuacaoPosicao+pontuacaoCondicosTrabalho)*pontuacaoTempo;

        String mensagem="";
        if(resultadoFinal<10) {
            mensagem = getString(R.string.KimLevantarResultadoFinal1);

        }
            if(resultadoFinal>=10 && resultadoFinal<25)
            {
                mensagem=getString(R.string.KimLevantarResultadoFinal2);
            }
            if(resultadoFinal>=25 && resultadoFinal<50)
            {
                mensagem=getString(R.string.KimLevantarResultadoFinal3);
            }
            if(resultadoFinal>=50)
            {
                mensagem=getString(R.string.KimLevantarResultadoFinal4);
            }



        Resultado resultadoCarga = new Resultado("Carga: ",pontuacaoCarga+"- "+spinner4.getSelectedItem().toString());
        Resultado resultadoPosicao = new Resultado("Posição: ",pontuacaoPosicao+"- "+spinner5.getSelectedItem().toString());
        Resultado resultadoCondicosTrabalho = new Resultado("Condições de Trabalho: ",+pontuacaoCondicosTrabalho+"- "+condicaoTrabalho);
        Resultado resultadoPontuacaoTempo = new Resultado("Tempo: ",+pontuacaoTempo+"- "+spinner2.getSelectedItem().toString());
        Resultado resultadoTotal = new Resultado("Resultado da Avaliação ", resultadoFinal+"- "+mensagem);

        consulta.addResultado(resultadoCarga);
        consulta.addResultado(resultadoPosicao);
        consulta.addResultado(resultadoCondicosTrabalho);
        consulta.addResultado(resultadoPontuacaoTempo);
        consulta.addResultado(resultadoTotal);

        if(consulta.getPessoa()!=null) {
            consulta.getPessoa().addConsulta(consulta);
        }
        consulta.setFerramenta("KIM-LEVANTAR");
        Intent intent= new Intent(this,ActivityResultado.class);
        intent.putExtra("consulta", consulta);
        startActivity(intent);


        Intent returnIntent = new Intent();
        setResult(SistemaRebaActivity.RESULT_OK, returnIntent);
        finish();
    }


    private boolean verificarCampos() {
        if (spinner1.getSelectedItemPosition() == 0) {
            TextView spinnerText = (TextView)spinner1.getChildAt(0);
            spinnerText.setTextColor(Color.RED);
            spinner1.setFocusable(true);
            spinner1.setFocusableInTouchMode(true);
            spinner1.requestFocus();

            return false;
        }
        if (spinner3.getSelectedItemPosition() == 0) {

            TextView spinnerText = (TextView)spinner3.getChildAt(0);
            spinnerText.setTextColor(Color.RED);
            spinner3.setFocusable(true);
            spinner3.setFocusableInTouchMode(true);
            spinner3.requestFocus();

            return false;
        }
        if (spinner5.getSelectedItemPosition() == 0) {

            TextView spinnerText = (TextView)spinner5.getChildAt(0);
            spinnerText.setTextColor(Color.RED);
            spinner5.setFocusable(true);
            spinner5.setFocusableInTouchMode(true);
            spinner5.requestFocus();

            return false;
        }

        if (rgKimLevantarCondicoesTrabalho.getCheckedRadioButtonId()< 0) {
            TextView spinnerText = (TextView)findViewById(R.id.tvKimLevantarCondicoesTrabalho);
            spinnerText.setTextColor(Color.RED);
            spinnerText.setFocusable(true);
            spinnerText.setFocusableInTouchMode(true);
            spinnerText.requestFocus();

            return false;
        }
    return true;
    }

}
