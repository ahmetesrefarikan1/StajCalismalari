package com.arikansproject.aaa.videoviewkullanimi;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private VideoView videoView;
    private Button buttonBasla,buttonDurdur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView=findViewById(R.id.videoView);
        buttonBasla=findViewById(R.id.buttonBaslat);
        buttonDurdur=findViewById(R.id.buttonDurdur);

        buttonBasla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri adres=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video);

                videoView.setVideoURI(adres);
                videoView.start();

            }
        });
        buttonDurdur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                videoView.stopPlayback();
            }
        });

    }
}
