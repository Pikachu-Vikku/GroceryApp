package com.example.groceryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;

public class Home extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        //decleration part
        BottomNavigationView bottomNavigationView=findViewById(R.id.home_bottomNavigation_view);
        FloatingActionButton floatingActionButton=findViewById(R.id.home_floating_btn);

        //rounded backgrounded of bottom navbar
        float radius = getResources().getDimension(R.dimen.default_corner_radius);
        BottomAppBar bottomAppBar = findViewById(R.id.home_bottomAppBar);

        MaterialShapeDrawable bottomBarBackground = (MaterialShapeDrawable) bottomAppBar.getBackground();
        bottomBarBackground.setShapeAppearanceModel(
                bottomBarBackground.getShapeAppearanceModel()
                        .toBuilder()
                        .setTopRightCorner(CornerFamily.ROUNDED,radius)
                        .setTopLeftCorner(CornerFamily.ROUNDED,radius)
                        .build());
        //rounded backgrounded of bottom navbar ends here

        bottomNavigationView.setBackground(null);
        bottomNavigationView.setSelectedItemId(R.id.notAvailable);
        floatingActionButton.setOnClickListener(this);

        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListner);
        getSupportFragmentManager().beginTransaction().replace(R.id.home_frame_layout,new HomeFragment()).commit();

    }
    private final BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListner=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment=null;
            switch (item.getItemId()){
                case R.id.bottom_appbar_filter:
                    selectedFragment= new FilterFragment();
                    break;
                case R.id.bottom_appbar_favourite:
                    selectedFragment= new FavouriteFragment();
                    break;
                case R.id.bottom_appbar_profilr:
                    selectedFragment= new ProfileFragment();
                    break;
                case R.id.bottom_appbar_setting:
                    selectedFragment= new SettingsFragment();
                    break;
                case R.id.home_floating_btn:
                    selectedFragment=new HomeFragment();

                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.home_frame_layout,selectedFragment).commit();
            return true;
        }
    };

    @Override
    public void onClick(View v) {
        BottomNavigationView bottomNavigationView=findViewById(R.id.home_bottomNavigation_view);
        getSupportFragmentManager().beginTransaction().replace(R.id.home_frame_layout,new HomeFragment()).commit();
        bottomNavigationView.setSelectedItemId(R.id.notAvailable);
    }


//    public void FloatingActionButtonMethod(){
//        FloatingActionButton floatingActionButton=findViewById(R.id.home_floating_btn);
//        floatingActionButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getSupportFragmentManager().beginTransaction().replace(R.id.home_frame_layout,new HomeFragment()).commit();
//            }
//        });
//    }
}