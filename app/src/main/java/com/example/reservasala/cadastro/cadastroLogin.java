package com.example.reservasala.cadastro;

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

import com.example.reservasala.Controller.cadastroController;
import com.example.reservasala.MainActivity;
import com.example.reservasala.R;
import com.example.reservasala.login;

public class cadastroLogin extends AppCompatActivity {

    Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        ActionBar bar = getSupportActionBar();
        bar.setTitle("CADASTRO");
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#5F9EA0")));
    }

    public void cadastrar(View view) {
                cadastroController crud = new cadastroController(getBaseContext());
                EditText nome = (EditText) findViewById(R.id.txtNome);
                EditText login = (EditText) findViewById(R.id.txtLogin);
                EditText senha = (EditText) findViewById(R.id.txtSenha);
                String nomeString = nome.getText().toString();
                String loginString = login.getText().toString();
                String senhaString = senha.getText().toString();
                String resultado;

                resultado = crud.insereDado(nomeString, loginString, senhaString);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
    }

    public void logar(View view){
        Intent intent = new Intent(this, login.class);
        startActivity(intent);

    }

}
