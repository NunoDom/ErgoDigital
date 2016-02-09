package dei.estg.ipleiria.pt.ergodigital;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
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

        SharedPreferences mPrefs = getSharedPreferences("dados", 0);
        SharedPreferences.Editor editor = mPrefs.edit();
        editor.putInt("idUtente", -1);
        editor.commit();

        //instanciar lists e variaveis
        consultas = new ArrayList<>();


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
        //Intent intent= new Intent(this,MainActivity.class);
       finish();
        super.onPause();
    }

    private void updateAdaptador(int id) {

        ListView listView = (ListView) findViewById(R.id.listViewResultados);
        listView.setAdapter(null);
        ArrayAdapter<?> adapter = null;
        switch(id){

            case 1://ADAPTADOR TODAS AS CONSULTAS
            //ArrayList<Consulta> consultas = new ArrayList<>(GestaoUtentes.getInstance().getListaConsultas());
            adapter = new ArrayAdapter<Consulta>(ActivityResultado.this, android.R.layout.simple_list_item_1, consultas);
            listView.setAdapter(adapter);
                break;

            case 2://ADAPTADOR RESULTADO DA AVALIZACAO, RECEBE UMA CONSULTA E MOSTRA TODOS OS RESULTADOS
                ArrayAdapter<?> adapter2 = null;
                ArrayList<Resultado> resultados = new ArrayList<>();
                resultados = consulta.getListaResultados();
                adapter2 = new ArrayAdapter<Resultado>(ActivityResultado.this, android.R.layout.simple_list_item_1, resultados);
                listView.setAdapter(adapter2);
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
