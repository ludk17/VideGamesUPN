package com.example.vj20231;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        TextView tvMessage = findViewById(R.id.tvMessage);
        Button btn = findViewById(R.id.btnChangeText);
        EditText editText = findViewById(R.id.editText);

        BtnClick b = new BtnClick();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                tvMessage.setText(text);
            }
        });


    }
}