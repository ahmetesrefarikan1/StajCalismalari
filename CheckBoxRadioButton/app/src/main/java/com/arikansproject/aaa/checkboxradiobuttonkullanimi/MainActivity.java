package com.arikansproject.aaa.checkboxradiobuttonkullanimi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private CheckBox checkBoxJava,checkBoxKotlin;
    private RadioButton radioButtonBarca,radioButtonReal;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxJava=findViewById(R.id.checkBoxJava);
        checkBoxKotlin=findViewById(R.id.checkBoxKotlin);
        radioButtonBarca=findViewById(R.id.radioButtonBarca);
        radioButtonReal=findViewById(R.id.radioButtonReal);
        button=findViewById(R.id.button);

        radioButtonBarca.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    Toast.makeText(MainActivity.this,"Tebrikler :)",Toast.LENGTH_SHORT).show();
                }
                else
                {

                }
            }
        });
        checkBoxJava.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    Toast.makeText(MainActivity.this,"Tebrikler javayı seçtiniz.. :)",Toast.LENGTH_SHORT).show();
                }
                else
                {

                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Boolean javadurum =checkBoxJava.isChecked();
                Boolean kotlindurum =checkBoxKotlin.isChecked();
                Boolean barcadurum =radioButtonBarca.isChecked();
                Boolean realdurum =radioButtonReal.isChecked();
                Log.e("durum java",javadurum.toString());
                Log.e("durum kotlin",kotlindurum.toString());
                Log.e("durum barca",barcadurum.toString());
                Log.e("durum real",realdurum.toString());

            }
        });




    }
}
