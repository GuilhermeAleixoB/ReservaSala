package com.example.reservasala;

import android.content.Context;
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
import com.example.reservasala.Controller.loginController;
import com.example.reservasala.cadastro.cadastroLogin;

public class login extends AppCompatActivity {

    DAO db;

    Button entrar;
    private Context context;
    private loginController LoginController;
    EditText editLogin, editSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar bar = getSupportActionBar();
        bar.setTitle("LOGIN");
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#5F9EA0")));
        db = new DAO(this);

        context = this;
        LoginController = loginController.getInstance(context);
        entrar = (Button) findViewById(R.id.btnEntrar);
        editLogin = (EditText) findViewById(R.id.txtLogin);
        editSenha = (EditText) findViewById(R.id.txtSenha);

    }

    public void validar(View view){
        String login = editLogin.getText().toString();
        String senha = editSenha.getText().toString();

        try{
            boolean isValid = LoginController.validaLogin(login, senha);
            if (isValid){
                String resultado = "Login e senha certos!";
                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
                Usuario user = db.findByLogin(login, senha);
                String resultado2 = "Bem vindo(a) " + user.getNome();
                Toast.makeText(getApplicationContext(), resultado2, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            } else {
                String resultado = "Login ou senha errada!";
                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        } catch (Exception e){
            String resultado = "Erro ao validar login e senha!";
            Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

    }


    public void cadastrar(View view){
        Intent intent = new Intent(this, cadastroLogin.class);
        startActivity(intent);

    }

}
