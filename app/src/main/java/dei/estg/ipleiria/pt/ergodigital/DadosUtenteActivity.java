package dei.estg.ipleiria.pt.ergodigital;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import dei.estg.ipleiria.pt.ergodigital.Model.Consulta;
import dei.estg.ipleiria.pt.ergodigital.Model.GestaoUtentes;
import dei.estg.ipleiria.pt.ergodigital.Model.Pessoa;

public class DadosUtenteActivity extends AppCompatActivity {

    DateFormat formate;
    Button botaoGuardar;
    Button botaoEditar;
    Button botaoSelecionar;
    Button botaoApagar;
    Button botaoAdicionar;
    Button botaoHistoricoUtente;

    Pessoa pessoa;
    EditText editTextName;
    EditText editTextData;
    EditText editTextAltura;
    EditText editTextPeso;
    Spinner spinnerGenero;
    DatePickerDialog.OnDateSetListener d;
    int tipo=0;

    Calendar calender=Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_utente);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        formate = DateFormat.getDateInstance();
        editTextName = (EditText)findViewById(R.id.editTextUtenteNome);
        editTextData= (EditText)findViewById(R.id.editTextUtenteData);
        editTextAltura= (EditText)findViewById(R.id.editTextUtenteAltura);
        editTextPeso= (EditText)findViewById(R.id.editTextUtentePeso);
        spinnerGenero = (Spinner)findViewById(R.id.cbUtenteGenero);
        botaoGuardar=(Button)findViewById(R.id.bntDadosPessoaGuardar);
        botaoEditar=(Button)findViewById(R.id.bntDadosPessoaEditar);
        botaoSelecionar=(Button)findViewById(R.id.bntDadosPessoaRealizarAvaliacao);
        botaoApagar=(Button)findViewById(R.id.bntDadosPessoaApagar);
        botaoAdicionar=(Button)findViewById(R.id.bntDadosPessoaAdicionar);
        botaoHistoricoUtente=(Button)findViewById(R.id.btnDadosPessoaHistoricoConsultas);
        spinnerGenero.setEnabled(false);



        if (getIntent().hasExtra("pessoa")) { //EDITAR
            Bundle extras = getIntent().getExtras();
            pessoa = (Pessoa)extras.getSerializable("pessoa");
            preencherCampos(pessoa);
            tipo=1;
            botaoEditar.setVisibility(View.VISIBLE);
            botaoSelecionar.setVisibility(View.VISIBLE);
            botaoApagar.setVisibility(View.VISIBLE);
            botaoHistoricoUtente.setVisibility(View.VISIBLE);
        }else
        {
            desloquearCampos();
            botaoAdicionar.setVisibility(View.VISIBLE);
        }


        d = new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                GregorianCalendar data = new GregorianCalendar(year,monthOfYear,dayOfMonth);
                Date date=data.getTime();
                calender.setTime(date);

                editTextData.setText(formate.format(calender.getTime()));
            }
        };


        editTextData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog p = new DatePickerDialog(DadosUtenteActivity.this, d, calender.get(Calendar.YEAR), calender.get(Calendar.MONTH), calender.get(Calendar.DAY_OF_MONTH));
                p.setTitle("Selecione a data:");
                p.show();

            }
        });











        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void preencherCampos(Pessoa pessoa) {

        editTextName.setText(pessoa.getName());
        editTextAltura.setText(pessoa.getAltura()+"");
        editTextPeso.setText(pessoa.getPeso() + "");
        spinnerGenero.setSelection(pessoa.getGenero());
        calender.setTime(pessoa.getDataNascimento());
        editTextData.setText(formate.format(calender.getTime()));



    }


    public void clickAdicionar(View view) {
        seguinte();

    }


    private boolean seguinte()
    {

        try {
            String nome = editTextName.getText().toString();
            Integer genero = spinnerGenero.getSelectedItemPosition();
            int altura = Integer.parseInt(editTextAltura.getText().toString());
            int peso = Integer.parseInt(editTextPeso.getText().toString());

            final Calendar c = Calendar.getInstance();
            int ano = calender.get(Calendar.YEAR);
            int mes = calender.get(Calendar.MONTH) + 1;
            int dia = calender.get(Calendar.DAY_OF_MONTH);

            Calendar newCalender = Calendar.getInstance();
            int anoSistema = newCalender.get(Calendar.YEAR);

            if (ano < 1900 || ano > anoSistema) {
                Toast.makeText(this, "Ano Invalido", Toast.LENGTH_SHORT).show();
            } else {
                if (mes < 1 || mes > 12) {
                    Toast.makeText(this, "Mês Inválido", Toast.LENGTH_SHORT).show();
                } else {
                    if (dia < 1 || dia > 31) {
                        Toast.makeText(this, "Dia invalido", Toast.LENGTH_SHORT).show();
                    } else {

                        if ((altura < 50 || altura > 250)) {
                            Toast.makeText(this, "Altura invalida", Toast.LENGTH_SHORT).show();
                        } else {
                            if (peso < 10 || peso > 500) {

                            } else {
                                if ((spinnerGenero.getSelectedItemPosition() - 1) < 0) {
                                    Toast.makeText(this, "Selecione um genero", Toast.LENGTH_SHORT).show();

                                } else {
                                    Date date = calender.getTime();
                                    if (tipo == 0) {//ADICIONAR
                                        GestaoUtentes.getInstance().addPessoa(nome, date, genero, altura, peso);
                                        Toast.makeText(this, "Utente adicionado com sucesso ", Toast.LENGTH_SHORT).show();
                                        this.finish();
                                        return true;
                                    } else{//EDITAR
                                        GestaoUtentes.getInstance().alterarPessoa(pessoa.getId(), nome, date, genero, altura, peso);
                                        Toast.makeText(this, "Utente alterado com sucesso ", Toast.LENGTH_SHORT).show();
                                        this.finish();
                                        return true;

                                    }


                                }

                            }
                        }
                    }
                }
            }

        } catch (Exception ex) {
            Toast toast = Toast.makeText(this,"Preencha todos os campos", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            return false;
        }
        return false;
    }



    public void desloquearCampos()
    {
        editTextName.setEnabled(true);
        editTextAltura.setEnabled(true);
        editTextPeso.setEnabled(true);
        spinnerGenero.setClickable(true);
        editTextData.setEnabled(true);
        spinnerGenero.setEnabled(true);

    }


    public void clickGuardar(View view)
    {
        if(seguinte()) {
            botaoGuardar.setVisibility(View.GONE);
            botaoEditar.setVisibility(View.VISIBLE);
            botaoSelecionar.setVisibility(View.VISIBLE);
            botaoApagar.setVisibility(View.VISIBLE);
        }
    }


    public void editarUtente(View view)
    {
        desloquearCampos();
        botaoGuardar.setVisibility(View.VISIBLE);
        botaoEditar.setVisibility(View.GONE);
        botaoSelecionar.setVisibility(View.GONE);
        botaoApagar.setVisibility(View.GONE);

    }


    public void apagarUtente(View view)
    {

        if(GestaoUtentes.getInstance().removerPessoa(pessoa.getId()))
        {
            Toast.makeText(this, "Utente apagado com Sucesso", Toast.LENGTH_SHORT).show();
            finish();
        }else
        {
            Toast.makeText(this, "Erro ao tentar apagar utente", Toast.LENGTH_SHORT).show();
        }


    }


public void realizarAvaliacao(View view){
    Intent intent = new Intent(this, DadosConsultaActivity.class);

    SharedPreferences mPrefs = getSharedPreferences("dados", 0);
    SharedPreferences.Editor editor = mPrefs.edit();
    editor.putInt("idUtente", pessoa.getId());
    editor.commit();
    startActivity(intent);
    finish();

}

    public void btnClickHistoricoConsultas(View view)
    {
        Intent intent = new Intent(this, ActivityResultado.class);
        ArrayList<Consulta> consultas = pessoa.getConsultas();
        intent.putExtra("consultas",consultas);
        startActivity(intent);
    }



}
