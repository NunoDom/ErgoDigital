package dei.estg.ipleiria.pt.ergodigital;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import dei.estg.ipleiria.pt.ergodigital.Model.Consulta;

public class EscolhaAvaliacoesActivity extends AppCompatActivity {

    Consulta consulta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolha_avaliacoes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                finish();
            }
        }
    }

    public void callAPActivity(View view) {

        Intent intent = new Intent(this, AvaliacaoPosturalActivity.class);
        //intent.putExtra("consulta",consulta);
        startActivityForResult(intent,1);

    }

    public void callMCActivity(View view) {

        Intent intent = new Intent(this, MovimentacaoDeCargasActivity.class);
        //intent.putExtra("consulta",consulta);
        startActivityForResult(intent,1);


    }
}
