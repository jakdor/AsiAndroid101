package com.asi.kursasiandek;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Fragment1 extends Fragment {

    @BindView(R.id.button1)
    Button button;
    @BindView(R.id.editBox)
    EditText editText;
    @BindView(R.id.out)
    TextView textView;

    private SharedPreferences sharedPreferences;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment1_layout,container,false);
        ButterKnife.bind(this,view);

        sharedPreferences = getContext().getSharedPreferences(getString(R.string.pref_file), Context.MODE_PRIVATE);
        textView.setText(sharedPreferences.getString(getString(R.string.save_key1),"defaultVal"));

        return view;
    }

    @OnClick(R.id.button1)
    void onButtonClick(){
        String str = editText.getText().toString();
        sharedPreferences.edit().putString(getString(R.string.save_key1), str).apply();
        if (!str.isEmpty()) {
            textView.setText(str);
        }
    }

    @OnClick(R.id.new_activity_button)
    void onNewActivityButtonClick(){
        Intent intent = new Intent(getContext(), Activity2.class);
        startActivity(intent);
    }
}
