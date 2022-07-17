package com.example.domain;

import com.example.domain.interactor.DetailInteractor;
import com.example.domain.interactor.HomeInteractor;
import com.example.domain.interactor.MovieInteractor;
import com.example.domain.interactor.TvInteractor;
import com.example.domain.interactor.internal.DetailInteractorImpl;
import com.example.domain.interactor.internal.HomeInteractorImpl;
import com.example.domain.interactor.internal.MovieInteractorImpl;
import com.example.domain.interactor.internal.TvInteractorImpl;

public class Domain {

    public DetailInteractor getDetailInteractor() {
        return new DetailInteractorImpl();
    }

    public HomeInteractor getHomeInteractor() {
        return new HomeInteractorImpl();
    }

    public MovieInteractor getMovieInteractor() {
        return new MovieInteractorImpl();
    }

    public TvInteractor getTvInteractor() {
        return new TvInteractorImpl();
    }
}
