package dei.estg.ipleiria.pt.ergodigital;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.style.UpdateAppearance;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.GregorianCalendar;

import dei.estg.ipleiria.pt.ergodigital.Model.GerirPessoas;
import dei.estg.ipleiria.pt.ergodigital.Model.Pessoa;

public class DadosUtenteActivity extends AppCompatActivity {

    Pessoa pessoa;
    EditText editTextName;
    EditText editTextDataAno;
    EditText editTextDataDia;
    EditText editTextDataMes;
    EditText editTextAltura;
    EditText editTextPeso;
    Spinner spinnerGenero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_utente);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        if (getIntent().hasExtra("pessoa")) {
            Bundle extras = getIntent().getExtras();
            pessoa = (Pessoa)extras.getSerializable("pessoa");
            modoEditar(pessoa);
        }


        editTextName = (EditText)findViewById(R.id.editTextUtenteNome);
        editTextDataAno= (EditText)findViewById(R.id.editTextUtenteDataAno);
        editTextDataDia= (EditText)findViewById(R.id.editTextUtenteDataDia);
        editTextDataMes= (EditText)findViewById(R.id.editTextUtenteDataMes);
        editTextAltura= (EditText)findViewById(R.id.editTextUtenteAltura);
        editTextPeso= (EditText)findViewById(R.id.editTextUtentePeso);
        spinnerGenero = (Spinner)findViewById(R.id.cbUtenteGenero);





        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floUtenteAddUtente);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click(view);
            }
        });

    }

    private void modoEditar(Pessoa pessoa) {



        editTextName.setText(pessoa.getName());
        editTextDataAno.setText(String.valueOf(pessoa.getDataNascimento().YEAR));
        editTextDataDia.setText(String.valueOf(pessoa.getDataNascimento().YEAR));
        editTextDataMes.setText(String.valueOf(pessoa.getDataNascimento().YEAR));
        editTextAltura.setText(pessoa.getAltura());
        editTextPeso.setText(pessoa.getPeso());
        spinnerGenero.setSelection(pessoa.getGenero());
    }


    private void click(View view){
        try {
        String nome=editTextName.getText().toString();
        int dia = Integer.parseInt(editTextDataDia.getText().toString());
        int mes = Integer.parseInt(editTextDataMes.getText().toString());
        int ano = Integer.parseInt(editTextDataAno.getText().toString());
        Integer genero = spinnerGenero.getSelectedItemPosition()-1;
        int altura =  Integer.parseInt(editTextAltura.getText().toString());
        int peso= Integer.parseInt(editTextPeso.getText().toString());

if(ano<1900 || ano>GregorianCalendar.YEAR){
    Toast.makeText(this,"Ano Invalido",Toast.LENGTH_SHORT).show();
}else{
    if(mes<1 || mes >12)
    {
        Toast.makeText(this,"Mês Inválido",Toast.LENGTH_SHORT).show();
    }else
    {
        if(dia<1 || dia>31)
        {
            Toast.makeText(this,"Dia invalido",Toast.LENGTH_SHORT).show();
        }else
        {

            if((altura<50 || altura >250)){
                Toast.makeText(this,"Altura invalida",Toast.LENGTH_SHORT).show();
            }else
            {
                if(peso<10 || peso>500)
                {

                }else
                {
                    if((spinnerGenero.getSelectedItemPosition()-1)<0)
                    {
                        Toast.makeText(this,"Selecione um genero",Toast.LENGTH_SHORT).show();
                    }else{
                    Pessoa pessoa = new Pessoa(nome, dia, mes, ano, genero, altura, peso);
                    GerirPessoas.INSTANCE.addPessoa(pessoa);
                    Toast.makeText(this,"Utente adicionado com sucesso ",Toast.LENGTH_SHORT).show();
                        this.finish();
                    }
                }
            }
        }
    }
}
        }catch (Exception ex) {
            Toast.makeText(this,"Preencha todos os campos",Toast.LENGTH_SHORT).show();
        }
    }



    public void editarUtente(View view)
    {
        Toast.makeText(getBaseContext(),"Funcionalidade ainda nao implementada",Toast.LENGTH_SHORT).show();
    }


    public void apagarUtente(View view)
    {
        Toast.makeText(getBaseContext(),"Funcionalidade ainda nao implementada",Toast.LENGTH_SHORT).show();
    }


public void realizarAvaliacao(View view){
    Intent intent = new Intent(this, EscolhaAvaliacoesActivity.class);
    intent.putExtra("pessoa",pessoa);
    startActivity(intent);

}




}
