package com.example.reservasala;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.reservasala.R;

public class cadastroSala extends Activity implements View.OnClickListener {

    Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrosala);


    }

    @Override
    public void onClick(View v) {
        cadastrar();
    }

    public void cadastrar(){
        Button botao = (Button)findViewById(R.id.btnCadastrar);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salaController crud = new salaController(getBaseContext());
                EditText nSala = (EditText)findViewById((R.id.txtNumsala));
                EditText infoSala = (EditText)findViewById(R.id.txtInfosala);
                String nSalaString = nSala.getText().toString();
                String infoSalaString = infoSala.getText().toString();
                String resultado;

                resultado = crud.insereDado(nSalaString, infoSalaString);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void voltar(View view){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }


}
