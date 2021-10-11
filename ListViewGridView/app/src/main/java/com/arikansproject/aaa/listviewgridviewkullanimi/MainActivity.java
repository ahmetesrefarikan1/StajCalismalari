package com.arikansproject.aaa.listviewgridviewkullanimi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String>ulkeler=new ArrayList<>();
    private ArrayAdapter<String>veriAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listView);

        ulkeler.add("Tr");
        ulkeler.add("En");
        ulkeler.add("Sp");
        ulkeler.add("Fr");
        ulkeler.add("Gr");
        ulkeler.add("Ir");
        ulkeler.add("Nw");

        veriAdapter=new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,android.R.id.text1,ulkeler);

        listView.setAdapter(veriAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(),"Seçtiğiniz ülke :"+ulkeler.get(position),Toast.LENGTH_SHORT).show();

            }
        });


    }
}
