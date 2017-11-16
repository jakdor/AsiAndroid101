package com.asi.kursasiandek;

import android.content.Intent;
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment1_layout,container,false);
        ButterKnife.bind(this,view);
        return view;
    }

    @OnClick(R.id.button1)
    void onButtonClick(){
        String str = editText.getText().toString();
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
