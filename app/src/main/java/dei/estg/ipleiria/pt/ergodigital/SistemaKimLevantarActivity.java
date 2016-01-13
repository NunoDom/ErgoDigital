package dei.estg.ipleiria.pt.ergodigital;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SistemaKimLevantarActivity extends AppCompatActivity {
    Spinner spinner1;
    Spinner spinner2;
    Spinner spinner3;
    Spinner spinner4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_kim_levantar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        spinner1 = (Spinner)findViewById(R.id.cbKimTipoDeTrabalho);
        spinner2 = (Spinner)findViewById(R.id.cbKimDuracaoRepeticao);
        spinner3 = (Spinner)findViewById(R.id.cbKimSexo);
        spinner4 = (Spinner)findViewById(R.id.cbKimLevantarPontucaoCarga);


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position>0)
                actualizaAdapterPontuacaoTempo(view, position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }






        });





        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                if(position>0)
                actualizaAdapterPontuacaoCarga(view,position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });







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



    private void actualizaAdapterPontuacaoTempo(View view,int position){


        ArrayAdapter<CharSequence> adapter = null;

        switch (position)
        {
            case 1:
                adapter = ArrayAdapter.createFromResource(this,R.array.KimElevacaoDeslocacao, android.R.layout.simple_spinner_dropdown_item);
                break;
            case 2:
                adapter = ArrayAdapter.createFromResource(this,R.array.KimaElevacaoPega, android.R.layout.simple_spinner_dropdown_item);
                break;
            case 3:
                adapter = ArrayAdapter.createFromResource(this,R.array.KimElevacaoTransporte, android.R.layout.simple_spinner_dropdown_item);
                break;
        }
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner2.setAdapter(adapter);

    }

    private void actualizaAdapterPontuacaoCarga(View view,int position){


        ArrayAdapter<CharSequence> adapter = null;

        switch (position)
        {
            case 1:
                adapter = ArrayAdapter.createFromResource(this,R.array.KimElevacaoCargaHomens, android.R.layout.simple_spinner_dropdown_item);
                break;
            case 2:
                adapter = ArrayAdapter.createFromResource(this,R.array.KimElevacaoCargaMulheres, android.R.layout.simple_spinner_dropdown_item);
                break;

        }
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner4.setAdapter(adapter);

    }


}
