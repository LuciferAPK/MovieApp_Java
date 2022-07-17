package com.example.moviechill.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.moviechill.R;
import com.example.moviechill.home.HomeFragment;
import com.example.moviechill.movies.MoviesFragment;
import com.example.moviechill.tvs.TvsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity{

    private final int HOME_FRAGMENT = 0;
    private final int MOVIE_FRAGMENT = 1;
    private final int TV_FRAGMENT = 2;
    private int checkFragment = HOME_FRAGMENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment(new HomeFragment());
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_homes:
                        if (checkFragment != HOME_FRAGMENT) {
                            loadFragment(new HomeFragment());
                            checkFragment = HOME_FRAGMENT;
                            break;
                        }

                    case R.id.navigation_movies:
                        if (checkFragment != MOVIE_FRAGMENT) {
                            loadFragment(new MoviesFragment());
                            checkFragment = MOVIE_FRAGMENT;
                            break;
                        }

                    case R.id.navigation_tvs:
                        if (checkFragment != TV_FRAGMENT) {
                            loadFragment(new TvsFragment());
                            checkFragment = TV_FRAGMENT;
                            break;
                        }
                }
                return true;
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.home_nav_host, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}