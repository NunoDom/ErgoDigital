package dei.estg.ipleiria.pt.ergodigital;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.print.PrintAttributes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;

import dei.estg.ipleiria.pt.ergodigital.Model.Consulta;
import dei.estg.ipleiria.pt.ergodigital.Model.Resultado;

public class ActivityResultado extends AppCompatActivity {
    ListView listView;
    Consulta consulta;
    ArrayList<Consulta> consultas;
    Resultado resultado;
    private OutputStream os;
    ArrayList<Resultado> resultados = new ArrayList<>();
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
        editor.putInt("idConsulta", -1);
        editor.commit();
        listView = (ListView) findViewById(R.id.listViewResultados);
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
            setTitle(consulta.getFerramenta());
            id=2;

        }
        if (intent.hasExtra("resultado")) {//se receber 1 consulta, mostra os resultados das consultas
            Bundle extras = getIntent().getExtras();
            resultado = (Resultado)extras.getSerializable("resultado");
            id=3;
        }
        updateAdaptador(id);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long idt) {

        switch(id)
        {
            case 1:
                Consulta consultaLocal = consultas.get(position);
                if((consultaLocal!= null) && (consultaLocal.getFerramenta()!=null)) {
                    if (consultaLocal.getFerramenta().equals("MAC")) {
                        Intent intent1 = new Intent(ActivityResultado.this, SistemaMacElevacaoResultActivity.class);
                        intent1.putExtra("consulta", consultaLocal);
                        startActivity(intent1);
                        finish();

                    }
                }
                break;
        }
    }
});


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        if(id==2) {
            getMenuInflater().inflate(R.menu.menu_resultados, menu);
        }
        return true;



    }



    @Override
    protected void onPause() {
        //Intent intent= new Intent(this,MainActivity.class);
        getIntent().removeExtra("consultas");
        getIntent().removeExtra("consulta");
        getIntent().removeExtra("resultado");
       finish();

        super.onPause();
    }

    private void updateAdaptador(int id) {


        listView.setAdapter(null);
        ArrayAdapter<?> adapter = null;
        switch(id){
            case 0://NADA
                listView.setAdapter(null);
                break;
            case 1://ADAPTADOR TODAS AS CONSULTAS
            //ArrayList<Consulta> consultas = new ArrayList<>(GestaoUtentes.getInstance().getListaConsultas());
            adapter = new ArrayAdapter<Consulta>(ActivityResultado.this, android.R.layout.simple_list_item_1, consultas);
            listView.setAdapter(adapter);
                break;

            case 2://ADAPTADOR RESULTADO DA AVALIZACAO, RECEBE UMA CONSULTA E MOSTRA TODOS OS RESULTADOS
                ArrayAdapter<?> adapter2 = null;
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



    public void createPDF() throws IOException {
        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/PDF";

        File dir = new File(path);
        if (!dir.exists())
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
        ViewGroup container = (ViewGroup) findViewById(R.id.layoutResultados);

        for (int i = 0; i < container.getChildCount(); i++) {
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

        Calendar c= Calendar.getInstance();
        File file = new File(path, "filename" + consulta.getId()+"-"+consulta.getFerramenta().toString()+c.getTime().toString() + ".pdf");
        os = new FileOutputStream(file);
        document.writeTo(os);
        document.close();
        os.close();

        // close the document
        document.close();
    }



    private void sendEmail(){

        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        String mailPref = sharedPref.getString("mail", "");
        if(mailPref.equals("")){
            Toast.makeText(this, "Defina primeiro o mail", Toast.LENGTH_LONG).show();
        }else {
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
            emailIntent.setData(Uri.parse("mailto:" + mailPref));
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Relatório OWAS");
            //emailIntent.putExtra(Intent.EXTRA_TEXT, "" + resultadoTorso + resultadoBracos + resultadoPernas + resultadoForça + resultadoFinal);

            try {
                startActivity(Intent.createChooser(emailIntent, "Send email using..."));
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(ActivityResultado.this, "No email clients installed.", Toast.LENGTH_SHORT).show();
            }
        }
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.submenu1) {
            try {
                createPDF();

            } catch (IOException e) {
                return false;
            }
            return true;
        }

            if (id == R.id.submenu2) {
                sendEmail();
                return true;
            }



        return super.onOptionsItemSelected(item);
    }



}
