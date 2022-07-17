package com.example.moviechill.movies.tabfragment.upcoming;

import android.os.Bundle;
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

public class UpcomingMovieFragment extends Fragment implements UpcomingMovieViewContact{

    RecyclerView recyclerUpComingMV;
    ViewAdapter viewAdapter;
    FrameLayout frameLayout;
    MoviePresenter moviePresenter = new MoviePresenter(this);

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_upcoming_movie, container, false);
        recyclerUpComingMV = view.findViewById(R.id.rv_upcoming_movie);
        frameLayout = view.findViewById(R.id.fr_loading);
        moviePresenter.getMovieUpcoming();
        return view;
    }

    @Override
    public void showUpcomingMovie(List<Tv> movieUpcoming) {
        viewAdapter = new ViewAdapter(getActivity(), movieUpcoming);
        recyclerUpComingMV.setAdapter(viewAdapter);
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
