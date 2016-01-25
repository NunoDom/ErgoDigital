package dei.estg.ipleiria.pt.ergodigital;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class SistemaMacMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_mac_main);
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
    }




    public void callMacElevacaoActivity(View view){

        Intent intent = new Intent(this, SistemaMacElevacaoActivity.class);
        startActivity(intent);

    }

    public void callMacTransporteActivity(View view){

        Intent intent = new Intent(this, SistemaMacTransporteActivity.class);
        startActivity(intent);

    }

    public void callMacEquipaActivity(View view){

        Intent intent = new Intent(this, SistemaMacEquipaActivity.class);
        startActivity(intent);

    }
}
