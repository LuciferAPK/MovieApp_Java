package com.example.moviechill.tvs.tabfragment.airingtoday;

import com.example.domain.model.Tv;

import java.util.List;

public interface AiringTodayTvViewContact {
    void showAiringTodayTv(List<Tv> tvAiringToday);

    void onStartLoading();

    void onDismissLoading();
}
