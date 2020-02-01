package com.ddam40.example.hellokotlin;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class ControlJavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_control);

        ToastUtil.toast("lehooo");
    }
}
