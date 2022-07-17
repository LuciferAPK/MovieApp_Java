package com.example.moviechill.tvs.tabfragment.airingtoday;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.domain.model.Tv;
import com.example.moviechill.R;
import com.example.moviechill.adapter.ViewAdapter;
import com.example.moviechill.tvs.TvPresenter;

import java.util.List;

public class AiringTodayTvFragment extends Fragment implements AiringTodayTvViewContact {
    RecyclerView recyclerAiringTv;
    ViewAdapter viewAdapter;
    FrameLayout frameLayout;
    TvPresenter tvPresenter = new TvPresenter(this, getContext());

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_airing_today_tv, container, false);
        recyclerAiringTv = view.findViewById(R.id.rv_airing_tv);
        frameLayout = view.findViewById(R.id.fr_loading);
        tvPresenter.getAiringTodayTv();
        return view;
    }

    @Override
    public void showAiringTodayTv(List<Tv> tvAiringToday) {
        viewAdapter = new ViewAdapter(getActivity(), tvAiringToday);
        recyclerAiringTv.setAdapter(viewAdapter);
    }

    @Override
    public void onStartLoading() {
        frameLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void onDismissLoading() {
        frameLayout.setVisibility(View.GONE);
    }
}
