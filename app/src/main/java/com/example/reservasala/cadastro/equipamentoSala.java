package com.example.reservasala.cadastro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.reservasala.Controller.equipSalaController;
import com.example.reservasala.MainActivity;
import com.example.reservasala.R;

public class equipamentoSala extends Activity implements View.OnClickListener {

    Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipamentosala);
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
                equipSalaController crud = new equipSalaController(getBaseContext());
                EditText equip = (EditText)findViewById((R.id.txtEquip));
                EditText sala = (EditText)findViewById(R.id.txtSala);
                String equipString = equip.getText().toString();
                String salaString = sala.getText().toString();
                String resultado;

                resultado = crud.insereDado(salaString, equipString);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void voltar(View view){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }


}
