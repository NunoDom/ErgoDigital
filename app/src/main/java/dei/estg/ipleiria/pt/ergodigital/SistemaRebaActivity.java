package dei.estg.ipleiria.pt.ergodigital;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Spinner;

import dei.estg.ipleiria.pt.ergodigital.TabelasDeReferencia.TabelaReferenciaREBA;

public class SistemaRebaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_reba);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TabelaReferenciaREBA tab = new TabelaReferenciaREBA();

                Spinner spinner1 = (Spinner)findViewById(R.id.cbRebaTronco);
                Spinner spinner2 = (Spinner)findViewById(R.id.cbRebaPescoco);
                Spinner spinner3 = (Spinner)findViewById(R.id.cbRebaPernas);

                CheckBox checkBox1 = (CheckBox)findViewById(R.id.chckboxRebaCorrecaoTronco);
                CheckBox checkBox2 = (CheckBox)findViewById(R.id.chckboxRebaCorrecaoPescoco);
                CheckBox checkBox3 = (CheckBox)findViewById(R.id.chckboxRebaCorrecaoPernas1);
                CheckBox checkBox4 = (CheckBox)findViewById(R.id.chckboxRebaCorrecaoPernas2);

                int tronco = spinner1.getSelectedItemPosition()+1;
                int pescoco = spinner2.getSelectedItemPosition()+1;
                int pernas = spinner3.getSelectedItemPosition()+1;

                if (checkBox1.isChecked())
                {
                    tronco+=1;
                }
                if (checkBox2.isChecked())
                {
                    pescoco+=1;
                }

                if (checkBox3.isChecked())
                {
                    pernas+=1;
                }

                if (checkBox4.isChecked())
                {
                    pernas+=2;
                }


                Integer resultadoA=tab.devolveTabelaA(tronco,pescoco,pernas);


                Intent intent = new Intent(getApplicationContext(),SistemaRebaActivity2.class);
                intent.putExtra("ResultadoA",resultadoA);
                startActivity(intent);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



    public void clickRebaSeguinte(View view)
    {

    }

    public void clickChckboxRebaCorrecaoPernas1(View view) {
        ((CheckBox)findViewById(R.id.chckboxRebaCorrecaoPernas2)).setChecked(false);

    }
    public void clickChckboxRebaCorrecaoPernas2(View view) {
        ((CheckBox)findViewById(R.id.chckboxRebaCorrecaoPernas1)).setChecked(false);
    }
}
