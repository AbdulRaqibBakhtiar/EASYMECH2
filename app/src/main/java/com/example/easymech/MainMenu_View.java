package com.example.easymech;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.AdapterListUpdateCallback;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainMenu_View extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ListView listView;
    ArrayList<Mechanics> list;
    AdapterList adapterList;
    RatingBar rate_bar;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    //TextView show_rate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu__view);

        //rate_bar = findViewById(R.id.ratingBar);
        listView = findViewById(R.id.listview_view);
        //show_rate = findViewById(R.id.Show_rate);
        listShow();
        adapterList = new AdapterList(this, list);
        listView.setAdapter(adapterList);

       // float ratingValue = rate_bar.getRating();
       // show_rate.setText(" "+ratingValue);


       // getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contatiner,new HomeFragment()).commit();

        toolbar = (Toolbar) findViewById(R.id.tool_Bar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawerlayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

    }
    public void listShow(){
        list = new ArrayList<Mechanics>();

        list.add(new Mechanics("Auto Car Experts ","256/5 Diaswaddo, Arpora Calangute Road, Arpora, Goa - 403516, Near Dream Circle",R.drawable.auto_experts));
        list.add(new Mechanics("HYDER KHAN MOTOR Garage","TALEIGAO Band, Santa Cruz Road Taleigao, Taleigao, Goa - 403001, Near By Essar Residency",R.drawable.bavarati_auto));
        list.add(new Mechanics("Sharayu Toyota","Survey No 116/3, National Highway No 17, Cortalim, Goa - 403710, Kesarval Verna, Opposite Kesarval Garden Hotel",R.drawable.sharya_toyota));
        list.add(new Mechanics("Auto Pro","Pundalik Nagar, Alto Porvorim, Goa - 403521, Nr Club De Goa",R.drawable.auto_pro));
        list.add(new Mechanics("Alcon Hyundai","Survey No 20/1, National Highway No 17, Porvorim, Goa - 403501, Near Damian De Goa Showroom",R.drawable.alcon_hyndai));
        list.add(new Mechanics("Bavaria Motors Pvt Ltd","Plot Number 2 B, Verna, Goa - 403722, Phase 1A, Verna Industries Estate, NH.",R.drawable.haider_khan));

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.about_us:
                Toast.makeText(this, "About Us", Toast.LENGTH_LONG).show();
                break;

            case R.id.helping:
                Toast.makeText(this, "Need help?", Toast.LENGTH_LONG).show();
                break;

            case R.id.F_A_Q:
                Toast.makeText(this, "Frequently Asked Questions", Toast.LENGTH_LONG).show();
                break;


            case R.id.share_link:
                Toast.makeText(this, "Share this app", Toast.LENGTH_LONG).show();
                break;

            case R.id.Rate_us:
                Toast.makeText(this, "Rate Our Application", Toast.LENGTH_LONG).show();
                break;

            case R.id.feedback:
                Toast.makeText(this, "Give Us Feedback", Toast.LENGTH_LONG).show();
                break;

            case R.id.Report_prob:
                Toast.makeText(this, "Report a Problem", Toast.LENGTH_LONG).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}

