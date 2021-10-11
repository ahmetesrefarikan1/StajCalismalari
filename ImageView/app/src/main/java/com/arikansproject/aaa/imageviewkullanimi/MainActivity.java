package com.arikansproject.aaa.imageviewkullanimi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button buttonResim1,buttonResim2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView =findViewById(R.id.imageView);
        buttonResim1=findViewById(R.id.buttonResim1);
        buttonResim2=findViewById(R.id.buttonResim2);

        buttonResim1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imageView.setImageResource(( R.drawable.image1));

            }
        });
        buttonResim2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imageView.setImageResource(getResources().getIdentifier("resim","drawable",getPackageName()));

            }
        });

    }
}
