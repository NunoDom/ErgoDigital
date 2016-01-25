package dei.estg.ipleiria.pt.ergodigital;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SistemaKimLevantarActivity extends AppCompatActivity {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_kim_levantar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        spinner1 = (Spinner) findViewById(R.id.cbKimTipoDeTrabalho);

        spinner2 = (Spinner) findViewById(R.id.cbKimDuracaoRepeticao);
        spinner3 = (Spinner) findViewById(R.id.cbKimSexo);
        spinner4 = (Spinner) findViewById(R.id.cbKimLevantarPontucaoCarga);
        spinner5 = (Spinner) findViewById(R.id.cbKimPosiçãoCarga);
        textview1 = (TextView) findViewById(R.id.txtViewTempoActividade);
        textview2 = (TextView) findViewById(R.id.textviewDescricaoPosicaoTrabalho);

        radioButton1 = (RadioButton) findViewById(R.id.radioButton);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) findViewById(R.id.radioButton3);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position > 0)
                    actualizaAdapterPontuacaoTempo(view, position);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });


        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0)
                    actualizaAdapterPontuacaoCarga(view, position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 1:
                        textview2.setText(getString(R.string.KimDescricaoPosicaoTrabalho1));
                        break;

                    case 2:
                        textview2.setText(getString(R.string.KimDescricaoPosicaoTrabalho2));
                        break;

                    case 3:
                        textview2.setText(getString(R.string.KimDescricaoPosicaoTrabalho3));
                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click_analisar();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    private void actualizaAdapterPontuacaoTempo(View view, int position) {


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

    private void actualizaAdapterPontuacaoCarga(View view, int position) {


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
        // Apply the adapter to the spinner
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
            pontuacaoCondicosTrabalho=0;
        }
        if(radioButton2.isChecked())
        {
            pontuacaoCondicosTrabalho=1;
        }
        if(radioButton3.isChecked())
        {
            pontuacaoCondicosTrabalho=2;
        }
        }
resultadoFinal=(pontuacaoCarga+pontuacaoPosicao+pontuacaoCondicosTrabalho)*pontuacaoTempo;

        String mensagem="";
        if(resultadoFinal<10) {
            mensagem = "Situaçao carga baixa, improvável o aparecimento de sobrecarga física";

        }
            if(resultadoFinal>=10 && resultadoFinal<25)
            {
                mensagem="Situaçao de aumento de carga, provável sobrecarga física para pessoas com menos força. Para este grupo, é util um reavaliação do local de trabalho";
            }
            if(resultadoFinal>=25 && resultadoFinal<50)
            {
                mensagem="Situaçao de elvado aumento de carga, também provavel sobrecarga física para pessoas normais.É recomendado a reavaliação do local de trabalho";
            }
            if(resultadoFinal>=50)
            {
                mensagem="Situaçao de carga elevada, é provavel o aparecimento de sobrecarga física.É necessário a reavaliação do local de trabalho";
            }


        Toast.makeText(this,mensagem,Toast.LENGTH_SHORT).show();


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
    return true;
    }

}
