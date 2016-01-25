package dei.estg.ipleiria.pt.ergodigital;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;

import dei.estg.ipleiria.pt.ergodigital.Model.GerirPessoas;
import dei.estg.ipleiria.pt.ergodigital.Model.Pessoa;

public class MainActivity extends AppCompatActivity {

    static final int PICK_CONTACT_REQUEST = 1;  // The request code
    private static final String BINARYFILE = "BINARYFILE.fin";
    GerirPessoas gerir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        addUtentes();
        //gerir.setListaPessoas(lerInternamente());
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
     //   guardarInternamente();

    }

    @Override
    protected void onDestroy() {
        //guardarInternamente();
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
       // guardarInternamente();

    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this,ListaPessoasActivity.class);
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




    }       //gerir.addPessoa(pessoa);
    public void addUtentes() {

        gerir.INSTANCE.addPessoa(new Pessoa("Nuno Domingues",12,05,1989,0,170,85));
        gerir.INSTANCE.addPessoa(new Pessoa("Tiago Pinto",01,01,1989,0,180,95));


    }




    public void callListaUtentes(View view) {

        Intent intent = new Intent(this, ListaPessoasActivity.class);
        startActivity(intent);

    }

    public void callGuardar(View view) {


        ArrayList<Pessoa> posss = gerir.INSTANCE.getListaPessoas();
        guardarInternamente(posss);
    }


    public void callLer(View view) {


        gerir.INSTANCE.setListaPessoas(lerInternamente());
    }


    private ArrayList<Pessoa> lerInternamente() {

        ArrayList<Pessoa> lista=null;
        FileInputStream input = null;
        ObjectInputStream inpStream = null;
        try {
            input = openFileInput(BINARYFILE);
            inpStream = new ObjectInputStream(input);

             lista= (ArrayList<Pessoa>) inpStream.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return lista;
    }


    private void guardarInternamente( ArrayList<Pessoa> lista) {
        FileOutputStream output = null;
        ObjectOutputStream outStream = null;
        try {
            output = openFileOutput(BINARYFILE, Context.MODE_PRIVATE);
            outStream = new ObjectOutputStream(output);
            outStream.writeObject(lista);

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
