package com.example.rionegroturismo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;

public class RegistroActivity extends AppCompatActivity {

    EditText eRUsername, eRContrasena, eRRepContrasena, eRCorreo;
    Button bRegistrar, bCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        eRUsername = (EditText) findViewById(R.id.eRUsername);
        eRContrasena = (EditText) findViewById(R.id.eRContrasena);
        eRRepContrasena =(EditText) findViewById(R.id.eRRepContrasena);
        eRCorreo = (EditText) findViewById(R.id.eRCorreo);
        bRegistrar = (Button) findViewById(R.id.bRegistrar);
        bCancelar = (Button) findViewById(R.id.bCancelar);

        bRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(RegistroActivity.this, LoginActivity.class);

                if(eRContrasena.getText().toString().equals(eRRepContrasena.getText().toString())) {
                    Intent intent = new Intent();   //No tengo q decir para donde voy
                    intent.putExtra("username", eRUsername.getText().toString());
                    intent.putExtra("contrasena", eRContrasena.getText().toString());
                    intent.putExtra("correo", eRCorreo.getText().toString());
                    setResult(RESULT_OK, intent);   //Para verificar q se llenaron los datos
                    finish();   //Cierran las actividades para q no vuelvan a ellas
                }
                    else {
                    Toast.makeText(RegistroActivity.this, "Las contraeñas que ingresaste no coinciden",Toast.LENGTH_SHORT).show();
                }
            }
        });

        bCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(RegistroActivity.this, LoginActivity.class);
                Intent intent = new Intent();
                setResult(RESULT_CANCELED, intent); //Verifica q se canceló
                finish();
            }
        });
    }
}
