package dei.estg.ipleiria.pt.ergodigital;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class UserSettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //carregarDados();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }





    private void carregarDados()
    {
        SharedPreferences sharedPref = UserSettingsActivity.this.getPreferences(Context.MODE_PRIVATE);
        String mailPref = sharedPref.getString("mail", "");
        String nomePref = sharedPref.getString("nomeUtilizador", "");

        if(mailPref.equals("") || nomePref.equals("")){


            Bundle extras = getIntent().getExtras();
            String mail = extras.getString("mail");
            String nomeUtilizador = extras.getString("nomeUtilizador");
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("mail", mail);
            editor.putString("mail", nomeUtilizador);
            editor.commit();
        }
    }
}
