package com.example.david.contactsa13davidtm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by david on 12/03/2015.
 */
public class ClaseBBDD extends SQLiteOpenHelper {
    public final static String NOME_BD="basededatos";
    public final static int VERSION_BD=1;
    public final static String NOME_TABLA="contactos";
    public final static String CAMPO_ID="id";
    public final static String CAMPO_NOME="nome";
    public final static String CAMPO_NUMERO="numero";

    public ClaseBBDD(Context context){
        super(context, NOME_BD, null, VERSION_BD);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+NOME_TABLA+"("+CAMPO_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_NOME+" TEXT, "+CAMPO_NUMERO+" NUMBER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
