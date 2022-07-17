package com.example.moviechill.view.detail.tvdetail;

import android.util.Log;
import com.example.domain.Domain;
import com.example.domain.model.Detail;
import com.example.domain.model.Tv;
import java.util.List;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class TvDetailPresenter {
    Domain domain = new Domain();
    TvDetailViewContact tvDetailViewContact;
    long id;

    public TvDetailPresenter(TvDetailViewContact tvDetailViewContact, long id) {
        this.tvDetailViewContact = tvDetailViewContact;
        this.id = id;
    }

    public void getListTvDetail() {
        domain.getDetailInteractor().getBasicDetailTv(id)
                .subscribeWith(new Observer<Detail>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        tvDetailViewContact.onStartLoading();
                    }

                    @Override
                    public void onNext(@NonNull Detail detail) {
                        tvDetailViewContact.showDetailBasic(detail);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        tvDetailViewContact.onDismissLoading();
                    }
                });
    }

    public void getListTvCast() {
        domain.getDetailInteractor().getTopBilledTv(id)
                .subscribeWith(new Observer<List<Detail>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<Detail> details) {
                        Log.d("checker", "DetailCastTv: " + details);
                        tvDetailViewContact.showDetailCast(details);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getListTvTrailers() {
        domain.getDetailInteractor().getTrailersTv(id)
                .subscribeWith(new Observer<List<Detail>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<Detail> details) {
                        tvDetailViewContact.showTrailers(details);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getListTvRecommendatios() {
        domain.getDetailInteractor().getRecommendationsTv(id)
                .subscribeWith(new Observer<List<Tv>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<Tv> tvList) {
                        tvDetailViewContact.showRecommendations(tvList);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
