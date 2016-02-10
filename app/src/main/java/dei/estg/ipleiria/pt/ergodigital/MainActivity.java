package dei.estg.ipleiria.pt.ergodigital;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import dei.estg.ipleiria.pt.ergodigital.Model.GestaoUtentes;

public class MainActivity extends AppCompatActivity {

    private static final String BINARYFILE = "binaryfile.fin";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //addUtentes();
        lerInternamente();
        configuracoesUtilizador();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;



    }

    @Override
    protected void onStop() {
        super.onStop();
       guardarInternamente();

    }

    @Override
    protected void onDestroy() {
        guardarInternamente();
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        guardarInternamente();

    }

private void configuracoesUtilizador(){

    SharedPreferences mPrefs = getSharedPreferences("dados", 0);
    String nomeUtilizador = mPrefs.getString("nomeUtilizador", "");
    String mail = mPrefs.getString("mail", "");
    if (nomeUtilizador.equals("") && nomeUtilizador.equals("")){
        Intent intent = new Intent(this, UserSettingsActivity.class);
        startActivity(intent);
    }
}


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       if (id == R.id.action_userSettings) {
            Intent intent = new Intent(this,UserSettingsActivity.class);
            startActivity(intent);
            return true;
       }

           if (id == R.id.action_sobre) {
               Intent intent = new Intent(this,SobreActivity.class);
               startActivity(intent);
               return true;
           }


        return super.onOptionsItemSelected(item);
    }




    public void callAddUtentes(View view) {

        Intent intent = new Intent(this, DadosUtenteActivity.class);

        //startActivityForResult(intent, PICK_CONTACT_REQUEST);
        startActivity(intent);

        // Pessoa pessoa = (Pessoa)intent.getSerializableExtra("pessoa");




    }

    public void callAvaliacaoSRegisto(View view) {

        //Intent intent = new Intent(this, EscolhaAvaliacoesActivity.class);
        Intent intent = new Intent(this, DadosConsultaActivity.class);
        startActivity(intent);
    }




    public void callListaUtentes(View view) {

        Intent intent = new Intent(this, ListaPessoasActivity.class);
        startActivity(intent);

    }

    public void callGuardar(View view) {

        guardarInternamente();
    }


    public void callLer(View view) {


        lerInternamente();
    }

    public void callListaConsultas(View view) {


        Intent intent = new Intent(this, ActivityResultado.class);
        intent.putExtra("consultas",GestaoUtentes.getInstance().getListaConsultas());
        startActivity(intent);
    }





    private void lerInternamente() {


        FileInputStream input = null;
        ObjectInputStream inpStream = null;
        try {
            input = openFileInput(BINARYFILE);
            inpStream = new ObjectInputStream(input);

            GestaoUtentes.setInstance((GestaoUtentes)inpStream.readObject());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    private void guardarInternamente() {
        FileOutputStream output = null;
        ObjectOutputStream outStream = null;
        try {
            GestaoUtentes gestaoUtentes = GestaoUtentes.getInstance();
            output = openFileOutput(BINARYFILE, Context.MODE_PRIVATE);
            outStream = new ObjectOutputStream(output);
            outStream.writeObject(gestaoUtentes);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Ficheiro nao encontrado ",
                    Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outStream != null)
                    outStream.close();
                if (output != null)
                    output.close();// se os favoritos estiver vazio ou der erro
                // ao tentar fechar, então lança uma
                // execepção
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(),
                        "Ocorreu um erro ao terminar o ficheiro",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }


}
