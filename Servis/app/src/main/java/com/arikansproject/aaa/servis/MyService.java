package com.arikansproject.aaa.servis;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyService extends Service {

    private Handler h;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        h=new Handler();

        h.postDelayed(runnable,5000);

        Toast.makeText(this,"Servis çalışmaya başladı",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this,"Servis durdu",Toast.LENGTH_SHORT).show();

        h.removeCallbacks(runnable);
    }

    private final Runnable runnable =new Runnable() {
        @Override
        public void run() {
            Toast.makeText(MyService.this,"Servis çalışmaya devam ediyor",Toast.LENGTH_SHORT).show();

            MyService.this.h.postDelayed(runnable,5000);
        }
    };
}
