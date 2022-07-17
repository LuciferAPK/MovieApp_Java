package com.example.moviechill.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.domain.model.Tv;
import com.example.moviechill.R;
import com.example.moviechill.adapter.ViewAdapter;
import com.example.moviechill.movies.MoviePresenter;
import com.example.moviechill.movies.tabfragment.popular.PopularMovieViewContact;
import com.example.moviechill.tvs.tabfragment.popular.PopularTvViewContact;

import java.util.List;

public class HomeFragment extends Fragment implements HomeViewContact{

    TextView txtOnTV, txtInTheaters, txtToday, txtThisWeek;
    Boolean isCheckOnTv = true, isCheckToday = true;
    Boolean isCheckInTheaters = false, isCheckThisWeek = false;
    RecyclerView recyclerPopular, recyclerTrending;
    FrameLayout frameLayout;
    ViewAdapter viewAdapter;
    HomePresenter homePresenter = new HomePresenter(this);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        Checker();
        homePresenter.getListPopularTv();
        homePresenter.getListTrendingDay();
        return view;
    }

    private void initView(View view) {
        txtOnTV = view.findViewById(R.id.txt_onTv);
        txtInTheaters = view.findViewById(R.id.txt_inTheaters);
        txtToday = view.findViewById(R.id.txt_today);
        txtThisWeek = view.findViewById(R.id.txt_thisWeek);
        recyclerPopular = view.findViewById(R.id.rv_popular);
        recyclerTrending = view.findViewById(R.id.rv_trending);
        frameLayout = view.findViewById(R.id.fr_loading);
    }

    private void Checker() {
        txtOnTV.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View v) {
                if (!isCheckOnTv) {
                    txtOnTV.setBackground(getResources().getDrawable(R.drawable.custom_layout1));
                    txtOnTV.setTextColor(getResources().getColor(R.color.white));
                    txtInTheaters.setBackground(getResources().getDrawable(R.drawable.custom_layout2));
                    txtInTheaters.setTextColor(getResources().getColor(R.color.black));
                    homePresenter.getListPopularTv();
                    isCheckOnTv = true;
                    isCheckInTheaters = false;
                }
            }
        });

        txtInTheaters.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View v) {
                if (!isCheckInTheaters) {
                    txtOnTV.setBackground(getResources().getDrawable(R.drawable.custom_layout2));
                    txtOnTV.setTextColor(getResources().getColor(R.color.black));
                    txtInTheaters.setBackground(getResources().getDrawable(R.drawable.custom_layout1));
                    txtInTheaters.setTextColor(getResources().getColor(R.color.white));
                    homePresenter.getListPopularMovie();
                    isCheckOnTv = false;
                    isCheckInTheaters = true;
                }
            }
        });

        txtToday.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View v) {
                if (!isCheckToday) {
                    txtToday.setBackground(getResources().getDrawable(R.drawable.custom_layout1));
                    txtToday.setTextColor(getResources().getColor(R.color.white));
                    txtThisWeek.setBackground(getResources().getDrawable(R.drawable.custom_layout2));
                    txtThisWeek.setTextColor(getResources().getColor(R.color.black));
                    homePresenter.getListTrendingDay();
                    isCheckToday = true;
                    isCheckThisWeek = false;
                }
            }
        });

        txtThisWeek.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View v) {
                if (!isCheckThisWeek) {
                    txtToday.setBackground(getResources().getDrawable(R.drawable.custom_layout2));
                    txtToday.setTextColor(getResources().getColor(R.color.black));
                    txtThisWeek.setBackground(getResources().getDrawable(R.drawable.custom_layout1));
                    txtThisWeek.setTextColor(getResources().getColor(R.color.white));
                    homePresenter.getListTrendingWeek();
                    isCheckToday = false;
                    isCheckThisWeek = true;
                }
            }
        });
    }

    @Override
    public void showPopularList(List<Tv> listPopular) {
        viewAdapter = new ViewAdapter(getActivity(), listPopular);
        viewAdapter.notifyDataSetChanged();
        recyclerPopular.setAdapter(viewAdapter);
    }

    @Override
    public void showTrendingList(List<Tv> listTrending) {
        viewAdapter = new ViewAdapter(getActivity(), listTrending);
        viewAdapter.notifyDataSetChanged();
        recyclerTrending.setAdapter(viewAdapter);
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