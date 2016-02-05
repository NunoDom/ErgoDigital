package dei.estg.ipleiria.pt.ergodigital;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import dei.estg.ipleiria.pt.ergodigital.Model.Consulta;

public class SistemaKimMainActivity extends AppCompatActivity {

    Consulta consulta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_kim_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        if (getIntent().hasExtra("consulta")) {
            Bundle extras = getIntent().getExtras();
            consulta = (Consulta)extras.getSerializable("consulta");
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    public void callKim_LevantarActivity(View view){

        Intent intent = new Intent(this, SistemaKimLevantarActivity.class);
        intent.putExtra("consulta",consulta);
        startActivity(intent);

    }

    public void callKimEmpurarActivity(View view){

        Intent intent = new Intent(this, SistemaKimEmpurrarActivity.class);
        intent.putExtra("consulta",consulta);
        startActivity(intent);

    }

}
