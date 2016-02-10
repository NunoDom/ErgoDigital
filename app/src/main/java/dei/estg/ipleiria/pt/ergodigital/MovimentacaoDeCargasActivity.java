package dei.estg.ipleiria.pt.ergodigital;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import dei.estg.ipleiria.pt.ergodigital.Model.Consulta;

public class MovimentacaoDeCargasActivity extends AppCompatActivity {

    Consulta consulta;
    int idUtente=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movimentacao_de_cargas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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

    public void callKIMActivity(View view){
        
        Intent intent = new Intent(this, SistemaKimMainActivity.class);
        startActivityForResult(intent, 1);

    }

    public void callMACActivity(View view){

        Intent intent = new Intent(this, SistemaMacMainActivity.class);
        startActivityForResult(intent, 1);

    }


}
