package com.asi.kursasiandek;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Vector;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Fragment2 extends Fragment {

    @BindView(R.id.item_recycler)
    RecyclerView recyclerView;

    private Vector<CardItem> cardItems = new Vector<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fargment2_layout,container,false);
        ButterKnife.bind(this,view);

        setRecyclerView();

        cardItems.add(new CardItem("Title1", "coś", ""));
        cardItems.add(new CardItem("Title2", "Hello world", ""));
        cardItems.add(new CardItem("Title3", "Hello world", ""));

        return view;
    }

    private void setRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new ItemAdapter(cardItems));
    }
}
