package com.example.sqlitesozluk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private Toolbar toolbar;
    private RecyclerView rv;
    private ArrayList<Words> kelimelerListe;
    private Adapter adapter;
    private Database vt ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        rv = findViewById(R.id.rv);
        vt = new Database(this);
        veritabaniKopyala();
        toolbar.setTitle("Dictionary / Sözlük");
      //  setSupportActionBar(toolbar);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        kelimelerListe = new WordsDAO().tumKelimeler(vt);
        adapter = new Adapter(this,kelimelerListe);
        rv.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        MenuItem item = menu.findItem(R.id.action_ara);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.e("Gönderilen arama",query);
        aramaYap(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.e("Harf girdikçe",newText);
        aramaYap(newText);
        return false;
    }

    public void veritabaniKopyala(){

        DatabaseCopyHelper copyHelper = new DatabaseCopyHelper(this);
        try {
            copyHelper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        copyHelper.openDataBase();

    }

    public void aramaYap(String aramaKelime){

        kelimelerListe = new WordsDAO().kelimeAra(vt,aramaKelime);
        adapter = new Adapter(this,kelimelerListe);
        rv.setAdapter(adapter);

    }


}