package com.example.reservasala.cadastro;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.reservasala.Controller.salaController;
import com.example.reservasala.MainActivity;
import com.example.reservasala.R;

public class cadastroSala extends AppCompatActivity implements View.OnClickListener {

    Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrosala);
        ActionBar bar = getSupportActionBar();
        bar.setTitle("CADASTRO DE SALA");
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#5F9EA0")));
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
