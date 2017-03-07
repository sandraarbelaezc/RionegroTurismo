package com.example.rionegroturismo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class PerfilActivity extends AppCompatActivity {

    String username, correo;
    TextView tUsername, tCorreo;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        tUsername = (TextView) findViewById(R.id.tUsername);
        tCorreo = (TextView) findViewById(R.id.tCorreo);

        Bundle extras = getIntent().getExtras();    //Extraigo datos
        username = extras.getString("username");
        correo = extras.getString("correo");

        tUsername.setText(username);
        tCorreo.setText(correo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //Asociarle el menú que le voy a poner
        getMenuInflater().inflate(R.menu.menup, menu);   //Trae los recursos del menú
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {   //Verificar cual menú presionó el usuario
        int id = item.getItemId();

        switch (id){
            case R.id.mCerrarP:
                intent = new Intent(PerfilActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.mPrincipal:
                intent = new Intent(PerfilActivity.this, MainActivity.class);
                intent.putExtra("username", username);  //Le mando el nombre y el correo
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
