/*package com.example.easymech;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class Services_LIsts extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    AdapterRecyclerGrid adapterRecyclerGrid;
    ArrayList<Services_Resources> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services__lists);

        gridList();
        recyclerView = findViewById(R.id.recycleView_grid);
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        adapterRecyclerGrid = new AdapterRecyclerGrid(this, arrayList);
        recyclerView.setAdapter(adapterRecyclerGrid);

    }
    private void gridList(){
        arrayList = new ArrayList<Services_Resources>();

        arrayList.add(new Services_Resources("Repair Services","Repair your car",R.drawable.rep_air));
        arrayList.add(new Services_Resources("Batteries","Battery issues",R.drawable.bat_tery));
        arrayList.add(new Services_Resources("Engine/ Transmission","Fix your car engine",R.drawable.en_gine));
        arrayList.add(new Services_Resources("Oil/ Filters","Change Oil and Filter",R.drawable.oil_filter));
        arrayList.add(new Services_Resources("Paint/ Denting","Paint your own car",R.drawable.paint));
        arrayList.add(new Services_Resources("Tires/ Wheels","Want new tires/ wheels?",R.drawable.tires_wheels));

    }
}
*/

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
        import androidx.recyclerview.widget.GridLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import com.google.android.material.bottomnavigation.BottomNavigationView;
        import com.google.android.material.navigation.NavigationView;

        import java.util.ArrayList;

public class Services_LIsts extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {



    ListView listView;
    ArrayList<Mechanics> list;
    AdapterList adapterList;
    RatingBar rate_bar;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    AdapterRecyclerGrid adapterRecyclerGrid;
    ArrayList<Services_Resources> arrayList;



    //TextView show_rate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services__lists);

        gridList();
        recyclerView = findViewById(R.id.recycleView_grid);
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        adapterRecyclerGrid = new AdapterRecyclerGrid(this, arrayList);
        recyclerView.setAdapter(adapterRecyclerGrid);


        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

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
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFrag = null;

                    switch (menuItem.getItemId()){
                        case R.id.nav_home:
                            selectedFrag = new HomeFragment();
                            break;

                        case R.id.nav_account:
                            selectedFrag = new AccountFragment();
                            break;

                        case R.id.nav_notify:
                            selectedFrag = new NotifyFragment();
                            break;

                        case R.id.nav_favorites:
                            selectedFrag = new FavoritesFragment();
                            break;

                        case R.id.nav_search:
                            selectedFrag = new SearchFragment();
                            break;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contatiner,
                            selectedFrag).commit();
                    return true;
                }
            };


    private void gridList(){
        arrayList = new ArrayList<Services_Resources>();

        arrayList.add(new Services_Resources("Repair Services","Repair your car",R.drawable.rep_air));
        arrayList.add(new Services_Resources("Batteries","Battery issues",R.drawable.bat_tery));
        arrayList.add(new Services_Resources("Engine/ Transmission","Fix your car engine",R.drawable.en_gine));
        arrayList.add(new Services_Resources("Oil/ Filters","Change Oil and Filter",R.drawable.oil_filter));
        arrayList.add(new Services_Resources("Paint/ Denting","Paint your own car",R.drawable.paint));
        arrayList.add(new Services_Resources("Tires/ Wheels","Want new tires/ wheels?",R.drawable.tires_wheels));

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
