package com.example.moviechill.tvs.tabfragment.popular;

import android.os.Bundle;
import android.util.Log;
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

public class PopularTvFragment extends Fragment implements PopularTvViewContact {

    RecyclerView recyclerPopularTv;
    ViewAdapter viewAdapter;
    FrameLayout frameLayout;
    TvPresenter tvPresenter = new TvPresenter(this, getContext());

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_popular_tv, container, false);
        recyclerPopularTv = view.findViewById(R.id.rv_popular_tv);
        frameLayout = view.findViewById(R.id.fr_loading);
        tvPresenter.getPopularTv();
        return view;
    }

    @Override
    public void showPopularTv(List<Tv> tvPopular) {
        Log.d("checker", "showPopularTv: " + tvPopular);
        viewAdapter = new ViewAdapter(getActivity(), tvPopular);
        viewAdapter.notifyDataSetChanged();
        recyclerPopularTv.setAdapter(viewAdapter);
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
