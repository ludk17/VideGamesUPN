package com.example.vj20231;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Integer> numbers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        TextView tvMessage = findViewById(R.id.tvMessage);
        TextView tvSum = findViewById(R.id.tvSum);

        Button btn1 = findViewById(R.id.btnNumber1);
        Button btn2 = findViewById(R.id.btnNumber2);
        Button btn3 = findViewById(R.id.btnNumber3);

        Button btnCalc = findViewById(R.id.btnCalc);

        btn1.setOnClickListener(view -> {
            String text = tvMessage.getText().toString();
            numbers.add(1);
            tvMessage.setText(text + " + " + "1");
        });

        btn2.setOnClickListener(view -> {
            String text = tvMessage.getText().toString();
            numbers.add(2);
            tvMessage.setText(text + " + " + "2");
        });

        btn3.setOnClickListener(view -> {
            String text = tvMessage.getText().toString();
            numbers.add(3);
            tvMessage.setText(text + " + " + "3");
        });

        btnCalc.setOnClickListener(view -> {
            int sum = numbers.stream().reduce(0, Integer::sum);
            tvSum.setText(String.valueOf(sum));
        });

    }
}