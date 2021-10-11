package com.example.sqlitenotuygulamasi;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class addScore extends AppCompatActivity {


    private Toolbar toolbar;
    private EditText editTextDers,editTextNot1,editTextNot2;
    private Button buttonKaydet;
    private Database vt;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_score);

        editTextDers = findViewById(R.id.editTextDers);
        editTextNot1 = findViewById(R.id.editTextNot1);
        editTextNot2 = findViewById(R.id.editTextNot2);
        buttonKaydet = findViewById(R.id.buttonKaydet);


        vt = new Database(this);

        buttonKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String ders_adi = editTextDers.getText().toString().trim();
                String not1 = editTextNot1.getText().toString().trim();
                String not2 = editTextNot2.getText().toString().trim();


                if(TextUtils.isEmpty(ders_adi)){
                    Snackbar.make(view,"Ders adı giriniz",Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(not1)){
                    Snackbar.make(view,"Not1 giriniz",Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(not2)){
                    Snackbar.make(view,"Not2 giriniz",Snackbar.LENGTH_SHORT).show();
                    return;
                }

                new ScoresDAO().notEkle(vt,ders_adi,Integer.parseInt(not1),Integer.parseInt(not2));

                startActivity(new Intent(addScore.this,MainActivity.class));
                finish();
            }
        });
    }
}