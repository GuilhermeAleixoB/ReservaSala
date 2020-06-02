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

public class equipamentos extends AppCompatActivity {

    DAO db;
    ListView lista;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipamentos);
        ActionBar bar = getSupportActionBar();
        bar.setTitle("LISTA DE EQUIPAMENTOS");
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#5F9EA0")));

        lista = (ListView) findViewById(R.id.equipSala_list);

        viewTudo();

    }


    public void voltar(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void viewTudo(){

        try {
            if (db == null)
                db = new DAO(this);
            SQLiteDatabase sqlDb = db.getReadableDatabase();
            Cursor c = db.getEquip();

            String coluna[] = new String[] {"_id" , "equip" , "InfoEquip"};
            int id[] = new int[] { R.id.tvId, R.id.tvNome, R.id.tvInfo };

            SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                    R.layout.activity_linha, c, coluna, id);
            lista.setAdapter(adapter);

        } catch (Exception ex) {
            Toast.makeText(equipamentos.this, ex.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }

    }


}
