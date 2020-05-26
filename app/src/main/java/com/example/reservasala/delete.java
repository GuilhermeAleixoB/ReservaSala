package com.example.reservasala;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class delete extends AppCompatActivity {

    bd db;

    Button sala;
    EditText ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleta);
        db = new bd(this);

sala = (Button) findViewById(R.id.btnSala);
ID = (EditText) findViewById(R.id.txtId);

        deletaSala();
    }

public void deletaSala(){
    sala.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String IDint = ID.getText().toString();

        Integer result = db.deletarSala(IDint);

        if (result > 0){
            Toast.makeText(delete.this, "Sala deletada", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(delete.this, "Sala não deletada", Toast.LENGTH_LONG).show();
        }

        }
    });
    }

    public void voltar(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
