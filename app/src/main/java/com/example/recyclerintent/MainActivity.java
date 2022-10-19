package com.example.recyclerintent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;

import com.example.recyclerintent.adaptadores.intentAdaptador;

import java.util.ArrayList;
import java.util.List;

import modelos.Intents;

public class MainActivity extends AppCompatActivity {

    public EditText nombre;
    public EditText telefono;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Intents> intents =new ArrayList<>();

        intents.add(new Intents("camara"));
        intents.add(new Intents("datos"));
        intents.add(new Intents("youtube"));
        intents.add(new Intents("llamada"));
        intents.add(new Intents("google"));
        intents.add(new Intents("facebook"));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        intentAdaptador adapter = new intentAdaptador(intents);
        recyclerView.setAdapter(adapter);
    }
}