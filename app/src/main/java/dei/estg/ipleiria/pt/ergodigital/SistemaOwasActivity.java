package dei.estg.ipleiria.pt.ergodigital;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.print.PrintAttributes;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

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

    private OutputStream os;



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


        //if (getIntent().hasExtra("consulta")) {
        //    Bundle extras = getIntent().getExtras();
        //    consulta = (Consulta)extras.getSerializable("consulta");
       // }

        SharedPreferences mPrefs = getSharedPreferences("dados", 0);
        int idConsulta = mPrefs.getInt("idConsulta", -1);

        if (idConsulta>0){
            consulta = GestaoUtentes.getInstance().getConsulta(idConsulta);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                click(view);

            }
        });

        spinner1= (Spinner)findViewById(R.id.cbTorso);
        spinner2= (Spinner)findViewById(R.id.cbBracos);
        spinner3= (Spinner)findViewById(R.id.cbPernas);
        spinner4= (Spinner)findViewById(R.id.cbForca);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                torso = position+1;
                ImageView image = (ImageView)findViewById(R.id.ivTorso);
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
                ImageView image = (ImageView) findViewById(R.id.ivBracos);
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
                ImageView image = (ImageView) findViewById(R.id.ivPernas);
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
                    resultadoString="Não necessita de medidas correctivas";
                    break;
                case 2:

                    Toast.makeText(getApplicationContext(), "resultado = 2, São necessarias medidas correctivas em um futuro proximo",
                            Toast.LENGTH_SHORT).show();
                    resultadoString="São necessarias medidas correctivas em um futuro proximo";
                    break;
                case 3:

                    Toast.makeText(getApplicationContext(), "resultado = 3, São necessarias medidas correctivas quanto possivel",
                            Toast.LENGTH_SHORT).show();
                    resultadoString="São necessarias medidas correctivas quanto possivel";
                    break;
                case 4:

                    Toast.makeText(getApplicationContext(), "resultado = 4,  São necessarias medidas correctivas imediatas",
                            Toast.LENGTH_SHORT).show();
                    resultadoString="São necessarias medidas correctivas imediatas";
                    break;


            }

        }

    }





public void createPDF() throws IOException {
    String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/PDF";

    File dir = new File(path);
    if(!dir.exists())
        dir.mkdirs();

    PrintAttributes printAttrs = new PrintAttributes.Builder().
            setColorMode(PrintAttributes.COLOR_MODE_COLOR).
            setMediaSize(PrintAttributes.MediaSize.ISO_A4).
            setResolution(new PrintAttributes.Resolution("zooey", PRINT_SERVICE, 450, 700)).
            setMinMargins(PrintAttributes.Margins.NO_MARGINS).
            build();

    // create a new document
    //PdfDocument document = new PrintedPdfDocument(SistemaOwasActivity.this,printAttrs);
    PdfDocument document = new PdfDocument();
    // crate a page description
    //PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(450, 700, 1).create();

    // start a page
    //PdfDocument.Page page = document.startPage(pageInfo);

    // draw something on the page

    // repaint the user's text into the page
    /*
    if (page != null) {
        //TextView textViewTest = new TextView(getApplicationContext());


        View view = findViewById(R.id.layoutOWAS);//getContentView();
        view.layout(0, 0, view.getWidth(),view.getHeight());
        Log.i("draw view", " content size: " + view.getWidth() + " / " + view.getHeight());
        view.draw(page.getCanvas());
        // Move the canvas for the next view.
        page.getCanvas().translate(0, view.getHeight());
    }*/
    ViewGroup container = (ViewGroup)findViewById(R.id.layoutOWAS);

    for(int i=0;i<container.getChildCount();i++){
        View v = container.getChildAt(i);
        PdfDocument.PageInfo.Builder pageBuilder = new PdfDocument.PageInfo.Builder(v.getWidth(), v.getHeight(), i);
        PdfDocument.Page page = document.startPage(pageBuilder.create());
        v.draw(page.getCanvas());
        document.finishPage(page);
    }



    //View v = layout.draw();
    //View content =findViewById(R.id.layoutOWAS);
    //content.draw(page.getCanvas());
    //layout.draw(page.getCanvas());


    // finish the page
    //document.finishPage(page);
    File file = new File(path, "filename"+System.currentTimeMillis()+".pdf");
    os = new FileOutputStream(file);
    document.writeTo(os);
    document.close();
    os.close();

    // close the document
    document.close();



}


    public void click2(View view)
    {   click(view);
        clickResultado();
        /*try {
            createPDF();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }




    private void clickResultado()
    {
        //GestaoUtentes.getInstance().addConsulta("OWAS");
        //Consulta consulta = GestaoUtentes.getInstance().getListaConsultas().get(1);

        ;//PARA TIRAR
        //RECEBE A CONSULTA E ADICIONA OS RESULTADOS


        resultadoTorso = new Resultado("Torso:",torso+"- "+spinner1.getSelectedItem().toString());
        resultadoBracos = new Resultado("Bracos:",bracos+"- "+spinner2.getSelectedItem().toString());
        resultadoPernas = new Resultado("Pernas: ",+pernas+"- "+spinner3.getSelectedItem().toString());
        resultadoForça = new Resultado("Força: ",+forca+"- "+spinner4.getSelectedItem().toString());
        resultadoFinal = new Resultado("Resultado da Avaliação \n", resultadoString+"");

        consulta.addResultado(resultadoTorso);
        consulta.addResultado(resultadoBracos);
        consulta.addResultado(resultadoPernas);
        consulta.addResultado(resultadoForça);
        consulta.addResultado(resultadoFinal);


        if(consulta.getPessoa()!=null) {
            consulta.getPessoa().addConsulta(consulta);
        }



        Intent intent= new Intent(this,ActivityResultado.class);
        intent.putExtra("consulta",consulta);
        startActivity(intent);
        finish();
    }

    private void sendEmail(View view){

        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        String mailPref = sharedPref.getString("mail", "");
if(mailPref.equals("")){
    Toast.makeText(this,"Defina primeiro o mail",Toast.LENGTH_LONG).show();
}else {
    Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
    emailIntent.setData(Uri.parse("mailto:" + mailPref));
    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Relatório OWAS");
    emailIntent.putExtra(Intent.EXTRA_TEXT, "" + resultadoTorso + resultadoBracos + resultadoPernas + resultadoForça + resultadoFinal);

    try {
        startActivity(Intent.createChooser(emailIntent, "Send email using..."));
    } catch (android.content.ActivityNotFoundException ex) {
        Toast.makeText(SistemaOwasActivity.this, "No email clients installed.", Toast.LENGTH_SHORT).show();
    }
}
    }



    }
