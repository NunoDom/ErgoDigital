package dei.estg.ipleiria.pt.ergodigital;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import dei.estg.ipleiria.pt.ergodigital.Model.Consulta;
import dei.estg.ipleiria.pt.ergodigital.Model.GestaoUtentes;
import dei.estg.ipleiria.pt.ergodigital.Model.Resultado;

public class RulaActivityResultado extends AppCompatActivity {
    Consulta consulta;
    int id=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rula_activity_resultado);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        if (getIntent().hasExtra("consultas")) {
            Bundle extras = getIntent().getExtras();
            consulta = (Consulta)extras.getSerializable("consultas");
            id=1;
        }
        if (getIntent().hasExtra("resultado")) {
            Bundle extras = getIntent().getExtras();
            consulta = (Consulta)extras.getSerializable("resultado");
            id=1;
        }

        updateAdaptador(id);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void updateAdaptador(int id) {
        ListView listView = (ListView) findViewById(R.id.listViewResultados);
        ArrayAdapter<?> adapter = null;
        switch(id){

            case 0://ADAPTADOR TODAS AS CONSULTAS
            ArrayList<Consulta> consultas = new ArrayList<>(GestaoUtentes.getInstance().getListaConsultas());
            adapter = new ArrayAdapter<Consulta>(RulaActivityResultado.this, android.R.layout.simple_list_item_1, consultas);
            listView.setAdapter(adapter);
                break;

            case 1://ADAPTADOR RESULTADO DA AVALIZACAO
                ArrayList<Resultado> resultado = new ArrayList<>();
                ArrayList<String> consultaArray= new ArrayList<>();
                consultaArray.add("Consulta ID"+consulta.getId());
                adapter = new ArrayAdapter<>(RulaActivityResultado.this, android.R.layout.simple_list_item_1, resultado);

                listView.setAdapter(adapter);
                break;

        }

    }

}
