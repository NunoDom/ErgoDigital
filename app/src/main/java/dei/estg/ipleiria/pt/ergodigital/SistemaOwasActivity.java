package dei.estg.ipleiria.pt.ergodigital;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import dei.estg.ipleiria.pt.ergodigital.Model.Consulta;
import dei.estg.ipleiria.pt.ergodigital.Model.GestaoUtentes;
import dei.estg.ipleiria.pt.ergodigital.Model.Resultado;
import dei.estg.ipleiria.pt.ergodigital.TabelasDeReferencia.TabelaReferenciaOWAS;

public class SistemaOwasActivity extends AppCompatActivity {

    private int torso;
    private int bracos;
    private int pernas;
    private int forca;
    private String resultadoString;

    Spinner spinner1;
    Spinner spinner2;
    Spinner spinner3;
    Spinner spinner4;





    Consulta consulta;
    Resultado resultadoTorso;
    Resultado resultadoBracos;
    Resultado resultadoPernas;
    Resultado resultadoForça;
    Resultado resultadoFinal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_owas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SharedPreferences mPrefs = getSharedPreferences("dados", 0);
        int idConsulta = mPrefs.getInt("idConsulta", -1);

        if (idConsulta>0){
            consulta = GestaoUtentes.getInstance().getConsulta(idConsulta);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                analisar();


            }
        });

        spinner1= (Spinner)findViewById(R.id.cbOwasTorso);
        spinner2= (Spinner)findViewById(R.id.cbOwasBracos);
        spinner3= (Spinner)findViewById(R.id.cbOwasPernas);
        spinner4= (Spinner)findViewById(R.id.cbOwasForca);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                torso = position+1;
                ImageView image = (ImageView)findViewById(R.id.ivOwasTorso);
                switch (torso) {
                    case 1:
                        image.setImageResource(R.drawable.ic_owas_t1);
                        break;
                    case 2:
                        image.setImageResource(R.drawable.ic_owas_t2);
                        break;
                    case 3:
                        image.setImageResource(R.drawable.ic_owas_t3);
                        break;
                    case 4:
                        image.setImageResource(R.drawable.ic_owas_t4);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                bracos = position + 1;
                ImageView image = (ImageView) findViewById(R.id.ivOwasBracos);
                switch (bracos) {
                    case 1:
                        image.setImageResource(R.drawable.ic_owas_b1);
                        break;
                    case 2:
                        image.setImageResource(R.drawable.ic_owas_b2);
                        break;
                    case 3:
                        image.setImageResource(R.drawable.ic_owas_b3);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                pernas = position + 1;
                ImageView image = (ImageView) findViewById(R.id.ivOwasPernas);
                switch (pernas) {
                    case 1:
                        image.setImageResource(R.drawable.ic_owas_p1);
                        break;
                    case 2:
                        image.setImageResource(R.drawable.ic_owas_p2);
                        break;
                    case 3:
                        image.setImageResource(R.drawable.ic_owas_p3);
                        break;
                    case 4:
                        image.setImageResource(R.drawable.ic_owas_p4);
                        break;
                    case 5:
                        image.setImageResource(R.drawable.ic_owas_p5);
                        break;
                    case 6:
                        image.setImageResource(R.drawable.ic_owas_p6);
                        break;
                    case 7:
                        image.setImageResource(R.drawable.ic_owas_p7);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                forca = position + 1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void click(){



    }

    private void analisar()
    {

        TabelaReferenciaOWAS tab = new TabelaReferenciaOWAS();
        if (torso>0&&bracos>0&&pernas>0&&forca>0 ) {
            int resultado = tab.devolve(torso, bracos, pernas, forca);

            switch (resultado) {

                case 1:

                    resultadoString= getString(R.string.OwasResultado1);
                    break;
                case 2:

                    resultadoString= getString(R.string.OwasResultado2);
                    break;
                case 3:

                    resultadoString= getString(R.string.OwasResultado3);
                    break;
                case 4:

                    resultadoString= getString(R.string.OwasResultado4);
                    break;


            }

        }



        //GestaoUtentes.getInstance().addConsulta("OWAS");
        //Consulta consulta = GestaoUtentes.getInstance().getListaConsultas().get(1);

        ;//PARA TIRAR
        //RECEBE A CONSULTA E ADICIONA OS RESULTADOS

        TextView textViewTorso = (TextView)findViewById(R.id.tvOwasTorso);
        TextView textViewBracos = (TextView)findViewById(R.id.tvOwasBracos);
        TextView textViewPernas = (TextView)findViewById(R.id.tvOwasPernas);
        TextView textViewForca = (TextView)findViewById(R.id.tvOwasForca);

        resultadoTorso = new Resultado(textViewTorso.getText().toString()+":",torso+"- "+spinner1.getSelectedItem().toString());
        resultadoBracos = new Resultado(textViewBracos.getText().toString()+":",bracos+"- "+spinner2.getSelectedItem().toString());
        resultadoPernas = new Resultado(textViewPernas.getText().toString()+": ",+pernas+"- "+spinner3.getSelectedItem().toString());
        resultadoForça = new Resultado(textViewForca.getText().toString()+": ",+forca+"- "+spinner4.getSelectedItem().toString());
        resultadoFinal = new Resultado(getString(R.string.ResultadoAvaliacao)+"\n", resultadoString+"");

        consulta.addResultado(resultadoTorso);
        consulta.addResultado(resultadoBracos);
        consulta.addResultado(resultadoPernas);
        consulta.addResultado(resultadoForça);
        consulta.addResultado(resultadoFinal);


        if(consulta.getPessoa()!=null) {
            consulta.getPessoa().addConsulta(consulta);
        }


        consulta.setFerramenta("OWAS");

        Intent intent= new Intent(this,ActivityResultado.class);
        intent.putExtra("consulta", consulta);
        startActivity(intent);



        Intent returnIntent = new Intent();
        setResult(SistemaRebaActivity.RESULT_OK, returnIntent);
        finish();
    }




    }
