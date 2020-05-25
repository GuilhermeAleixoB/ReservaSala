package com.example.reservasala;

import android.os.Bundle;
import android.app.Activity;
import android.view.*;
import android.widget.*;

import com.example.reservasala.R;

public class cadastroEquipamento extends Activity implements View.OnClickListener {
        Button btnCadastrar;

        @Override
    public void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_cadastroequipamento);
        }

    @Override
    public void onClick(View v) {
cadastrar();
    }

    public void cadastrar(){
EditText equip, info;
TextView resultado;

equip = (EditText) findViewById(R.id.txtEquip);
info = (EditText) findViewById(R.id.txtInfoEquip);
resultado = (TextView) findViewById(R.id.tvResultado);

resultado.setText(String.valueOf("Cadastrado"));
    }


}
