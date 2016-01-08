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

public class SistemaKimActivity extends AppCompatActivity {
    Spinner spinner1;
    Spinner spinner2;
    Spinner spinner3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_kim);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        spinner1 = (Spinner)findViewById(R.id.cbKimTipoDeTrabalho);
        spinner2 = (Spinner)findViewById(R.id.cbKimDuracaoRepeticao);
        spinner3 = (Spinner)findViewById(R.id.spinner2);


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ArrayAdapter<CharSequence> adapter = null;
                switch (position) {
                    case 0:
                        //spinner2.setVisibility(view.INVISIBLE);
                        break;
                    case 1:
                        spinner2.setVisibility(view.VISIBLE);

                        saa(view);
                        break;
                    case 2:
                        break;

                    case 3:
                        spinner2.setVisibility(view.VISIBLE);

                        ArrayAdapter <String> adapter2 =
                                new ArrayAdapter<String> (getApplicationContext(), android.R.layout.simple_spinner_item, new String[] {"Mademoiselle","Madame","Monsieur"});
                        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_item);
                        spinner2.setAdapter(adapter2);

                        //adapter = ArrayAdapter.createFromResource(getApplicationContext(),
                        //R.array.KimTransporte,spinner1.getLa);


                        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                        //spinner2.setAdapter(adapter);
                        break;




                }
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



    private void saa(View view){
        ArrayAdapter<CharSequence> adapter = null;
        adapter = ArrayAdapter.createFromResource(this,    R.array.KimElevacaoDeslocacao, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner2.setAdapter(adapter);

    }
}
