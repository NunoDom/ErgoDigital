package dei.estg.ipleiria.pt.ergodigital;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import dei.estg.ipleiria.pt.ergodigital.Model.GerirPessoas;
import dei.estg.ipleiria.pt.ergodigital.Model.Pessoa;

public class ListaPessoasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pessoas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        aaaa();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ListView listaListView= (ListView)findViewById(R.id.listViewListaPessoas);
        listaListView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_avaliacao_postural, menu);
        return true;
    }


    public void callOWAS(View view) {

        Intent intent = new Intent(this, SistemaOwasActivity.class);
        startActivity(intent);

    }

    public void callRULA(View view) {

        Intent intent = new Intent(this, SistemaRulaActivity.class);
        startActivity(intent);

    }


    private void aaaa() {
        // our adapter instance

        ArrayList<Pessoa> resultados = GerirPessoas.INSTANCE.getListaPessoas();
        ListView listView = (ListView) findViewById(R.id.listViewListaPessoas);

        ArrayAdapter<Pessoa> adapter = new ArrayAdapter<Pessoa>(ListaPessoasActivity.this, android.R.layout.simple_list_item_1, resultados);
        listView.setAdapter(adapter);


    }






}
