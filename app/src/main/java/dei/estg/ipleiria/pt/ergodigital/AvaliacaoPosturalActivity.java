package dei.estg.ipleiria.pt.ergodigital;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import dei.estg.ipleiria.pt.ergodigital.Model.GestaoUtentes;
import dei.estg.ipleiria.pt.ergodigital.Model.Pessoa;

public class AvaliacaoPosturalActivity extends AppCompatActivity {

    int idUtente=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliacao_postural);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
        //    return true;
        //}

        return super.onOptionsItemSelected(item);

}


    public void callOWAS(View view){

        Intent intent = new Intent(this,SistemaOwasActivity.class);
        intent.putExtra("idUtente",idUtente);
        startActivity(intent);

    }
    public void callRULA(View view){

        Intent intent = new Intent(this,SistemaRulaActivity.class);
        intent.putExtra("idUtente",idUtente);
        startActivity(intent);

    }
    public void callREBA(View view){

        Intent intent = new Intent(this,SistemaRebaActivity.class);
        intent.putExtra("idUtente",idUtente);
        startActivity(intent);

    }
}
