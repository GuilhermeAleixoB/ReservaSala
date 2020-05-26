package com.example.reservasala;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class delete extends AppCompatActivity {

    DAO db;

    Button sala, equip, equipSala, reserva;
    EditText ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleta);
        db = new DAO(this);

sala = (Button) findViewById(R.id.btnSala);
        equip = (Button) findViewById(R.id.btnEquip);
        equipSala = (Button) findViewById(R.id.btnEquipSala);
        reserva = (Button) findViewById(R.id.btnReservar);
ID = (EditText) findViewById(R.id.txtId);

        deletaSala();
        deletaEquip();
        deletaEquipSala();
        deletaReserva();
    }

public void deletaSala(){
    sala.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String IDint = ID.getText().toString();

        Integer result = db.deletarSala(IDint);

        if (result > 0){
            Toast.makeText(delete.this, "Sala deletada!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(delete.this, "Sala não deletada!", Toast.LENGTH_LONG).show();
        }

        }
    });
    }

    public void deletaEquipSala(){
        equipSala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String IDint = ID.getText().toString();

                Integer result = db.deletarEquipSala(IDint);

                if (result > 0){
                    Toast.makeText(delete.this, "Desvinculou o equipamento da sala!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(delete.this, "Equipamento não desvinculado da sala!", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    public void deletaReserva(){
        reserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String IDint = ID.getText().toString();

                Integer result = db.deletarReserva(IDint);

                if (result > 0){
                    Toast.makeText(delete.this, "Reserva deletada!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(delete.this, "Reserva não deletada!", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    public void deletaEquip(){
        equip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String IDint = ID.getText().toString();

                Integer result = db.deletarEquip(IDint);

                if (result > 0){
                    Toast.makeText(delete.this, "Equipamento deletado!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(delete.this, "Equipamento não deletado!", Toast.LENGTH_LONG).show();
                }

            }
        });
    }


    public void voltar(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
