package com.arikansproject.aaa.snackbarkullanimi;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private Button buttonNormal,buttonGeriDonus,buttonOzel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonGeriDonus=findViewById(R.id.buttonGeriDonus);
        buttonOzel=findViewById(R.id.buttonOzel);
        buttonNormal=findViewById(R.id.buttonNormal);

        buttonNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Snackbar.make(v,"Merhaba",Snackbar.LENGTH_SHORT).show();


            }
        });
        buttonGeriDonus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Snackbar.make(v,"Mesaj silinsin mi?",Snackbar.LENGTH_SHORT).setAction("Evet", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Snackbar.make(v,"Silindi",Snackbar.LENGTH_SHORT).show();
                    }
                }).show();


            }
        });
        buttonOzel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Snackbar sb=Snackbar.make(v,"İnternet bağlantısı yok",Snackbar.LENGTH_LONG).setAction("Tekrar dene", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                sb.setActionTextColor(Color.YELLOW);

                sb.getView().setBackgroundColor(Color.WHITE);

                View sview=sb.getView();
                TextView textView=sview.findViewById(com.google.android.material.R.id.snackbar_text);
                textView.setTextColor(Color.BLUE);

                sb.show();

            }
        });



    }
}
