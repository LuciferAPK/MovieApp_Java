package com.example.moviechill.movies;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.moviechill.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MoviesFragment extends Fragment {
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movies, container, false);
        tabLayout = view.findViewById(R.id.tab_Layout_movie);
        viewPager2 = view.findViewById(R.id.view_Pager_movie);
        progressBar = view.findViewById(R.id.progress_Bar);
        MoviePagerAdapter moviePagerAdapter = new MoviePagerAdapter(this);
        viewPager2.setAdapter(moviePagerAdapter);
        tabLayout();
        return view;
    }

    private void tabLayout() {
        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Popular");
                    break;
                case 1:
                    tab.setText("Now Playing");
                    break;
                case 2:
                    tab.setText("Upcoming");
                    break;
                case 3:
                    tab.setText("Top Rated");
                    break;
            }
        }).attach();
    }
}
