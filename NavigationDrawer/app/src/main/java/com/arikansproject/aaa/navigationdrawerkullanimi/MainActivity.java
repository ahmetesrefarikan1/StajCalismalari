package com.arikansproject.aaa.navigationdrawerkullanimi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private NavigationView navigationView;
    private DrawerLayout drawer;
    private Toolbar toolbar;
    private Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView=findViewById(R.id.navigationView);
        drawer=findViewById(R.id.drawer);
        toolbar=findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        fragment=new FragmentBirinci();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_tutucu,fragment).commit();

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawer,toolbar,0,0);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        View baslik=navigationView.inflateHeaderView(R.layout.navigation_baslik);

        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        if(menuItem.getItemId()==R.id.nav_item_birinci){
            Toast.makeText(getApplicationContext(),"Birinci",Toast.LENGTH_SHORT).show();
            fragment=new FragmentBirinci();
        }
        if(menuItem.getItemId()==R.id.nav_item_ikinci){
            Toast.makeText(getApplicationContext(),"İkinci",Toast.LENGTH_SHORT).show();
            fragment=new FragmentIkinci();
        }
        if(menuItem.getItemId()==R.id.nav_item_ucuncu){
            Toast.makeText(getApplicationContext(),"Üçüncü",Toast.LENGTH_SHORT).show();
            fragment=new FragmentUcuncu();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_tutucu,fragment).commit();
        drawer.closeDrawer(GravityCompat.START);
        return false;
    }


    @Override
    public void onBackPressed() {

        if(drawer.isDrawerOpen(GravityCompat.START))
            drawer.closeDrawer(GravityCompat.START);
        else{
            Intent intent=new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }


}
