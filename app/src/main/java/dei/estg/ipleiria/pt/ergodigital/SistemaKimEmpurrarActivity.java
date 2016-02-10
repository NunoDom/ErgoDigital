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
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import dei.estg.ipleiria.pt.ergodigital.Model.Consulta;
import dei.estg.ipleiria.pt.ergodigital.Model.GestaoUtentes;
import dei.estg.ipleiria.pt.ergodigital.Model.Pessoa;
import dei.estg.ipleiria.pt.ergodigital.Model.Resultado;
import dei.estg.ipleiria.pt.ergodigital.TabelasDeReferencia.TabelaReferenciaKIM;

public class SistemaKimEmpurrarActivity extends AppCompatActivity {

    int genero;
    Consulta consulta;
    double camiaoTranporte;
    int precisaoPosicaoVelocidade;
    int pontosAvaliacaoPosicao;
    int pontosCondicaoTrabalho;
    int pontosAvaliacaoTempo;
    double indiceGenero;
    double notaRisco;

    Spinner spinnerGenero;
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

        SharedPreferences mPrefs = getSharedPreferences("dados", 0);
        int idConsulta = mPrefs.getInt("idConsulta", -1);
        if (idConsulta>0){
            consulta = GestaoUtentes.getInstance().getConsulta(idConsulta);
            int idUtente= mPrefs.getInt("idUtente", -1);
            if(idUtente>0){
                Pessoa pessoa = GestaoUtentes.getInstance().getPessoa(idConsulta);
                genero=pessoa.getGenero();
                actualizaAdapterGenero();
            }
        }else
        {
            Toast.makeText(getApplicationContext(), "ERRO 404: Consulta id not found", Toast.LENGTH_SHORT).show();
        }

        spinnerGenero =  (Spinner)findViewById(R.id.cbKimEmpurarGenero);
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




        RadioGroup rgKimEmpurarPosicaoTrabalho = (RadioGroup)findViewById(R.id.rgKimEmpurarPosicaoTrabalho);

        rgKimEmpurarPosicaoTrabalho.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            ImageView image = (ImageView)findViewById(R.id.iv_kim_empurar_posicao);


            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int p1 = rbKimEmpurarPosicaoTrabalho1.getId();
                int p2 = rbKimEmpurarPosicaoTrabalho2.getId();
                int p3 = rbKimEmpurarPosicaoTrabalho3.getId();
                int p4 = rbKimEmpurarPosicaoTrabalho4.getId();

                if (checkedId == p1) {
                    image.setImageResource(R.drawable.ic_kim_ep_1);
                }
                if (checkedId == p2) {
                    image.setImageResource(R.drawable.ic_kim_ep_2);
                }
                if (checkedId == p3) {
                    image.setImageResource(R.drawable.ic_kim_ep_3);
                }
                if (checkedId == p4) {
                    image.setImageResource(R.drawable.ic_kim_ep_4);
                }

            }
        });

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
                        txtViewKimEmpurarEscalaTempoTitulo.setText(getString(R.string.txtViewKimEmpurarEscalaTempoTitulo));
                        cbKimEmpurarEscalaTempo.setAdapter(null);

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
                    cbKimEmpurarTipoCarga.setSelection(0);
                    actualizaAdapterNumeroVezes(0,1);
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

                if(verificarCampos())
                click_analisar();
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


private void click_analisar() {


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

    } else { //deslizamento
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
    RadioButton radioButtonPrecisaoVelocidadeMovimento2 = (RadioButton) findViewById(R.id.rbKimEmpurarPrecisaoVelocidadeMovimentoRadioButton2);

    RadioButton radioButtonKimEmpurarPrecisaoPosicao1 = (RadioButton) findViewById(R.id.rbKimEmpurarPrecisaoPosicaoRadioButton1);
    RadioButton radioButtonKimEmpurarPrecisaoPosicao2 = (RadioButton) findViewById(R.id.rbKimEmpurarPrecisaoPosicaoRadioButton2);

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


    String descricaoPosicaoTrabalho="";
    if (rbKimEmpurarPosicaoTrabalho1.isChecked())
    {
        descricaoPosicaoTrabalho=rbKimEmpurarPosicaoTrabalho1.getText().toString();
        pontosAvaliacaoPosicao=1;
    }
    if (rbKimEmpurarPosicaoTrabalho2.isChecked())
    {
        descricaoPosicaoTrabalho=rbKimEmpurarPosicaoTrabalho2.getText().toString();
        pontosAvaliacaoPosicao=2;
    }
    if (rbKimEmpurarPosicaoTrabalho3.isChecked())
    {
        descricaoPosicaoTrabalho=rbKimEmpurarPosicaoTrabalho3.getText().toString();
        pontosAvaliacaoPosicao=4;
    }
    if (rbKimEmpurarPosicaoTrabalho4.isChecked())
    {
        descricaoPosicaoTrabalho=rbKimEmpurarPosicaoTrabalho4.getText().toString();
        pontosAvaliacaoPosicao=8;
    }


    String descricaoCondicoesTrabalho="";
    if (rbKimEmpurarCondicaoTrabalho1.isChecked())
    {
        descricaoCondicoesTrabalho=rbKimEmpurarCondicaoTrabalho1.getText().toString();
        pontosCondicaoTrabalho=1;
    }
    if (rbKimEmpurarCondicaoTrabalho2.isChecked())
    {
        descricaoCondicoesTrabalho=rbKimEmpurarCondicaoTrabalho2.getText().toString();
        pontosCondicaoTrabalho=2;
    }
    if (rbKimEmpurarCondicaoTrabalho3.isChecked())
    {
        descricaoCondicoesTrabalho=rbKimEmpurarCondicaoTrabalho3.getText().toString();
        pontosCondicaoTrabalho=4;
    }
    if (rbKimEmpurarCondicaoTrabalho4.isChecked())
    {
        descricaoCondicoesTrabalho=rbKimEmpurarCondicaoTrabalho4.getText().toString();
        pontosCondicaoTrabalho=8;
    }



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





    String mensagem="";
    if(notaRisco<10) {
        mensagem =getString(R.string.KimEmpurarResultado1);

    }
    if(notaRisco>=10 && notaRisco<25)
    {
        mensagem=getString(R.string.KimEmpurarResultado2);
    }
    if(notaRisco>=25 && notaRisco<50)
    {
        mensagem=getString(R.string.KimEmpurarResultado3);
    }
    if(notaRisco>=50)
    {
        mensagem=getString(R.string.KimEmpurarResultado4);
    }


    Toast.makeText(SistemaKimEmpurrarActivity.this,mensagem,Toast.LENGTH_SHORT).show();

    TextView textViewPontuacaoTitulo = (TextView)findViewById(R.id.txtViewKimEmpurarPontuacaoTitulo);
    TextView txtViewPontuacaoMassaTitulo = (TextView)findViewById(R.id.txtViewKimEmpurarPontuacaoMassaTitulo);
    TextView txtViewPontucacaoPrecisaoTitulo = (TextView)findViewById(R.id.txtViewKimEmpurarPontucacaoPrecisaoTitulo);
    TextView txtViewPosicaoTrabalhoTitulo = (TextView)findViewById(R.id.txtViewKimEmpurarPosicaoTrabalhoTitulo);
    TextView txtViewCondicaoTrabalhoTitulo = (TextView)findViewById(R.id.txtViewKimEmpurarCondicaoTrabalhoTitulo);
    TextView textViewTipoDeTrabalho = (TextView)findViewById(R.id.tvKimLevantarTipoDeTrabalho);



    Resultado resultadoPontuacaoTempo = new Resultado(textViewPontuacaoTitulo.getText().toString()+": ",pontosAvaliacaoTempo+"- "+cbKimEmpurarEscalaTempo.getSelectedItem().toString());



 String aaaa =txtViewPontuacaoMassaTitulo.getText().toString();

    Resultado resultadoPontuacaoMassa = new Resultado(txtViewPontuacaoMassaTitulo.getText().toString()+": ",camiaoTranporte+"- "+cbKimEmpurarPesoCarga.getSelectedItem().toString());




    Resultado resultadoPrecisao;
    if(radioButtonKimEmpurarPrecisaoPosicao1.isChecked()) {
        if(radioButtonPrecisaoVelocidadeMovimento1.isChecked()) {
            resultadoPrecisao = new Resultado(txtViewPontucacaoPrecisaoTitulo.getText().toString() + ": ", precisaoPosicaoVelocidade + "- "+radioButtonKimEmpurarPrecisaoPosicao1.getText().toString()+" "+ radioButtonPrecisaoVelocidadeMovimento1.getText().toString());
        }else
        {
            resultadoPrecisao = new Resultado(txtViewPontucacaoPrecisaoTitulo.getText().toString() + ": ", precisaoPosicaoVelocidade + "- "+radioButtonKimEmpurarPrecisaoPosicao1.getText().toString()+" "+ radioButtonPrecisaoVelocidadeMovimento2.getText().toString());
        }
    }else{

        if(radioButtonPrecisaoVelocidadeMovimento1.isChecked()) {
           resultadoPrecisao = new Resultado(txtViewPontucacaoPrecisaoTitulo.getText().toString() + ": ", precisaoPosicaoVelocidade + "- "+radioButtonKimEmpurarPrecisaoPosicao2.getText().toString()+" "+ radioButtonPrecisaoVelocidadeMovimento1.getText().toString());
        }else {
           resultadoPrecisao = new Resultado(txtViewPontucacaoPrecisaoTitulo.getText().toString() + ": ", precisaoPosicaoVelocidade + "- " + radioButtonKimEmpurarPrecisaoPosicao2.getText().toString() + " " + radioButtonPrecisaoVelocidadeMovimento2.getText().toString());
        }
    }

    Resultado resultadoPosiçaoTrabalho = new Resultado(txtViewPosicaoTrabalhoTitulo.getText().toString()+": ",+pontosAvaliacaoPosicao+"- "+descricaoPosicaoTrabalho);
    Resultado resultadoCondicoesTrabalho = new Resultado(txtViewCondicaoTrabalhoTitulo.getText().toString()+": ",+pontosCondicaoTrabalho+"- "+descricaoCondicoesTrabalho);
    Resultado resultadoTotal = new Resultado(getString(R.string.ResultadoAvaliacao)+": ", notaRisco+"- "+mensagem);


    consulta.addResultado(resultadoPontuacaoTempo);
    consulta.addResultado(resultadoPontuacaoMassa);
    consulta.addResultado(resultadoPrecisao);
    consulta.addResultado(resultadoPosiçaoTrabalho);
    consulta.addResultado(resultadoCondicoesTrabalho);
    consulta.addResultado(resultadoTotal);

    if(consulta.getPessoa()!=null) {
        consulta.getPessoa().addConsulta(consulta);
    }
    consulta.setFerramenta("KIM");
    Intent intent= new Intent(this,ActivityResultado.class);
    intent.putExtra("consulta", consulta);
    startActivity(intent);


    Intent returnIntent = new Intent();
    setResult(SistemaRebaActivity.RESULT_OK, returnIntent);
    finish();

}



    private boolean verificarCampos() {


        if (cbKimEmpurarTipoOperacao.getSelectedItemPosition() == 0) {
            TextView spinnerText = (TextView)cbKimEmpurarTipoOperacao.getChildAt(0);
            spinnerText.setTextColor(Color.RED);
            cbKimEmpurarTipoOperacao.setFocusable(true);
            cbKimEmpurarTipoOperacao.setFocusableInTouchMode(true);
            cbKimEmpurarTipoOperacao.requestFocus();

            return false;
        }

        if (spinnerGenero.getSelectedItemPosition() == 0) {
            TextView tvKimEmpurarGenero = (TextView)findViewById(R.id.tvKimEmpurarGenero);
            tvKimEmpurarGenero.setTextColor(Color.RED);
            spinnerGenero.setFocusable(true);
            spinnerGenero.setFocusableInTouchMode(true);
            spinnerGenero.requestFocus();

            return false;
        }

        if (cbKimEmpurarTipoMovimentoMassa.getSelectedItemPosition() == 0) {

            TextView spinnerText = (TextView)cbKimEmpurarTipoMovimentoMassa.getChildAt(0);
            spinnerText.setTextColor(Color.RED);
            cbKimEmpurarTipoMovimentoMassa.setFocusable(true);
            cbKimEmpurarTipoMovimentoMassa.setFocusableInTouchMode(true);
            cbKimEmpurarTipoMovimentoMassa.requestFocus();

            return false;
        }





        RadioGroup rgKimEmpurarPrecisaoVelocidadeMovimento = (RadioGroup)findViewById(R.id.rgKimEmpurarPrecisaoVelocidadeMovimento);

        if (rgKimEmpurarPrecisaoVelocidadeMovimento.getCheckedRadioButtonId()< 0) {
            TextView spinnerText = (TextView)findViewById(R.id.tvKimEmpurarVelocidadeMovimentoTitulo);
            spinnerText.setTextColor(Color.RED);
            spinnerText.setFocusable(true);
            spinnerText.setFocusableInTouchMode(true);
            spinnerText.requestFocus();

            return false;
        }

        RadioGroup rgKimEmpurarPrecisaoPosicao = (RadioGroup)findViewById(R.id.rgKimEmpurarPrecisaoPosicao);

        if (rgKimEmpurarPrecisaoPosicao.getCheckedRadioButtonId()< 0) {
            TextView spinnerText = (TextView)findViewById(R.id.textViewKimEmpurarPosicaoTrabalhoTitulo);
            spinnerText.setTextColor(Color.RED);
            spinnerText.setFocusable(true);
            spinnerText.setFocusableInTouchMode(true);
            spinnerText.requestFocus();

            return false;
        }

        RadioGroup rgKimEmpurarPosicaoTrabalho = (RadioGroup)findViewById(R.id.rgKimEmpurarPosicaoTrabalho);

        if (rgKimEmpurarPosicaoTrabalho.getCheckedRadioButtonId()< 0) {
            TextView spinnerText = (TextView)findViewById(R.id.txtViewKimEmpurarPosicaoTrabalhoTitulo);
            spinnerText.setTextColor(Color.RED);
            spinnerText.setFocusable(true);
            spinnerText.setFocusableInTouchMode(true);
            spinnerText.requestFocus();

            return false;
        }


        RadioGroup  rgKimEmpurarCondicaoTrabalho = (RadioGroup)findViewById(R.id.rgKimEmpurarCondicaoTrabalho);

        if (rgKimEmpurarCondicaoTrabalho.getCheckedRadioButtonId()< 0) {
            TextView spinnerText = (TextView)findViewById(R.id.txtViewKimEmpurarCondicaoTrabalhoTitulo);
            spinnerText.setTextColor(Color.RED);
            spinnerText.setFocusable(true);
            spinnerText.setFocusableInTouchMode(true);
            spinnerText.requestFocus();

            return false;
        }

        return true;
    }
    private void actualizaAdapterGenero() {
        LinearLayout layout = (LinearLayout) findViewById(R.id.layoutKimEmpurarGenero);
        if(genero>0) {

            spinnerGenero.setSelection(genero);
            layout.setVisibility(View.GONE);
        }else
        {
            layout.setVisibility(View.VISIBLE);
        }

    }
}
