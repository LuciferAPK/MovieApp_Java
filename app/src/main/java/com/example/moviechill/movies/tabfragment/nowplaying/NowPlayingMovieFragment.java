package com.example.moviechill.movies.tabfragment.nowplaying;

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

public class NowPlayingMovieFragment extends Fragment implements NowPlayingMovieViewContact {

    RecyclerView recyclerNowPlayingMV;
    ViewAdapter viewAdapter;
    FrameLayout frameLayout;
    MoviePresenter moviePresenter = new MoviePresenter(this);

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nowplaying_movie, container, false);
        recyclerNowPlayingMV = view.findViewById(R.id.rv_nowplaying_movie);
        frameLayout = view.findViewById(R.id.fr_loading);
        moviePresenter.getMovieNowPlaying();
        return view;
    }

    @Override
    public void showNowPlayingMovie(List<Tv> movieNowPlaying) {
        viewAdapter = new ViewAdapter(getActivity(), movieNowPlaying);
        viewAdapter.notifyDataSetChanged();
        recyclerNowPlayingMV.setAdapter(viewAdapter);
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
