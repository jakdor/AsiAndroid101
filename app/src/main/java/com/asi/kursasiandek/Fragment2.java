package com.asi.kursasiandek;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asi.kursasiandek.Model.StackQuestions;
import com.asi.kursasiandek.Networking.RetrofitBuilder;
import com.asi.kursasiandek.Networking.StackService;
import com.bumptech.glide.Glide;

import java.util.Vector;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment2 extends Fragment {

    private final String CLASS_TAG = "Fragment2";

    @BindView(R.id.item_recycler)
    RecyclerView recyclerView;

    private StackService stackService;
    private StackQuestions stackQuestions;

    public Fragment2(){
        stackService = RetrofitBuilder.getRetrofit().create(StackService.class);
        getApi();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fargment2_layout,container,false);
        ButterKnife.bind(this,view);

        setRecyclerView();
        return view;
    }

    private void getApi(){
        stackService.getQuestion().enqueue(new Callback<StackQuestions>() {
            @Override
            public void onResponse(Call<StackQuestions> call, Response<StackQuestions> response) {
                if(response.body() != null) {
                    Log.i(CLASS_TAG, "retrofit got api");
                    stackQuestions = response.body();
                    recyclerView.setAdapter(new ItemAdapter(stackQuestions, Glide.with(Fragment2.this)));
                }
            }

            @Override
            public void onFailure(Call<StackQuestions> call, Throwable t) {
                Log.e(CLASS_TAG, "retrofit failed to get api", t);
            }
        });
    }

    private void setRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}
