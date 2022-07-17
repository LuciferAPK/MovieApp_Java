package com.example.moviechill.tvs;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.moviechill.tvs.tabfragment.airingtoday.AiringTodayTvFragment;
import com.example.moviechill.tvs.tabfragment.ontv.OnTVFragment;
import com.example.moviechill.tvs.tabfragment.popular.PopularTvFragment;
import com.example.moviechill.tvs.tabfragment.toprated.TopRatedTvFragment;

public class TvPagerAdapter extends FragmentStateAdapter {
    public TvPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new PopularTvFragment();
            case 1:
                return new AiringTodayTvFragment();
            case 2:
                return new OnTVFragment();
            case 3:
                return new TopRatedTvFragment();
            default:
                return createFragment(0);
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
