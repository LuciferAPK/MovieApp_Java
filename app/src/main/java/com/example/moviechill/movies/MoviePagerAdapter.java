package com.example.moviechill.movies;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.moviechill.movies.tabfragment.nowplaying.NowPlayingMovieFragment;
import com.example.moviechill.movies.tabfragment.popular.PopularMovieFragment;
import com.example.moviechill.movies.tabfragment.toprated.TopRatedMovieFragment;
import com.example.moviechill.movies.tabfragment.upcoming.UpcomingMovieFragment;

public class MoviePagerAdapter extends FragmentStateAdapter {
    public MoviePagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new PopularMovieFragment();
            case 1:
                return new NowPlayingMovieFragment();
            case 2:
                return new UpcomingMovieFragment();
            case 3:
                return new TopRatedMovieFragment();
            default:
                return createFragment(0);
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
