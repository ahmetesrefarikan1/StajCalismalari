package com.arikansproject.aaa.bildirimcalismasi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonBildir;
    private NotificationCompat.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonBildir=findViewById(R.id.buttonBildir);

        buttonBildir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gecikmeliBildirim();
            }
        });

    }

    public void durumaBagli(){

        NotificationManager bildirimYoneticisi=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        Intent intent= new Intent(MainActivity.this,KarsilamaEkrani.class);

        PendingIntent gidilecekIntent=PendingIntent.getActivity(this,1,intent,PendingIntent.FLAG_UPDATE_CURRENT);


        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){

            String kanalId="kanalId";
            String kanalAd="kanalAd";
            String kanalTanim="KanalTanim";
            int kanalOnceligi=NotificationManager.IMPORTANCE_HIGH;

            NotificationChannel kanal=bildirimYoneticisi.getNotificationChannel(kanalId);

            if(kanal==null){
                kanal=new NotificationChannel(kanalId,kanalAd,kanalOnceligi);
                kanal.setDescription(kanalTanim);
                bildirimYoneticisi.createNotificationChannel(kanal);
            }

            builder=new NotificationCompat.Builder(this,kanalId);

            builder.setContentTitle("Başlık");
            builder.setContentText("İçerik");
            builder.setSmallIcon(R.drawable.ic_audiotrack_black_24dp);
            builder.setAutoCancel(true);
            builder.setContentIntent(gidilecekIntent);


        }
        else{
            builder=new NotificationCompat.Builder(this);

            builder.setContentTitle("Başlık");
            builder.setContentText("İçerik");
            builder.setSmallIcon(R.drawable.ic_audiotrack_black_24dp);
            builder.setAutoCancel(true);
            builder.setContentIntent(gidilecekIntent);
            builder.setPriority(Notification.PRIORITY_HIGH);
        }
        bildirimYoneticisi.notify(1,builder.build());

        }


        public void gecikmeliBildirim(){
            NotificationManager bildirimYoneticisi=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

            Intent intent= new Intent(MainActivity.this,KarsilamaEkrani.class);

            PendingIntent gidilecekIntent=PendingIntent.getActivity(this,1,intent,PendingIntent.FLAG_UPDATE_CURRENT);


            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){

                String kanalId="kanalId";
                String kanalAd="kanalAd";
                String kanalTanim="KanalTanim";
                int kanalOnceligi=NotificationManager.IMPORTANCE_HIGH;

                NotificationChannel kanal=bildirimYoneticisi.getNotificationChannel(kanalId);

                if(kanal==null){
                    kanal=new NotificationChannel(kanalId,kanalAd,kanalOnceligi);
                    kanal.setDescription(kanalTanim);
                    bildirimYoneticisi.createNotificationChannel(kanal);
                }

                builder=new NotificationCompat.Builder(this,kanalId);

                builder.setContentTitle("Başlık");
                builder.setContentText("İçerik");
                builder.setSmallIcon(R.drawable.ic_audiotrack_black_24dp);
                builder.setAutoCancel(true);
                builder.setContentIntent(gidilecekIntent);


            }
            else{
                builder=new NotificationCompat.Builder(this);

                builder.setContentTitle("Başlık");
                builder.setContentText("İçerik");
                builder.setSmallIcon(R.drawable.ic_audiotrack_black_24dp);
                builder.setAutoCancel(true);
                builder.setContentIntent(gidilecekIntent);
                builder.setPriority(Notification.PRIORITY_HIGH);
            }

            Intent brodcastIntent =new Intent(MainActivity.this,BildirimYakalayici.class);

            brodcastIntent.putExtra("nesne",builder.build());

            PendingIntent gidilecekBrodcast=PendingIntent.getBroadcast(this,0,brodcastIntent,PendingIntent.FLAG_UPDATE_CURRENT);

            long gecikme= SystemClock.elapsedRealtime()+5000;

            AlarmManager alarmManager=(AlarmManager)getSystemService(Context.ALARM_SERVICE);

            alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,gecikme,gidilecekBrodcast);

        }



}
