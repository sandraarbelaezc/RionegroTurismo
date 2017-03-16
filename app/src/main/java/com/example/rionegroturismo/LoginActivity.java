package com.example.rionegroturismo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText eUsername, eContrasena;
    Button bIniciar;
    TextView tRegistrese;
    String username, password, correo;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

   /*     Bundle extras = getIntent().getExtras();

        username = extras.getString("username");
        password = extras.getString("contrasena");
        correo = extras.getString("correo"); */

        eUsername = (EditText) findViewById(R.id.eUsername);
        eContrasena = (EditText) findViewById(R.id.eContrasena);
        bIniciar = (Button) findViewById(R.id.bInciar);
        tRegistrese = (TextView) findViewById(R.id.tRegistrese);

        tRegistrese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(LoginActivity.this, RegistroActivity.class); //De Login a Registro
                startActivityForResult(intent, 1234); //Estamos esperando respuesta
            }
        });

        bIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(eUsername.getText().toString().equals(username) &&
                        eContrasena.getText().toString().equals(password)){

                    intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("username", username);  //Le mando los datos de Login a MainActivity
                    intent.putExtra("correo", correo);
                    startActivity(intent); //Porque no estamos esperando respuesta
                }

                else if(!eUsername.getText().toString().equals(username) ||
                        !eContrasena.getText().toString().equals(password)){

                    Toast.makeText(LoginActivity.this, "Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();
                }
                finish();

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1234 && resultCode == RESULT_OK){
            username = data.getExtras().getString("username");
            password = data.getExtras().getString("contrasena");
            correo = data.getExtras().getString("correo");
            Log.d("username", username);
        } else {
            if(requestCode == 1234 && resultCode == RESULT_CANCELED){
                Toast.makeText(this, "ERROR en Registro", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
