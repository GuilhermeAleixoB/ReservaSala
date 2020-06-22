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
        valores.put(DAO.getNSALA(), sala);
        valores.put(DAO.getEQUIP(), equip);

        boolean isValid1 = banco.findBySala(sala);
        boolean isValid2 = banco.findByEquip(equip);
        boolean isvalid3 = banco.findBySalaEquip(sala, equip);

        if (isValid1 && isValid2 && isvalid3){
            resultado = db.insert(DAO.getTABELA3(), null, valores);
            db.close();

            if (resultado ==-1)
                return "Erro ao cadastrar equipamento!";
            else
                return "Equipamento cadastrado com sucesso!";

        }else if (!isValid1){
            return "Sala não existe!";
        }else if (!isValid2){
            return "Equipamento não existe!";
        }else{
            return "Sala já associada ao equipamento!";
        }


    }



}
