package com.appalber.firebaseagenda.entidad;

import android.widget.EditText;
import android.widget.ImageView;

public class Contacto {

    private String nombre, email;
    private ImageView foto;

    public Contacto(String nombre, String email, ImageView foto) {
        this.nombre = nombre;
        this.email = email;
        this.foto = foto;
    }

    public Contacto() {
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", foto=" + foto +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ImageView getFoto() {
        return foto;
    }

    public void setFoto(ImageView foto) {
        this.foto = foto;
    }
}