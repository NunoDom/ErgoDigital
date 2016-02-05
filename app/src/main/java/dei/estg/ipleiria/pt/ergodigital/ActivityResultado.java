package dei.estg.ipleiria.pt.ergodigital;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import dei.estg.ipleiria.pt.ergodigital.Model.Consulta;
import dei.estg.ipleiria.pt.ergodigital.Model.Resultado;

public class ActivityResultado extends AppCompatActivity {
    Consulta consulta;
    ArrayList<Consulta> consultas;
    Resultado resultado;
    int id=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //instanciar lists e variaveis
        consultas = new ArrayList<>();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });


        //verifica o extra que recebe no intent

        Intent intent =getIntent();
        if (intent.hasExtra("consultas")) {//se receber consultas, mostra todoas as consultas
            Bundle extras = getIntent().getExtras();
            consultas = (ArrayList<Consulta>)extras.getSerializable("consultas");
            id=1;
        }
        if (intent.hasExtra("consulta")) {//se receber 1 consulta, mostra os resultados das consultas
            Bundle extras = getIntent().getExtras();
            consulta = (Consulta)extras.getSerializable("consulta");
            id=2;
        }
        if (intent.hasExtra("resultado")) {//se receber 1 consulta, mostra os resultados das consultas
            Bundle extras = getIntent().getExtras();
            resultado = (Resultado)extras.getSerializable("resultado");
            id=3;
        }
        updateAdaptador(id);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public void onPanelClosed(int featureId, Menu menu) {

    }

    @Override
    protected void onPause() {
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);
        super.onPause();
    }

    private void updateAdaptador(int id) {
        ListView listView = (ListView) findViewById(R.id.listViewResultados);
        ArrayAdapter<?> adapter = null;
        switch(id){

            case 1://ADAPTADOR TODAS AS CONSULTAS
            //ArrayList<Consulta> consultas = new ArrayList<>(GestaoUtentes.getInstance().getListaConsultas());
            adapter = new ArrayAdapter<Consulta>(ActivityResultado.this, android.R.layout.simple_list_item_1, consultas);
            listView.setAdapter(adapter);
                break;

            case 2://ADAPTADOR RESULTADO DA AVALIZACAO, RECEBE UMA CONSULTA E MOSTRA TODOS OS RESULTADOS

                ArrayList<Resultado> resultados = new ArrayList<>();
                resultados = consulta.getListaResultados();
                adapter = new ArrayAdapter<>(ActivityResultado.this, android.R.layout.simple_list_item_1, resultados);
                listView.setAdapter(adapter);
                break;



                /*
                ArrayList<Resultado> resultado = new ArrayList<>();
                ArrayList<String> consultaArray= new ArrayList<>();
                consultaArray.add("Consulta ID"+consulta.getId());
                adapter = new ArrayAdapter<>(ActivityResultado.this, android.R.layout.simple_list_item_1, resultado);

                listView.setAdapter(adapter);
                break;
                */

        }

    }

}
