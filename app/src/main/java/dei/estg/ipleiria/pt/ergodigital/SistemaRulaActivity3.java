package dei.estg.ipleiria.pt.ergodigital;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import dei.estg.ipleiria.pt.ergodigital.Model.Consulta;
import dei.estg.ipleiria.pt.ergodigital.Model.GestaoUtentes;
import dei.estg.ipleiria.pt.ergodigital.Model.Resultado;
import dei.estg.ipleiria.pt.ergodigital.TabelasDeReferencia.TabelaReferenciaRULA;

public class SistemaRulaActivity3 extends AppCompatActivity {

    Resultado[] avaliacao;
    int ResultadoA;
    int ResultadoB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_rula3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if ((getIntent().hasExtra("avaliacao"))&&(getIntent().hasExtra("ResultadoA"))&&(getIntent().hasExtra("ResultadoB"))) {
            Bundle extras = getIntent().getExtras();
            avaliacao = (Resultado[])extras.getSerializable("avaliacao");
            ResultadoA=extras.getInt("ResultadoA");
            ResultadoB=extras.getInt("ResultadoB");
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

               // Toast.makeText(getApplicationContext(), "resultadoA: " + resultadoC + "\n resultadoB: " + resultadoD, Toast.LENGTH_SHORT).show();
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
                //Toast.makeText(getApplicationContext(), "Resultado Total : " + ResultadoTotal + "\n " + message, Toast.LENGTH_SHORT).show();




                TextView tvMusculatura= (TextView)findViewById(R.id.tvRulaPontosMusculatura);
                TextView tvForca= (TextView)findViewById(R.id.tvRulaPontosForca);





                Resultado resultadoMusculatura;
                if (Musculatura == 0) {
                    resultadoMusculatura = new Resultado(tvMusculatura.getText().toString()+": ", Musculatura + "- "+getString(R.string.nenhumPontosMusculatura));
                } else {
                    resultadoMusculatura = new Resultado(tvMusculatura.getText().toString()+": ", Musculatura + "- " + checkBoxPontosMusculatura.getText().toString());
                }




                Resultado resultadoForcaCarga = new Resultado(tvForca.getText().toString()+": ", Forca + "- " + spinner1.getSelectedItem().toString());
                Resultado resultadoFinal = new Resultado(getString(R.string.ResultadoAvaliacao)+": ", ResultadoTotal + "- " + message);

                avaliacao[8] = resultadoMusculatura;
                avaliacao[9] = resultadoForcaCarga;
                avaliacao[10] = resultadoFinal;


                Consulta consulta;
                SharedPreferences mPrefs = getSharedPreferences("dados", 0);
                int idConsulta = mPrefs.getInt("idConsulta", -1);

                if (idConsulta > 0) {
                    consulta = GestaoUtentes.getInstance().getConsulta(idConsulta);

                    if (consulta.getPessoa() != null) {
                        consulta.getPessoa().addConsulta(consulta);
                    }
                        for (int c=0;c<avaliacao.length;c++){
                            Resultado resultado= new Resultado((avaliacao[c].getTitulo()),(avaliacao[c].getValor()));
                        consulta.addResultado(resultado);
                    }

                    consulta.setFerramenta("RULA");
                    Intent intent = new Intent(SistemaRulaActivity3.this, ActivityResultado.class);
                    intent.putExtra("consulta", consulta);
                    startActivity(intent);


                    Intent returnIntent = new Intent();
                    setResult(SistemaRulaActivity2.RESULT_OK, returnIntent);
                    finish();

                }else
                {
                    Toast.makeText(getApplicationContext(), "ERRO nao existe consulta", Toast.LENGTH_SHORT).show();
                }




            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

}
