package com.appalber.firebaseagenda;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.appalber.firebaseagenda.entidad.Contacto;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AltaContactos extends AppCompatActivity {

    EditText nombre, email;
    ImageView foto;
    Button boton;
    Context contexto = this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alta_activity);
        nombre = findViewById(R.id.et_nombre);
        email = findViewById(R.id.et_email);
        foto = findViewById(R.id.imafoto);
        boton = findViewById(R.id.btn_altacontacto);
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://fir-agenda-bb146-default-rtdb.firebaseio.com/");
        DatabaseReference myRef = database.getReference("Agenda").child("Contactos");
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contacto contactos = new Contacto();
                contactos.setNombre(nombre.getText().toString());
                contactos.setEmail(email.getText().toString());
                if(nombre.length()>0 && email.length()>0) {
                    myRef.push().setValue(contactos);
                    AlertDialog.Builder builder = new AlertDialog.Builder(contexto);
                    builder.setTitle("CONTACTO CREADO");
                    builder.setMessage("Contacto creado con éxito");
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(contexto);
                    builder.setTitle("ERROR");
                    builder.setMessage("Debes rellenar ambos campos");
                    AlertDialog dialog = builder.create();
                    dialog.show();
                    Toast.makeText(getApplicationContext(),"Debes rellenar ambos campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
        

    }
}
