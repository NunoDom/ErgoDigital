package dei.estg.ipleiria.pt.ergodigital;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import dei.estg.ipleiria.pt.ergodigital.Model.Consulta;
import dei.estg.ipleiria.pt.ergodigital.Model.Resultado;
import dei.estg.ipleiria.pt.ergodigital.TabelasDeReferencia.TabelaReferenciaRULA;

public class SistemaRulaActivity3 extends AppCompatActivity {

    Consulta consulta;
    int ResultadoA;
    int ResultadoB;
    int Lado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_rula3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if ((getIntent().hasExtra("consulta"))&&(getIntent().hasExtra("ResultadoA"))&&(getIntent().hasExtra("ResultadoB"))) {
            Bundle extras = getIntent().getExtras();
            consulta = (Consulta)extras.getSerializable("consulta");
            ResultadoA=extras.getInt("ResultadoA");
            ResultadoB=extras.getInt("ResultadoB");
            Lado = extras.getInt("Lado");
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Spinner spinner1 = (Spinner) findViewById(R.id.cbForcaCargaList);
                int Musculatura = 0;
                int Forca = spinner1.getSelectedItemPosition();
                CheckBox checkBoxPontosMusculatura = (CheckBox) findViewById(R.id.checkBoxPontosMusculatura);
                TabelaReferenciaRULA tab = new TabelaReferenciaRULA();

                if (checkBoxPontosMusculatura.isChecked())
                    Musculatura = 1;

                int resultadoC = ResultadoA + Musculatura + Forca;
                int resultadoD = ResultadoB + Musculatura + Forca;
                int ResultadoTotal = tab.devolveTabelaC(resultadoC, resultadoD);

                Toast.makeText(getApplicationContext(), "resultadoA: " + resultadoC + "\n resultadoB: " + resultadoD, Toast.LENGTH_SHORT).show();
                String message = "";
                if (ResultadoTotal == 1 || ResultadoTotal == 2) {
                    message = "Postura aceitável, se não for mantida ou repetida por longos períodos de tempo";
                }
                if (ResultadoTotal == 3 || ResultadoTotal == 4) {
                    message = "Postura a investigar e poderão ser necessárias alterações";
                }
                if (ResultadoTotal == 5 || ResultadoTotal == 6) {
                    message = "Postura a investigar e alterar rapidamente";
                }
                if (ResultadoTotal == 7) {
                    message = "Postura a investigar e alterar urgentemente";
                }
                Toast.makeText(getApplicationContext(), "Resultado Total : " + ResultadoTotal + "\n " + message, Toast.LENGTH_SHORT).show();

                Resultado resultadoMusculatura;
                if(Musculatura==0) {
                    resultadoMusculatura = new Resultado("Musculatura: ", Musculatura +"- Não apresenta defeito");
                }else {
                    resultadoMusculatura = new Resultado("Musculatura: ", Musculatura + "- " + checkBoxPontosMusculatura.getText().toString());
                }


                Resultado resultadoForcaCarga= new Resultado("Forca ou Carga: ",Forca+"- "+spinner1.getSelectedItem().toString());
                Resultado resultadoFinal = new Resultado("Resultado Final: ",ResultadoTotal+"- "+message);

                consulta.addResultado(resultadoMusculatura);
                consulta.addResultado(resultadoForcaCarga);
                consulta.addResultado(resultadoFinal);

                if(consulta.getPessoa()!=null) {
                    consulta.getPessoa().addConsulta(consulta);
                }
                Intent intent= new Intent(SistemaRulaActivity3.this,ActivityResultado.class);
                intent.putExtra("consulta", consulta);
                startActivity(intent);






            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

}
