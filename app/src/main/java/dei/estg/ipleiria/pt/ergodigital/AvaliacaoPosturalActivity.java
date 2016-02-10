package dei.estg.ipleiria.pt.ergodigital;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class AvaliacaoPosturalActivity extends AppCompatActivity {

    //Consulta consulta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliacao_postural);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);

}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                Intent returnIntent = new Intent();
                setResult(EscolhaAvaliacoesActivity.RESULT_OK, returnIntent);
                finish();
            }
        }
    }

    public void callOWAS(View view){

        Intent intent = new Intent(this,SistemaOwasActivity.class);
        startActivityForResult(intent, 1);
    }
    public void callRULA(View view){

        Intent intent = new Intent(this,SistemaRulaActivity.class);
        startActivityForResult(intent, 1);
    }
    public void callREBA(View view){

        Intent intent = new Intent(this,SistemaRebaActivity.class);
        startActivityForResult(intent, 1);
    }
}
