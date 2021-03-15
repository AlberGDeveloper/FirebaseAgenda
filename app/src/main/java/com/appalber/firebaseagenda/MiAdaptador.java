package com.appalber.firebaseagenda;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.appalber.firebaseagenda.entidad.Contacto;

import java.util.ArrayList;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.MiContenedorDeVistas> {
    private ArrayList<Contacto> lista_contactos;
    public MiAdaptador(ArrayList<Contacto> lista_contactos) {
        this.lista_contactos = lista_contactos;
    }
    @NonNull
    @Override
    public MiAdaptador.MiContenedorDeVistas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.mi_adaptador, parent, false);
        MiContenedorDeVistas contenedor = new MiContenedorDeVistas(vista);
        return contenedor;
    }

    @Override
    public void onBindViewHolder(@NonNull MiAdaptador.MiContenedorDeVistas holder, int position) {
        Contacto contactos = lista_contactos.get(position);
        holder.nombre.setText(contactos.getNombre());
        holder.email.setText(contactos.getEmail());
    }

    @Override
    public int getItemCount() {
        return lista_contactos.size();
    }

    public static class MiContenedorDeVistas extends RecyclerView.ViewHolder{
        public TextView nombre, email;

        public MiContenedorDeVistas(View vista) {
            super(vista);
            this.nombre = vista.findViewById(R.id.nombre);
            this.email = vista.findViewById(R.id.email);
        }
    }
}