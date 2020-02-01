package com.ddam40.example.hellokotlin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class VariableJavaActivity extends AppCompatActivity {

    int clickCount = 0;
    long startTime = System.currentTimeMillis();

    TextView startTimeLabel;
    TextView clickCountLabel;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_variable);

        startTimeLabel = findViewById(R.id.startTimeLabel);
        clickCountLabel = findViewById(R.id.clickCountLabel);
        button = findViewById(R.id.button);

        String timeText = new SimpleDateFormat("HH:mm:ss", Locale.KOREA).format(startTime);
        startTimeLabel.setText("Activity 시작시간: " + timeText);
        clickCountLabel.setText("버튼이 클릭된 횟수: " + clickCount);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                clickCount++;
                clickCountLabel.setText("버튼이 클릭된 횟수: " + clickCount);
            }
        });

    }
}
