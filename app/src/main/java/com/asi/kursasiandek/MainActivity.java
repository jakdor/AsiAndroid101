package com.asi.kursasiandek;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, new Fragment1())
                .commit();
    }

    @OnClick(R.id.frag1)
    void onButton1Click(){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new Fragment1())
                .commit();
    }

    @OnClick(R.id.frag2)
    void onButton2Click(){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new Fragment2())
                .commit();
    }
}
