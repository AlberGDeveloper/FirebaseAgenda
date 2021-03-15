package com.appalber.firebaseagenda;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.appalber.firebaseagenda.entidad.Contacto;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ActivityVistaContactos extends AppCompatActivity {
    ArrayList<Contacto> listacontactos=new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostrar_activity);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Agenda").child("Contactos");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> datos = dataSnapshot.getChildren();
                for(DataSnapshot d: datos){
                    Contacto contactos= d.getValue(Contacto.class);
                    Log.d("Contactos", ": "+contactos);
                    listacontactos.add(contactos);
                    mostrar();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("ERROR", error.getMessage());

            }
        });

    }

    private void mostrar(){
        RecyclerView recy = findViewById(R.id.recycler);
        RecyclerView.LayoutManager gestor = new LinearLayoutManager(this);
        MiAdaptador adaptador = new MiAdaptador(listacontactos);
        recy.setLayoutManager(gestor);
        recy.setAdapter(adaptador);
    }
}
