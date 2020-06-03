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

public class reservas extends AppCompatActivity {

    DAO db;
    ListView lista;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservas);
        ActionBar bar = getSupportActionBar();
        bar.setTitle("LISTA DE RESERVAS");
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#5F9EA0")));

        db = new DAO(this);
        lista = (ListView) findViewById(R.id.reserva_list);

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
            Cursor c = db.getReserva();

            String coluna[] = new String[] {"_id" , "nome" , "data", "_idSala"};
            int id[] = new int[] { R.id.tvId, R.id.tvNome, R.id.tvInfo, R.id.tvData };

            SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                    R.layout.activity_linha1, c, coluna, id);
            lista.setAdapter(adapter);

        } catch (Exception ex) {
            Toast.makeText(reservas.this, ex.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }

    }


}
