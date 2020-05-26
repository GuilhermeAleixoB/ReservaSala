package com.example.reservasala.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.reservasala.DAO;

public class equipController {

    private SQLiteDatabase db;
    private DAO banco;

    public equipController(Context context){
        banco = new DAO(context);
    }

    public String insereDado(String equip, String infoEquip){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(DAO.getEQUIP(), equip);
        valores.put(DAO.getINFOEQUIP(), infoEquip);

        resultado = db.insert(DAO.getTABELA2(), null, valores);
        db.close();

        if (resultado ==-1)
            return "Erro ao cadastrar equipamento";
        else
            return "Equipamento cadastrado com sucesso";

    }


}
