package dei.estg.ipleiria.pt.ergodigital;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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



        if (getIntent().hasExtra("consulta")) {
            Bundle extras = getIntent().getExtras();
            consulta = (Consulta)extras.getSerializable("consulta");
        }


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            if (requestCode == 1) {
                if(resultCode == Activity.RESULT_OK){
                    Intent returnIntent = new Intent();
                    setResult(MovimentacaoDeCargasActivity.RESULT_OK, returnIntent);
                    finish();
                }
            }

    }

    public void callMacElevacaoActivity(View view){

        Intent intent = new Intent(this, SistemaMacElevacaoActivity.class);
        startActivityForResult(intent, 1);

    }

    public void callMacTransporteActivity(View view){

        Intent intent = new Intent(this, SistemaMacTransporteActivity.class);
        startActivityForResult(intent, 1);

    }

    public void callMacEquipaActivity(View view){

        Intent intent = new Intent(this, SistemaMacEquipaActivity.class);
        startActivityForResult(intent,1);

    }
}
