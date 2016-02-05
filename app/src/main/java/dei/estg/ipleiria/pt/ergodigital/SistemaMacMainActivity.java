package dei.estg.ipleiria.pt.ergodigital;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import dei.estg.ipleiria.pt.ergodigital.Model.Consulta;

public class SistemaMacMainActivity extends AppCompatActivity {

    Consulta consulta;
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


        if (getIntent().hasExtra("consulta")) {
            Bundle extras = getIntent().getExtras();
            consulta = (Consulta)extras.getSerializable("consulta");
        }


    }




    public void callMacElevacaoActivity(View view){

        Intent intent = new Intent(this, SistemaMacElevacaoActivity.class);
        intent.putExtra("consulta",consulta);
        startActivity(intent);

    }

    public void callMacTransporteActivity(View view){

        Intent intent = new Intent(this, SistemaMacTransporteActivity.class);
        intent.putExtra("consulta",consulta);
        startActivity(intent);

    }

    public void callMacEquipaActivity(View view){

        Intent intent = new Intent(this, SistemaMacEquipaActivity.class);
        intent.putExtra("consulta",consulta);
        startActivity(intent);

    }
}
