package com.mascotas;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Mascota_Adapter extends RecyclerView.Adapter<Mascota_Adapter.ContactoViewHolder> {
    ArrayList<Mascota> contactos;
    Activity activity;

    public Mascota_Adapter(ArrayList<Mascota> contactos, Activity activity){
        this.contactos = contactos;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_mascotas, viewGroup, false);
        return new ContactoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ContactoViewHolder contactoViewHolder, int i) {
        final Mascota contacto = contactos.get(i);
        contactoViewHolder.imagFoto.setImageResource(contacto.getFoto());
        contactoViewHolder.tvNombre.setText(contacto.getNombre());
        contactoViewHolder.tvTotalHuesos.setText(String.valueOf(contacto.getCalificacion()));




        contactoViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contactoViewHolder.tvTotalHuesos.setText(String.valueOf(contacto.getCalificacion() + 1));
                contacto.setCalificacion((contacto.getCalificacion() + 1));

                if (contacto.getNombre() == "Garfield"){
                    Mascota.count1 += 1;
                } else if (contacto.getNombre() == "Bicho") {
                    Mascota.count2 += 1;
                }
                else if (contacto.getNombre() == "Félix") {
                    Mascota.count3 += 1;
                }
                else if (contacto.getNombre() == "Ronaldo") {
                    Mascota.count4 += 1;
                }
                else if (contacto.getNombre() == "Pulga") {
                    Mascota.count5 += 1;
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }



    public static class ContactoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imagFoto;
        private TextView tvNombre;
        private ImageButton btnLike;
        private TextView tvTotalHuesos;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            imagFoto = itemView.findViewById(R.id.imgFoto);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            btnLike = itemView.findViewById(R.id.btnLike);
            tvTotalHuesos = itemView.findViewById(R.id.tvTotalHuesos);
        }
    }
}
