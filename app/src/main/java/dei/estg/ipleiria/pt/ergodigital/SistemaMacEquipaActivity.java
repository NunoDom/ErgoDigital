package dei.estg.ipleiria.pt.ergodigital;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import dei.estg.ipleiria.pt.ergodigital.Model.Consulta;

public class SistemaMacEquipaActivity extends AppCompatActivity {


    Spinner spinner1;
    Spinner spinner2;
    Consulta consulta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_mac_equipa);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SistemaMacEquipaActivity.this,SistemaMacEquipa2Activity.class);
                startActivityForResult(intent,2);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (getIntent().hasExtra("consulta")) {
            Bundle extras = getIntent().getExtras();
            consulta = (Consulta)extras.getSerializable("consulta");
        }



        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ArrayAdapter<CharSequence> adapter = null;
                switch (position) {
                    case 0:
                        adapter = ArrayAdapter.createFromResource(SistemaMacEquipaActivity.this, R.array.GamEquipaPontuacaoFrequenciaPesoEscalaPeso2Pessoas, android.R.layout.simple_spinner_dropdown_item);
                            break;
                    case 1:
                        adapter = ArrayAdapter.createFromResource(SistemaMacEquipaActivity.this, R.array.GamEquipaPontuacaoFrequenciaPesoEscalaPeso3Pessoas, android.R.layout.simple_spinner_dropdown_item);
                        break;
                    case 2:
                        adapter = ArrayAdapter.createFromResource(SistemaMacEquipaActivity.this, R.array.GamEquipaPontuacaoFrequenciaPesoEscalaPeso4Pessoas, android.R.layout.simple_spinner_dropdown_item);
                    break;
                }
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner2.setAdapter(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

}
