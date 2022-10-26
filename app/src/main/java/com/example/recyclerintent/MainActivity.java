package com.example.recyclerintent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
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

        intents.add(new Intents("youtube",new Intent(Intent.ACTION_VIEW, Uri.parse
                ("https://www.youtube.com"))));
        intents.add(new Intents("camara",new Intent(MediaStore.ACTION_IMAGE_CAPTURE)));
        intents.add(new Intents("facebook",new Intent(Intent.ACTION_VIEW, Uri.parse
                ("https://www.facebook.com"))));
        intents.add(new Intents("google",new Intent(Intent.ACTION_VIEW, Uri.parse
                ("https://www.google.com"))));
        intents.add(new Intents("llamada",new Intent(Intent.ACTION_CALL,Uri.parse("tel: 8721371167"))));
        intents.add(new Intents("otro activity",new Intent(this,parametros.class)));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        intentAdaptador adapter = new intentAdaptador(intents);
        recyclerView.setAdapter(adapter);
    }
}