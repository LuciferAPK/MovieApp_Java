package com.example.moviechill.tvs.tabfragment.ontv;

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

public class OnTVFragment extends Fragment implements OnTvViewContact {
    RecyclerView recyclerOnTv;
    ViewAdapter viewAdapter;
    FrameLayout frameLayout;
    TvPresenter tvPresenter = new TvPresenter(this, getContext());

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ontv, container, false);
        recyclerOnTv = view.findViewById(R.id.rv_onTv);
        frameLayout = view.findViewById(R.id.fr_loading);
        tvPresenter.getOnTV();
        return view;
    }

    @Override
    public void showOnTVTv(List<Tv> tvOnTv) {
        viewAdapter = new ViewAdapter(getActivity(), tvOnTv);
        viewAdapter.notifyDataSetChanged();
        recyclerOnTv.setAdapter(viewAdapter);
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
