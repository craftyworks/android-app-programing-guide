package com.ddam40.example.hellokotlin;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BmiJavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_view_binding);

        findViewById(R.id.bmiButton).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText tallField = findViewById(R.id.tallField);
                String tall = tallField.getText().toString();

                EditText weightField = findViewById(R.id.weightField);
                String weight = weightField.getText().toString();

                double bmi =  Double.parseDouble(weight) / Math.pow(Double.parseDouble(tall) / 100.0, 2);

                TextView resultLabel = findViewById(R.id.resultLabel);
                resultLabel.setText("키: " + tall + ", 체중: " + weight + ", BMI: " + bmi);
            }
        });
    }
}
