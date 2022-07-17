package com.example.moviechill.tvs.tabfragment.toprated;

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

public class TopRatedTvFragment extends Fragment implements TopRatedTvViewContact {
    RecyclerView recyclerTopRatedTv;
    ViewAdapter viewAdapter;
    FrameLayout frameLayout;
    TvPresenter tvPresenter = new TvPresenter(this, getContext());

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top_rated_tv, container, false);
        recyclerTopRatedTv = view.findViewById(R.id.rv_toprated_tv);
        frameLayout = view.findViewById(R.id.fr_loading);
        tvPresenter.getTopRatedTv();
        return view;
    }

    @Override
    public void showTopRatedTv(List<Tv> tvTopRated) {
        viewAdapter = new ViewAdapter(getActivity(), tvTopRated);
        recyclerTopRatedTv.setAdapter(viewAdapter);
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
