package com.example.moviechill.movies.tabfragment.popular;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.domain.model.Tv;
import com.example.moviechill.R;
import com.example.moviechill.adapter.ViewAdapter;
import com.example.moviechill.movies.MoviePresenter;

import java.util.List;

public class PopularMovieFragment extends Fragment implements PopularMovieViewContact {
    RecyclerView recyclerPopularMV;
    ViewAdapter viewAdapter;
    FrameLayout frameLayout;
    MoviePresenter moviePresenter = new MoviePresenter(this);

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_popular_movie, container, false);
        recyclerPopularMV = view.findViewById(R.id.rv_popular_movie);
        frameLayout = view.findViewById(R.id.fr_loading);
        moviePresenter.getMoviePopular();
        return view;
    }

    @Override
    public void showPopularMovie(List<Tv> moviePopular) {
        viewAdapter = new ViewAdapter(getActivity(), moviePopular);
        recyclerPopularMV.setAdapter(viewAdapter);
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
