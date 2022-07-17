package com.example.moviechill.tvs.tabfragment.ontv;

import com.example.domain.model.Tv;

import java.util.List;

public interface OnTvViewContact {
    void showOnTVTv(List<Tv> tvOnTv);

    void onStartLoading();

    void onDismissLoading();
}
