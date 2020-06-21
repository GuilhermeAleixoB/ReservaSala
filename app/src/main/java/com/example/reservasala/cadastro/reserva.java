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

import com.example.reservasala.Controller.equipController;
import com.example.reservasala.Controller.reservaController;
import com.example.reservasala.MainActivity;
import com.example.reservasala.R;
import com.example.reservasala.lista.equipSalas;

public class reserva extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservasala);
        ActionBar bar = getSupportActionBar();
        bar.setTitle("RESERVA");
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#5F9EA0")));
    }

    @Override
    public void onClick(View v) {
        cadastrar();
    }

    public void cadastrar(){
        Button botao = (Button)findViewById(R.id.btnReservar);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reservaController crud = new reservaController(getBaseContext());
                EditText nome = (EditText)findViewById((R.id.txtNome));
                EditText data = (EditText)findViewById(R.id.txtData);
                EditText sala = (EditText)findViewById(R.id.txtSala);
                String nomeString = nome.getText().toString();
                String dataString = data.getText().toString();
                String salaString = sala.getText().toString();
                String resultado;

                resultado = crud.insereDado(nomeString, dataString, salaString);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void voltar(View view){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void equipSala(View view){

        Intent intent = new Intent(this, equipSalas.class);
        startActivity(intent);

    }

}