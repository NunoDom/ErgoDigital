package dei.estg.ipleiria.pt.ergodigital;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import dei.estg.ipleiria.pt.ergodigital.TabelasDeReferencia.TabelaReferenciaOWAS;

public class SistemaOwasActivity extends AppCompatActivity {

    private int torso;
    private int bracos;
    private int pernas;
    private int forca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_owas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);











        Spinner spinner1= (Spinner)findViewById(R.id.cbTorso);
        Spinner spinner2= (Spinner)findViewById(R.id.cbBracos);
        Spinner spinner3= (Spinner)findViewById(R.id.cbPernas);
        Spinner spinner4= (Spinner)findViewById(R.id.cbForca);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                torso = position+1;
                ImageView image = (ImageView)findViewById(R.id.ivTorso);
                switch (torso) {
                    case 1:
                        image.setImageResource(R.drawable.ic_t1);
                        break;
                    case 2:
                        image.setImageResource(R.drawable.ic_t2);
                        break;
                    case 3:
                        image.setImageResource(R.drawable.ic_t3);
                        break;
                    case 4:
                        image.setImageResource(R.drawable.ic_t4);
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
                ImageView image = (ImageView) findViewById(R.id.ivBracos);
                switch (bracos) {
                    case 1:
                        image.setImageResource(R.drawable.ic_b1);
                        break;
                    case 2:
                        image.setImageResource(R.drawable.ic_b2);
                        break;
                    case 3:
                        image.setImageResource(R.drawable.ic_b3);
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
                ImageView image = (ImageView) findViewById(R.id.ivPernas);
                switch (pernas) {
                    case 1:
                        image.setImageResource(R.drawable.ic_p1);
                        break;
                    case 2:
                        image.setImageResource(R.drawable.ic_p2);
                        break;
                    case 3:
                        image.setImageResource(R.drawable.ic_p3);
                        break;
                    case 4:
                        image.setImageResource(R.drawable.ic_p4);
                        break;
                    case 5:
                        image.setImageResource(R.drawable.ic_p5);
                        break;
                    case 6:
                        image.setImageResource(R.drawable.ic_p6);
                        break;
                    case 7:
                        image.setImageResource(R.drawable.ic_p7);
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
                //ImageView image1 = (ImageView) findViewById(R.id.ivracos);
                /*switch (forca) {
                    case 1:
                        image1.setImageResource(R.drawable.ic_p1);
                        break;
                    case 2:
                        image1.setImageResource(R.drawable.ic_p2);
                        break;
                    case 3:
                        image1.setImageResource(R.drawable.ic_p3);
                        break;
                }*/
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void click(View view){

        TabelaReferenciaOWAS tab = new TabelaReferenciaOWAS();
        if (torso>0&&bracos>0&&pernas>0&&forca>0 ) {
            int resultado = tab.devolve(torso, bracos, pernas, forca);

            switch (resultado) {

                case 1:


                    Toast.makeText(getApplicationContext(), "resultado = 1, Não necessita de medidas correctivas",
                            Toast.LENGTH_SHORT).show();
                    break;
                case 2:

                    Toast.makeText(getApplicationContext(), "resultado = 2, São necessarias medidas correctivas em um futuro proximo",
                            Toast.LENGTH_SHORT).show();
                    break;
                case 3:

                    Toast.makeText(getApplicationContext(), "resultado = 3, São necessarias medidas correctivas quanto possivel",
                            Toast.LENGTH_SHORT).show();
                    break;
                case 4:

                    Toast.makeText(getApplicationContext(), "resultado = 4,  São necessarias medidas correctivas imediatas",
                            Toast.LENGTH_SHORT).show();
                    break;


            }

        }

    }



    }
