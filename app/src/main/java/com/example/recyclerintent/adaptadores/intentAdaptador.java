package com.example.recyclerintent.adaptadores;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerintent.R;
import com.example.recyclerintent.parametros;

import java.util.List;
import java.util.Objects;

import modelos.Intents;

public class intentAdaptador extends RecyclerView.Adapter<intentAdaptador.viewHolder> {

    List<Intents> I;
    int request_code = 200;

    public intentAdaptador(List<Intents>I){this.I = I;}

    @NonNull
    @Override
    public intentAdaptador.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.design,parent,false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.setData(I.get(position));
    }

    @Override
    public int getItemCount() {
        return I.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView txtintent;
        Intents intentHolder;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            txtintent = (TextView)itemView.findViewById(R.id.accion);
            itemView.setOnClickListener(this::onClick);

        }

        private void onClick(View view) {
            view.getContext().startActivity(intentHolder.getAction());
        }

        public void setData(Intents intents) {

            intentHolder = intents;
            txtintent.setText(intents.getName());

        }
    }
}
