package com.example.moviechill.tvs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.moviechill.R;
import com.example.moviechill.tvs.tabfragment.airingtoday.AiringTodayTvFragment;
import com.example.moviechill.tvs.tabfragment.ontv.OnTVFragment;
import com.example.moviechill.tvs.tabfragment.popular.PopularTvFragment;
import com.example.moviechill.tvs.tabfragment.toprated.TopRatedTvFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class TvsFragment extends Fragment {
    TabLayout tabLayout;
    ViewPager2 viewPager2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tvs, container, false);
        tabLayout = view.findViewById(R.id.tab_Layout_tv);
        viewPager2 = view.findViewById(R.id.view_Pager_Tv);
        TvPagerAdapter tvPagerAdapter = new TvPagerAdapter(this);
        viewPager2.setAdapter(tvPagerAdapter);
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
                    tab.setText("Airing Today");
                    break;
                case 2:
                    tab.setText("On TV");
                    break;
                case 3:
                    tab.setText("Top Rated");
                    break;
            }
        }).attach();
    }
}
