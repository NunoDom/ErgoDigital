package dei.estg.ipleiria.pt.ergodigital;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class UserSettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        carregarDados();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }





    private void carregarDados()
    {
        SharedPreferences sharedPref = getSharedPreferences("dados", 0);;
        String mailPref = sharedPref.getString("mail", "");
        String nomePref = sharedPref.getString("nomeUtilizador", "");

        if(!(mailPref.equals("") && nomePref.equals(""))){
            ((TextView)findViewById(R.id.textViewUserSettingNome)).setText(nomePref);
            ((TextView)findViewById(R.id.textViewUserSettingMail)).setText(mailPref);
            }


    }


    public void clickGuardar(View view)
    {
/*
        SharedPreferences mPrefs = getSharedPreferences("dados", 0);
        SharedPreferences.Editor editor2 = mPrefs.edit();
        editor2.putString("test", "yes");
        editor2.commit();*/

        SharedPreferences sharedPref = getSharedPreferences("dados", 0);
        SharedPreferences.Editor editor = sharedPref.edit();
        String mail = ((TextView)findViewById(R.id.textViewUserSettingMail)).getText().toString();
        String nomeUtilizador = ((TextView)findViewById(R.id.textViewUserSettingNome)).getText().toString();
        editor.putString("mail", mail);
        editor.putString("nomeUtilizador", nomeUtilizador);
        editor.commit();
        Toast.makeText(this,"Dados gravados com sucesso",Toast.LENGTH_SHORT).show();
        finish();
    }
}
