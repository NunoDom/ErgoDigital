package dei.estg.ipleiria.pt.ergodigital;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import dei.estg.ipleiria.pt.ergodigital.Model.Consulta;
import dei.estg.ipleiria.pt.ergodigital.Model.Pessoa;

public class DadosConsultaActivity extends AppCompatActivity {

    Pessoa utente;
    Consulta consulta;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_consulta);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        consulta= new Consulta();

        if (getIntent().hasExtra("utente")) {
            Bundle extras = getIntent().getExtras();
            utente = (Pessoa)extras.getSerializable("utente");
            consulta.setPessoa(utente);
            utente.addConsulta(consulta);
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }




    public void clickRealizarAvaliacao(View view)
    {
        EditText editTextTurno = (EditText)findViewById(R.id.editTextConsultaTurno);
        EditText editTextSeccao= (EditText)findViewById(R.id.editTextConsultaSeccao);
        EditText editTextPostoTrabalho= (EditText)findViewById(R.id.editTextConsultaPostoTrabalho);
        EditText editTextTempoTrabalho= (EditText)findViewById(R.id.editTextConsultaTempoTrabalho);
        EditText editTextTrabalhoDiario= (EditText)findViewById(R.id.editTextConsultaTrabalhoDiario);
        EditText editTextObservacoes= (EditText)findViewById(R.id.editTextConsultaObservacoes);


        consulta.setTurno(editTextTurno.getText().toString());
        consulta.setSeccao(editTextSeccao.getText().toString());
        consulta.setPosto(editTextPostoTrabalho.getText().toString());
        consulta.setTempoTarefa(Integer.parseInt(editTextTempoTrabalho.getText().toString()));
        consulta.setHorasTrabalhoDiario(Integer.parseInt(editTextTrabalhoDiario.getText().toString()));
        consulta.setObservacoes(editTextObservacoes.getText().toString());


        Intent intent = new Intent(this, EscolhaAvaliacoesActivity.class);
        intent.putExtra("consulta", consulta);
        startActivity(intent);
    }


}
