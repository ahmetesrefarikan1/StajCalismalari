package com.example.sqlitenotuygulamasi;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView rv;
    private FloatingActionButton fab;
    private Adapter adapter;
    private ArrayList<Scores> notlarArrayList;
    private Database vt;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Not Uygulaması");
        //setSupportActionBar(toolbar);

        rv = findViewById(R.id.rv);
        fab = findViewById(R.id.fab);

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        vt = new Database(this);

        notlarArrayList = new ScoresDAO().tumNotlar(vt);

        adapter = new Adapter(this,notlarArrayList);

        rv.setAdapter(adapter);

        double toplam = 0 ;

        for (Scores n: notlarArrayList){
            toplam = toplam + (n.getNot1()+n.getNot2())/2 ;
        }

        toolbar.setSubtitle("Ortalama : "+toplam/notlarArrayList.size());


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,addScore.class));
            }
        });


    }
}