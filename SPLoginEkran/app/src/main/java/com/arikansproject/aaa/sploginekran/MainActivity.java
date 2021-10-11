package com.arikansproject.aaa.sploginekran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUsername,editTextPassword;
    private Button buttonGiris;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private String username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsername=findViewById(R.id.editTextUsername);
        editTextPassword=findViewById(R.id.editTextPassword);
        buttonGiris=findViewById(R.id.buttonGiris);

        sp=getSharedPreferences("GirisBilgi",MODE_PRIVATE);
        editor=sp.edit();

        username=sp.getString("username","kullanıcı adı yok");
        password=sp.getString("password","şifre yok");

        if(username.equals("admin")&&password.equals("123")){
            startActivity(new Intent(MainActivity.this,AnaEkranActivity.class));
            finish();
        }


        buttonGiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(editTextUsername.getText().toString().equals("admin")&&editTextPassword.getText().toString().equals("123")){
                    editor.putString("username",editTextUsername.getText().toString());
                    editor.putString("password",editTextPassword.getText().toString());
                    editor.commit();

                    startActivity(new Intent(MainActivity.this,AnaEkranActivity.class));
                    finish();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Giriş Başarısız",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
