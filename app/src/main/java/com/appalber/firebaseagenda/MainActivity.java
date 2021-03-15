
package com.appalber.firebaseagenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button alta = findViewById(R.id.btn_alta);
        Button muestra = findViewById(R.id.btn_mostrar);

        alta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.appalber.firebaseagenda.MainActivity.this, AltaContactos.class);
                startActivity(intent);
            }
        });

        muestra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.appalber.firebaseagenda.MainActivity.this, ActivityVistaContactos.class);
                startActivity(intent);
            }
        });


    }
}