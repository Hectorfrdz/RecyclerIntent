package com.example.recyclerintent;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class parametros extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parametros);

        TextView vista = findViewById(R.id.paramEdad);

        new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int d = (int) millisUntilFinished;
                vista.setText("" + d / 1000);
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(parametros.this,MainActivity.class);
                startActivity(intent);
            }
        }.start();
    }
}
