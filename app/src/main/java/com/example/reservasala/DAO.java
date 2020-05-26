package com.example.reservasala;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DAO extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "ReservaSala.db";
    private static final String TABELA1 = "Sala";
    private static final String ID = "_id";
    private static final String NSALA = "nSala";
    private static final String INFOSALA = "infoSala";
    private static final String TABELA2 = "Equipamento";
    private static final String IDEQUIP = "_idEquip";
    private static final String EQUIP = "equip";
    private static final String INFOEQUIP = "InfoEquip";
    private static final String TABELA3 = "EquipSala";
    private static final String IDEQUIPSALA = "_idEquipsala";
    private static final String TABELA4 = "Reserva";
    private static final String IDRESERVA = "_idReserva";
    private static final String NOME = "nome";
    private static final String DATA = "data";
    private static final String IDSALA = "_idSala";
    private static final int VERSAO = 9;

    public DAO(Context context) {
        super(context, getNomeBanco(), null, getVERSAO());
    }

    public static String getNomeBanco() {
        return NOME_BANCO;
    }

    public static String getTABELA1() {
        return TABELA1;
    }

    public static String getID() {
        return ID;
    }

    public static String getNSALA() {
        return NSALA;
    }

    public static String getINFOSALA() {
        return INFOSALA;
    }

    public static String getTABELA2() {
        return TABELA2;
    }

    public static String getIDEQUIP() {
        return IDEQUIP;
    }

    public static String getEQUIP() {
        return EQUIP;
    }

    public static String getINFOEQUIP() {
        return INFOEQUIP;
    }

    public static String getTABELA3() {
        return TABELA3;
    }

    public static String getIDSALA() {
        return IDSALA;
    }

    public static String getTABELA4() {
        return TABELA4;
    }

    public static String getNOME() {
        return NOME;
    }

    public static String getDATA() {
        return DATA;
    }

    public static int getVERSAO() {
        return VERSAO;
    }


    SQLiteDatabase db;
    DAO banco;

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+ getTABELA1() +"("
            + getID() + " integer primary key autoincrement,"
            + getNSALA() + " text,"
            + getINFOSALA() + " text"
            +")";
        db.execSQL(sql);

        String sql1 = "CREATE TABLE "+ getTABELA2() +"("
                + getID() + " integer primary key autoincrement,"
                + getEQUIP() + " text,"
                + getINFOEQUIP() + " text"
                +")";
        db.execSQL(sql1);

        String sql2 = "CREATE TABLE "+ getTABELA3() +"("
                + getID() + " integer primary key autoincrement,"
                + getIDSALA() + " text,"
                + getIDEQUIP() + " text"
                + ")";
        db.execSQL(sql2);

        String sql3 = "CREATE TABLE "+ getTABELA4() +"("
                + getID() + " integer primary key autoincrement,"
                + getNOME() + " text,"
                + getDATA() + " text,"
                + getIDSALA() + " text"
                +")";
        db.execSQL(sql3);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Sala");
        db.execSQL("DROP TABLE IF EXISTS Equipamento");
        db.execSQL("DROP TABLE IF EXISTS EquipSala");
        db.execSQL("DROP TABLE IF EXISTS Reserva");
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public Cursor getSalas() {
        try {
            String selectQuery = "SELECT * FROM Sala";
            SQLiteDatabase database = this.getWritableDatabase();
            Cursor cursor = database.rawQuery(selectQuery, null);
            return cursor;
        } catch (Exception ex) {
            return null;
        }
    }

    public Cursor getEquip() {
        try {
            String selectQuery = "SELECT * FROM Equipamento";
            SQLiteDatabase database = this.getWritableDatabase();
            Cursor cursor = database.rawQuery(selectQuery, null);
            return cursor;
        } catch (Exception ex) {
            return null;
        }
    }

    public Cursor getEquipSala() {
        try {
            String selectQuery = "SELECT * FROM EquipSala";
            SQLiteDatabase database = this.getWritableDatabase();
            Cursor cursor = database.rawQuery(selectQuery, null);
            return cursor;
        } catch (Exception ex) {
            return null;
        }
    }

    public Cursor getReserva() {
        try {
            String selectQuery = "SELECT * FROM Reserva";
            SQLiteDatabase database = this.getWritableDatabase();
            Cursor cursor = database.rawQuery(selectQuery, null);
            return cursor;
        } catch (Exception ex) {
            return null;
        }
    }

    public int deletarSala(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABELA1, "_id = ?", new String[] {id});
    }

    public int deletarEquip(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABELA2, "_id = ?", new String[] {id});
    }

    public int deletarEquipSala(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABELA3, "_id = ?", new String[] {id});
    }

    public int deletarReserva(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABELA4, "_id = ?", new String[] {id});
    }


}
