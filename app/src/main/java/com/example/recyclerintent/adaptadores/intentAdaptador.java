package com.example.recyclerintent.adaptadores;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerintent.R;
import com.example.recyclerintent.parametros;

import java.util.List;
import java.util.Objects;

import modelos.Intents;

public class intentAdaptador extends RecyclerView.Adapter<intentAdaptador.viewHolder> {

    List<Intents> I;

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
            if(Objects.equals((String) txtintent.getText(), "camara"))
            {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                view.getContext().startActivity(intent);
            }
            else if(txtintent.getText()=="datos")
            {
                Toast.makeText(view.getContext(),"En mantenimiento",Toast.LENGTH_LONG).show();
            }
            else if(txtintent.getText()=="llamada")
            {
                Toast.makeText(view.getContext(),"En mantenimiento",Toast.LENGTH_LONG).show();
            }
            else if(txtintent.getText()=="youtube")
            {
                Uri webpage = Uri.parse("https://www.youtube.com/watch?v=FK7x3kZZud4");
                Intent intent = new Intent(Intent.ACTION_VIEW,webpage);
                view.getContext().startActivity(intent);
            }
            else if(txtintent.getText()=="facebook")
            {
                Uri webpage = Uri.parse("https://www.facebook.com");
                Intent intent = new Intent(Intent.ACTION_VIEW,webpage);
                view.getContext().startActivity(intent);
            }
            else if(txtintent.getText()=="google")
            {
                Uri webpage = Uri.parse("https://www.google.com");
                Intent intent = new Intent(Intent.ACTION_VIEW,webpage);
                view.getContext().startActivity(intent);
            }
        }

        public void setData(Intents intents) {

            intentHolder = intents;
            txtintent.setText(intents.getName());

        }
    }
}
