package com.example.reservasala.cadastro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.reservasala.Controller.equipController;
import com.example.reservasala.MainActivity;
import com.example.reservasala.R;

public class cadastroEquipamento extends Activity implements View.OnClickListener {

    Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastroequipamento);
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
                equipController crud = new equipController(getBaseContext());
                EditText equip = (EditText)findViewById((R.id.txtEquip));
                EditText infoEquip = (EditText)findViewById(R.id.txtInfoEquip);
                String equipString = equip.getText().toString();
                String infoEquipString = infoEquip.getText().toString();
                String resultado;

                resultado = crud.insereDado(equipString, infoEquipString);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void voltar(View view){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }


}
