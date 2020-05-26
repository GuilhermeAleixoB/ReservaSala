package com.example.reservasala.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.reservasala.DAO;

public class equipSalaController {

    private SQLiteDatabase db;
    private DAO banco;

    public equipSalaController(Context context){
        banco = new DAO(context);
    }

    public String insereDado(String sala, String equip){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(DAO.getIDSALA(), sala);
        valores.put(DAO.getIDEQUIP(), equip);

        resultado = db.insert(DAO.getTABELA3(), null, valores);
        db.close();

        if (resultado ==-1)
            return "Erro ao cadastrar equipamento";
        else
            return "Equipamento cadastrado com sucesso";

    }


}
