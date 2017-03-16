package com.example.rionegroturismo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    String username, correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       //Toast.makeText(this, "OnCreate", Toast.LENGTH_SHORT).show();

        Bundle extras = getIntent().getExtras();    //Extrae los extras q vienen de Login
        username = extras.getString("username");
        correo = extras.getString("correo");
    }

   /* @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "OnStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "OnPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "OnResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "OnStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "OnRestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "OnDestroy", Toast.LENGTH_SHORT).show();
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //Asociarle el menú que le voy a poner
        getMenuInflater().inflate(R.menu.menu, menu);   //Trae los recursos del menú
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {   //Verificar cual menú presionó el usuario
        int id = item.getItemId();

        switch (id){
            case R.id.mCerrar:
                intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.mHoteles:
                intent = new Intent(MainActivity.this, HotelesActivity.class);
                intent.putExtra("username", username);  //Le mando el nombre y el correo
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                break;
            case R.id.mBares:
                intent = new Intent(MainActivity.this, BaresActivity.class);
                intent.putExtra("username", username);  //Le mando el nombre y el correo
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                break;
            case R.id.mRestaurantes:
                intent = new Intent(MainActivity.this, RestaurantesActivity.class);
                intent.putExtra("username", username);  //Le mando el nombre y el correo
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                break;
            case R.id.mPerfil:
                intent = new Intent(MainActivity.this, PerfilActivity.class);
                intent.putExtra("username", username);  //Le mando el nombre y el correo
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
