package com.example.reservasala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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


    public void delete(View v){
        Intent intent = new Intent(this, delete.class);
        startActivity(intent);
    }
}
