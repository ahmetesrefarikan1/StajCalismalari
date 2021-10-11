package com.arikansproject.aaa.sploginekran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AnaEkranActivity extends AppCompatActivity {

    private Button buttonCikisYap;
    private TextView textViewCikti;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private String username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana_ekran);

        buttonCikisYap=findViewById(R.id.buttonCikisYap);
        textViewCikti=findViewById(R.id.textViewCikti);

        sp=getSharedPreferences("GirisBilgi",MODE_PRIVATE);
        editor=sp.edit();

        username=sp.getString("username","kullanıcı adı yok");
        password=sp.getString("password","şifre yok");

        textViewCikti.setText("Username : "+username+"  Password : "+password);

        buttonCikisYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor.remove("username");
                editor.remove("password");
                editor.commit();

                startActivity(new Intent(AnaEkranActivity.this,MainActivity.class));
                finish();


            }
        });

    }
}
