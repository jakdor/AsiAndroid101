package com.asi.kursasiandek;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.button1)
    Button button;
    @BindView(R.id.editBox)
    EditText editText;
    @BindView(R.id.out)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button1)
    void onButtonClick(){
        String str = editText.getText().toString();
        if (!str.isEmpty()) {
            textView.setText(str);
        }
    }
}
