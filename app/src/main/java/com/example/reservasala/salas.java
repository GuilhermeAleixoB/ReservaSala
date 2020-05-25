package com.example.reservasala;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class salas extends AppCompatActivity {

    bd db;
    ListView lista;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salas);

        db = new bd(this);
        lista = (ListView) findViewById(R.id.sala_list);

        viewTudo();

    }


    public void voltar(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void viewTudo(){

        try {
            if (db == null)
                db = new bd(this);
            SQLiteDatabase sqlDb = db.getReadableDatabase();
            Cursor c = db.getSalas();

            String coluna[] = new String[] {"_id" , "nSala" , "infoSala"};
            int id[] = new int[] { R.id.tvIdSala, R.id.tvNSala, R.id.tvInfoSala };

            SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                    R.layout.lista_linha, c, coluna, id);
            lista.setAdapter(adapter);

        } catch (Exception ex) {
            Toast.makeText(salas.this, ex.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }

    }


}
