package dei.estg.ipleiria.pt.ergodigital;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import dei.estg.ipleiria.pt.ergodigital.Model.GestaoUtentes;
import dei.estg.ipleiria.pt.ergodigital.Model.Pessoa;

public class ListaPessoasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pessoas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        updateAdaptador();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaPessoasActivity.this,DadosUtenteActivity.class);
                startActivity(intent);
                finish();
            }
        });

        ListView listaListView= (ListView)findViewById(R.id.listViewListaPessoas);
        listaListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent= new Intent(ListaPessoasActivity.this,DadosUtenteActivity.class);
                ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>(GestaoUtentes.getInstance().getListaPessoas());
                Pessoa pessoa = pessoas.get(position);
                intent.putExtra("pessoa",pessoa);
                startActivity(intent);
                updateAdaptador();
            }
        });





        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    protected void onResume() {
        updateAdaptador();
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_avaliacao_postural, menu);
        return true;
    }


    private void updateAdaptador() {

        ArrayList<Pessoa> resultados = new ArrayList<Pessoa>(GestaoUtentes.getInstance().getListaPessoas());

        ListView listView = (ListView) findViewById(R.id.listViewListaPessoas);
        ArrayAdapter<Pessoa> adapter = new ArrayAdapter<Pessoa>(ListaPessoasActivity.this, android.R.layout.simple_list_item_1, resultados);
        listView.setAdapter(adapter);


    }






}
