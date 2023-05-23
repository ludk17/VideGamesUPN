package com.example.vj20231;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView tvMessage;
    private List<Integer> numbers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        tvMessage = this.findViewById(R.id.tvMessage);
        TextView tvSum = this.findViewById(R.id.tvSum);

        Button btn1 = this.findViewById(R.id.btnNumber1);
        Button btn2 = this.findViewById(R.id.btnNumber2);

        Button btn3 = this.findViewById(R.id.btnNumber3);

        Button btnCalc = this.findViewById(R.id.btnCalc);

        btn1.setOnClickListener(view -> {
            addNumber(1);
        });

        btn2.setOnClickListener(view -> {
            addNumber(2);
        });

        btn3.setOnClickListener(view -> {
            addNumber(3);
        });

        btnCalc.setOnClickListener(view -> {
//            int sum = numbers.stream().reduce(0, Integer::sum);
//            tvSum.setText(String.valueOf(sum));

            Intent intent = new Intent(getApplicationContext(), ListaActivity.class);
            startActivity(intent);

        });

    }

    private void addNumber(int number) {
        String text = tvMessage.getText().toString();
        numbers.add(number);
        tvMessage.setText(text + " + " + number);
    }
}