package dei.estg.ipleiria.pt.ergodigital;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import dei.estg.ipleiria.pt.ergodigital.Model.GestaoUtentes;
import dei.estg.ipleiria.pt.ergodigital.Model.Pessoa;

public class EscolhaAvaliacoesActivity extends AppCompatActivity {

    int idUtente=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolha_avaliacoes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getIntent().hasExtra("idUtente")) {
            Bundle extras = getIntent().getExtras();
            int valor = extras.getInt("idUtente");
            if(valor>0) {
                Pessoa pessoa = GestaoUtentes.getInstance().getPessoa(extras.getInt("idUtente"));
                idUtente = pessoa.getId();
            }
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    public void callAPActivity(View view) {

        Intent intent = new Intent(this, AvaliacaoPosturalActivity.class);
        intent.putExtra("idUtente",idUtente);
        startActivity(intent);

    }

    public void callMCActivity(View view) {

        Intent intent = new Intent(this, MovimentacaoDeCargasActivity.class);
        intent.putExtra("idUtente",idUtente);
        startActivity(intent);


    }
}
