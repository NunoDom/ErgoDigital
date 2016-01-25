package dei.estg.ipleiria.pt.ergodigital;

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

import dei.estg.ipleiria.pt.ergodigital.TabelasDeReferencia.TabelaReferenciaKIM;

public class SistemaKimEmpurrarActivity extends AppCompatActivity {

    double camiaoTranporte;
    int precisaoPosicaoVelocidade;
    int pontosAvaliacaoPosicao;
    int pontosCondicaoTrabalho;
    int pontosAvaliacaoTempo;
    double indiceGenero;
    double notaRisco;

    Spinner cbKimEmpurarTipoOperacao;
    Spinner cbKimEmpurarEscalaTempo;
    Spinner cbKimEmpurarTipoCarga;
    Spinner cbKimEmpurarTipoMovimentoMassa;
    Spinner cbKimEmpurarPesoCarga;

    TextView txtViewKimEmpurarTipoCargaTitulo;
    TextView txtViewKimEmpurarEscalaTempoTitulo;

    RadioButton rbKimEmpurarPosicaoTrabalho1;
    RadioButton rbKimEmpurarPosicaoTrabalho2;
    RadioButton rbKimEmpurarPosicaoTrabalho3;
    RadioButton rbKimEmpurarPosicaoTrabalho4;

    RadioButton rbKimEmpurarCondicaoTrabalho1;
    RadioButton rbKimEmpurarCondicaoTrabalho2;
    RadioButton rbKimEmpurarCondicaoTrabalho3;
    RadioButton rbKimEmpurarCondicaoTrabalho4;


    int tipo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_kim_empurrar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        cbKimEmpurarPesoCarga = (Spinner)findViewById(R.id.cbKimEmpurarPesoCarga);
        cbKimEmpurarTipoMovimentoMassa= (Spinner)findViewById(R.id.cbKimEmpurarTipoMovimentoMassa);
        cbKimEmpurarTipoOperacao= (Spinner)findViewById(R.id.cbKimEmpurarTipoOperacao);
        cbKimEmpurarEscalaTempo= (Spinner)findViewById(R.id.cbKimEmpurarEscalaTempo);
        cbKimEmpurarTipoCarga = (Spinner)findViewById(R.id.cbKimEmpurarTipoCarga);

        txtViewKimEmpurarEscalaTempoTitulo =(TextView)findViewById(R.id.txtViewKimEmpurarEscalaTempoTitulo);
        txtViewKimEmpurarTipoCargaTitulo=(TextView)findViewById(R.id.txtViewKimEmpurarTipoCargaTitulo);


        rbKimEmpurarPosicaoTrabalho1 =(RadioButton)findViewById(R.id.rbKimEmpurarPosicaoTrabalho1);
        rbKimEmpurarPosicaoTrabalho2= (RadioButton)findViewById(R.id.rbKimEmpurarPosicaoTrabalho2);
        rbKimEmpurarPosicaoTrabalho3= (RadioButton)findViewById(R.id.rbKimEmpurarPosicaoTrabalho3);
        rbKimEmpurarPosicaoTrabalho4= (RadioButton)findViewById(R.id.rbKimEmpurarPosicaoTrabalho4);

        rbKimEmpurarCondicaoTrabalho1= (RadioButton)findViewById(R.id.rbKimEmpurarCondicaoTrabalho1);
        rbKimEmpurarCondicaoTrabalho2= (RadioButton)findViewById(R.id.rbKimEmpurarCondicaoTrabalho2);
        rbKimEmpurarCondicaoTrabalho3= (RadioButton)findViewById(R.id.rbKimEmpurarCondicaoTrabalho3);
        rbKimEmpurarCondicaoTrabalho4= (RadioButton)findViewById(R.id.rbKimEmpurarCondicaoTrabalho4);



        cbKimEmpurarTipoOperacao.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==1)
                {
                    txtViewKimEmpurarEscalaTempoTitulo.setText(getString(R.string.KimEmpurarTipoOperacaoNumeroVezes));
                    ArrayAdapter<CharSequence> adapter = null;
                    adapter = ArrayAdapter.createFromResource(SistemaKimEmpurrarActivity.this, R.array.KimEmpurarTipoOperacaoCurtaDistancia, android.R.layout.simple_spinner_dropdown_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    cbKimEmpurarEscalaTempo.setAdapter(adapter);
                }else{ if (position==2){
                    txtViewKimEmpurarEscalaTempoTitulo.setText(getString(R.string.KimEmpurarTipoOperacaoDistancia));
                    ArrayAdapter<CharSequence> adapter = null;
                    adapter = ArrayAdapter.createFromResource(SistemaKimEmpurrarActivity.this, R.array.KimEmpurarTipoOperacaoLongaDistancia, android.R.layout.simple_spinner_dropdown_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    cbKimEmpurarEscalaTempo.setAdapter(adapter);
                }else
                    {
                        txtViewKimEmpurarEscalaTempoTitulo.setText("Numero de Vezes/Distancia Total");

                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        cbKimEmpurarTipoMovimentoMassa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position==1) { //SER FOR ROLAMENTO
                    cbKimEmpurarTipoCarga.setVisibility(View.VISIBLE);
                    txtViewKimEmpurarTipoCargaTitulo.setVisibility(View.VISIBLE);
                    cbKimEmpurarPesoCarga.setVisibility(View.VISIBLE);


                    tipo=1;
                }else              //SE FOR DESLIZAMENTO
                {if (position==2) {
                    cbKimEmpurarTipoCarga.setVisibility(View.INVISIBLE);
                    txtViewKimEmpurarTipoCargaTitulo.setVisibility(View.INVISIBLE);
                    cbKimEmpurarPesoCarga.setVisibility(View.VISIBLE);
                    actualizaAdapterNumeroVezes(position, 2);
                    tipo = 2;
                }else
                {
                    cbKimEmpurarTipoCarga.setVisibility(View.INVISIBLE);
                    txtViewKimEmpurarTipoCargaTitulo.setVisibility(View.INVISIBLE);
                    cbKimEmpurarPesoCarga.setVisibility(View.INVISIBLE);
                    actualizaAdapterNumeroVezes(position, 2);

                }

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        cbKimEmpurarTipoCarga.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                actualizaAdapterNumeroVezes(position,1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                click_analisar(view);
                String mensagem="";
                if(notaRisco<10) {
                    mensagem = "Situaçao carga baixa, improvável o aparecimento de sobrecarga física";

                }
                if(notaRisco>=10 && notaRisco<25)
                {
                    mensagem="Situaçao de aumento de carga, provável sobrecarga física para pessoas com menos força. Para este grupo, é util um reavaliação do local de trabalho";
                }
                if(notaRisco>=25 && notaRisco<50)
                {
                    mensagem="Situaçao de elvado aumento de carga, também provavel sobrecarga física para pessoas normais.É recomendado a reavaliação do local de trabalho";
                }
                if(notaRisco>=50)
                {
                    mensagem="Situaçao de carga elevada, é provavel o aparecimento de sobrecarga física.É necessário a reavaliação do local de trabalho";
                }


                Toast.makeText(SistemaKimEmpurrarActivity.this,mensagem,Toast.LENGTH_SHORT).show();

            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void actualizaAdapterNumeroVezes(int position, int tipo)
    {
        ArrayAdapter<CharSequence> adapter = null;

        if (tipo==1) {
            switch (position) {
                case 0:
                    adapter = ArrayAdapter.createFromResource(this, R.array.KimEmpurarMassaPesoCarga1, android.R.layout.simple_spinner_dropdown_item);
                    break;
                case 1:
                    adapter = ArrayAdapter.createFromResource(this, R.array.KimEmpurarMassaPesoCarga2, android.R.layout.simple_spinner_dropdown_item);
                    break;
                case 2:
                    adapter = ArrayAdapter.createFromResource(this, R.array.KimEmpurarMassaPesoCarga3, android.R.layout.simple_spinner_dropdown_item);
                    break;
                case 3:
                    adapter = ArrayAdapter.createFromResource(this, R.array.KimEmpurarMassaPesoCarga4, android.R.layout.simple_spinner_dropdown_item);
                    break;
                case 4:
                    adapter = ArrayAdapter.createFromResource(this, R.array.KimEmpurarMassaPesoCarga5, android.R.layout.simple_spinner_dropdown_item);
                    break;            }


        }else
        {


            adapter = ArrayAdapter.createFromResource(this, R.array.KimEmpurarDeslizamentoPesoCarga, android.R.layout.simple_spinner_dropdown_item);


        }
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        cbKimEmpurarPesoCarga.setAdapter(adapter);

    }


private void click_analisar(View view) {


    switch (cbKimEmpurarEscalaTempo.getSelectedItemPosition()) {
        case 0:
            pontosAvaliacaoTempo = 1;
            break;
        case 1:
            pontosAvaliacaoTempo = 2;
            break;
        case 2:
            pontosAvaliacaoTempo = 4;
            break;
        case 3:
            pontosAvaliacaoTempo = 6;
            break;
        case 4:
            pontosAvaliacaoTempo = 8;
            break;
        case 5:
            pontosAvaliacaoTempo = 10;
            break;
    }

    if (tipo == 1)//se rolamento
    {
        TabelaReferenciaKIM tab = new TabelaReferenciaKIM();

        int a =cbKimEmpurarTipoCarga.getSelectedItemPosition()+1;
        int b= cbKimEmpurarPesoCarga.getSelectedItemPosition()+1;

        camiaoTranporte = tab.devolve(a+1,b+1);

    } else {
        if (tipo == 2) {
            switch (cbKimEmpurarPesoCarga.getSelectedItemPosition()) {
                case 0:
                    camiaoTranporte = 1;
                    break;
                case 1:
                    camiaoTranporte = 2;
                    break;
                case 2:
                    camiaoTranporte = 4;
                    break;
            }
        }
    }

    RadioButton radioButtonPrecisaoVelocidadeMovimento1 = (RadioButton) findViewById(R.id.rbKimEmpurarPrecisaoVelocidadeMovimentoRadioButton1);

    RadioButton radioButtonKimEmpurarPrecisaoPosicao1 = (RadioButton) findViewById(R.id.rbKimEmpurarPrecisaoPosicaoRadioButton1);

    if (radioButtonPrecisaoVelocidadeMovimento1.isChecked()) {


        if (radioButtonKimEmpurarPrecisaoPosicao1.isChecked()) {

            precisaoPosicaoVelocidade = 1;

        } else {
            precisaoPosicaoVelocidade = 2;
        }


    } else {
        if (radioButtonKimEmpurarPrecisaoPosicao1.isChecked()) {

            precisaoPosicaoVelocidade = 2;

        } else {
            precisaoPosicaoVelocidade = 4;
        }

    }



    if (rbKimEmpurarPosicaoTrabalho1.isChecked())
    {
        pontosAvaliacaoPosicao=1;
    }
    if (rbKimEmpurarPosicaoTrabalho2.isChecked())
    {
        pontosAvaliacaoPosicao=2;
    }
    if (rbKimEmpurarPosicaoTrabalho3.isChecked())
    {
        pontosAvaliacaoPosicao=4;
    }
    if (rbKimEmpurarPosicaoTrabalho4.isChecked())
    {
        pontosAvaliacaoPosicao=8;
    }



    if (rbKimEmpurarCondicaoTrabalho1.isChecked())
    {
        pontosCondicaoTrabalho=1;
    }
    if (rbKimEmpurarCondicaoTrabalho2.isChecked())
    {
        pontosCondicaoTrabalho=2;
    }
    if (rbKimEmpurarCondicaoTrabalho3.isChecked())
    {
        pontosCondicaoTrabalho=4;
    }
    if (rbKimEmpurarCondicaoTrabalho4.isChecked())
    {
        pontosCondicaoTrabalho=8;
    }


    Spinner spinnerGenero =  (Spinner)findViewById(R.id.cbKimEmpurarGenero);
    if(spinnerGenero.getSelectedItemPosition()==1)
    {
indiceGenero=1;

    }
    if(spinnerGenero.getSelectedItemPosition()==2)
    {
        indiceGenero=1.3;
    }

    notaRisco = (camiaoTranporte+precisaoPosicaoVelocidade+pontosAvaliacaoPosicao+pontosCondicaoTrabalho)*pontosAvaliacaoTempo*indiceGenero;
    Toast.makeText(getApplicationContext(),"B: "+camiaoTranporte+"\nC: "+precisaoPosicaoVelocidade+"\nD "+pontosAvaliacaoPosicao+"\nE" +pontosCondicaoTrabalho+"\nx A "+pontosAvaliacaoTempo+"\nx Genero: "+indiceGenero+"\nResultado Final: "+notaRisco,Toast.LENGTH_LONG).show();
}



    //<item>Tronco direito, não torcido</item>
    ////<item>Tronco ligeiramente dobrado para a frente ou ligeiramente torcido(puxar com um dos lados) </item>
    //<item>Corpo baixo inclinado em direcao do movimento,dobrado ajoelhado inclinado </item>
    //<item>Combinação de corpo inclinado e torcido </item>



}
