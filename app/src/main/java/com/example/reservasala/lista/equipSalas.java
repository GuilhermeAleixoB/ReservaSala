package com.example.reservasala.lista;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.reservasala.DAO;
import com.example.reservasala.MainActivity;
import com.example.reservasala.R;
import com.example.reservasala.cadastro.reserva;

public class equipSalas extends AppCompatActivity {

    DAO db;
    ListView lista;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipamentosalas);
        ActionBar bar = getSupportActionBar();
        bar.setTitle("LISTA DE SALAS E EQUIPAMENTOS");
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#5F9EA0")));

        db = new DAO(this);
        lista = (ListView) findViewById(R.id.equipSala_list);

        viewTudo();

    }


    public void voltar(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void reserva(View view) {
        Intent intent = new Intent(this, reserva.class);
        startActivity(intent);
    }

    public void viewTudo(){

        try {
            if (db == null)
                db = new DAO(this);
            SQLiteDatabase sqlDb = db.getReadableDatabase();
            Cursor c = db.getEquipSala();

            String coluna[] = new String[] {"_id" , "nSala" , "equip"};
            int id[] = new int[] { R.id.tvId, R.id.tvNome, R.id.tvInfo };

            SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                    R.layout.activity_linha, c, coluna, id);
            lista.setAdapter(adapter);

        } catch (Exception ex) {
            Toast.makeText(equipSalas.this, ex.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }

    }


}
