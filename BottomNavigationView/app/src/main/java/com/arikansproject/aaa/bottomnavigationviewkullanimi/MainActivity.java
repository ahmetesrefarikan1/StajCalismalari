package com.arikansproject.aaa.bottomnavigationviewkullanimi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottom_navigation;
    private Fragment tempFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottom_navigation=findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_tutucu,new FragmentBirinci()).commit();

        bottom_navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if(menuItem.getItemId()==R.id.action_birinci){
                    Toast.makeText(getApplicationContext(),"Birinci Tıklandı",Toast.LENGTH_SHORT).show();
                    tempFragment=new FragmentBirinci();
                }
                if(menuItem.getItemId()==R.id.action_ikinci){
                    Toast.makeText(getApplicationContext(),"İkinci Tıklandı",Toast.LENGTH_SHORT).show();
                    tempFragment=new FragmentIkinci();
                }
                if(menuItem.getItemId()==R.id.action_ucuncu){
                    Toast.makeText(getApplicationContext(),"Üçüncü Tıklandı",Toast.LENGTH_SHORT).show();
                    tempFragment=new FragmentUcuncu();
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_tutucu,tempFragment).commit();



                return true;
            }
        });
    }
}
