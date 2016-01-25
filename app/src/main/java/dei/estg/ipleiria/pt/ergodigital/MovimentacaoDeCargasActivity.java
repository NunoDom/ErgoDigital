package dei.estg.ipleiria.pt.ergodigital;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MovimentacaoDeCargasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movimentacao_de_cargas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
        startActivity(intent);

    }

    public void callMACActivity(View view){

        Intent intent = new Intent(this, SistemaMacMainActivity.class);
        startActivity(intent);

    }


}
