package com.example.sqlitesozluk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class info extends AppCompatActivity {

    private TextView textViewIngilizce;
    private TextView textViewTurkce;
    private Words word;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info2);

        textViewIngilizce = findViewById(R.id.textViewIngilizce);
        textViewTurkce = findViewById(R.id.textViewTurkce);

        word = (Words) getIntent().getSerializableExtra("nesne");

        textViewIngilizce.setText(word.getIngilizce());
        textViewTurkce.setText(word.getTurkce());


    }
}