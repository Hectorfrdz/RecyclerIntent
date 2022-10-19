package com.example.recyclerintent;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class parametros extends AppCompatActivity {
    public TextView tv1;
    public TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parametros);
        tv1 = (TextView)findViewById(R.id.param);
        tv2 = (TextView)findViewById(R.id.paramEdad);

        String dato = getIntent().getStringExtra("name");
        tv1.setText(dato);
        String edad = getIntent().getStringExtra("phone");
        tv2.setText(edad);
    }
}
