package com.example.sqlitenotuygulamasi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
    public Database(Context context) {
        super(context, "notlar.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE `notlar` (\n" +
                "\t`not_id`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t`ders_adi`\tTEXT,\n" +
                "\t`not1`\tINTEGER,\n" +
                "\t`not2`\tINTEGER\n" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS notlar");
        onCreate(sqLiteDatabase);
    }
}
