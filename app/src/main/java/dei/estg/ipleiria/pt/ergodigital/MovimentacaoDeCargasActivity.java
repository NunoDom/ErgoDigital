package dei.estg.ipleiria.pt.ergodigital;

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


        if (getIntent().hasExtra("consulta")) {
            Bundle extras = getIntent().getExtras();
            consulta = (Consulta)extras.getSerializable("consulta");
        }

    //    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    //    fab.setOnClickListener(new View.OnClickListener() {
    //        @Override
    //        public void onClick(View view) {
    //            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
    //                    .setAction("Action", null).show();
    //        }
    //    });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void callKIMActivity(View view){
        
        Intent intent = new Intent(this, SistemaKimMainActivity.class);
        intent.putExtra("consulta",consulta);
        startActivity(intent);

    }

    public void callMACActivity(View view){

        Intent intent = new Intent(this, SistemaMacMainActivity.class);
        intent.putExtra("consulta",consulta);
        startActivity(intent);

    }


}
