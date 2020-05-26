package com.example.reservasala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.reservasala.cadastro.cadastroEquipamento;
import com.example.reservasala.cadastro.cadastroSala;
import com.example.reservasala.cadastro.equipamentoSala;
import com.example.reservasala.cadastro.reserva;
import com.example.reservasala.lista.equipSalas;
import com.example.reservasala.lista.equipamentos;
import com.example.reservasala.lista.reservas;
import com.example.reservasala.lista.salas;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cadSala(View v) {
        Intent intent = new Intent(this, cadastroSala.class);
        startActivity(intent);

    }

    public void consulSala(View v){
        Intent intent = new Intent(this, salas.class);
        startActivity(intent);
    }



    public void cadEquip(View v) {
        Intent intent = new Intent(this, cadastroEquipamento.class);
        startActivity(intent);

    }

    public void consulEquip(View v){
        Intent intent = new Intent(this, equipamentos.class);
        startActivity(intent);
    }

    public void cadEquipSala(View v) {
        Intent intent = new Intent(this, equipamentoSala.class);
        startActivity(intent);

    }

    public void consulEquipSala(View v){
        Intent intent = new Intent(this, equipSalas.class);
        startActivity(intent);
    }

    public void cadReserva(View v) {
        Intent intent = new Intent(this, reserva.class);
        startActivity(intent);

    }

    public void consulReserva(View v){
        Intent intent = new Intent(this, reservas.class);
        startActivity(intent);
    }

    public void delete(View v){
        Intent intent = new Intent(this, delete.class);
        startActivity(intent);
    }
}
