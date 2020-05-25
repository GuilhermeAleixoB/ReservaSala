package com.example.reservasala;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.reservasala.bd;

import java.util.ArrayList;

public class salaController {

    private SQLiteDatabase db;
    private bd banco;

    public salaController(Context context){
        banco = new bd(context);
    }

    public String insereDado(String nSala, String infoSala){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(bd.getNSALA(), nSala);
        valores.put(bd.getINFOSALA(), infoSala);

        resultado = db.insert(bd.getTABELA1(), null, valores);
        db.close();

        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro inserido com sucesso";

    }


}
