package com.example.sqlitesozluk;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class WordsDAO {
    public ArrayList<Words> tumKelimeler(Database vt){
        ArrayList<Words> kelimelerArrayList = new ArrayList<>();
        SQLiteDatabase db = vt.getWritableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM kelimeler",null);
        while (c.moveToNext()){
            @SuppressLint("Range") Words k = new Words(c.getInt(c.getColumnIndex("kelime_id"))
                    ,c.getString(c.getColumnIndex("ingilizce"))
                    ,c.getString(c.getColumnIndex("turkce")));
            kelimelerArrayList.add(k);
        }

        return kelimelerArrayList;

    }


    public ArrayList<Words> kelimeAra(Database vt,String aramaKelime){
        ArrayList<Words> kelimelerArrayList = new ArrayList<>();
        SQLiteDatabase db = vt.getWritableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM kelimeler WHERE ingilizce like '%"+aramaKelime+"%'",null);
        while (c.moveToNext()){
            Words k = new Words(c.getInt(c.getColumnIndex("kelime_id"))
                    ,c.getString(c.getColumnIndex("ingilizce"))
                    ,c.getString(c.getColumnIndex("turkce")));
            kelimelerArrayList.add(k);
        }

        return kelimelerArrayList;

    }
}
