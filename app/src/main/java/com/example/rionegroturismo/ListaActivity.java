package com.example.rionegroturismo;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ListaActivity extends AppCompatActivity  {

    //String[] parques = new String[] {"San Antonio", "Parque2", "Parque3", "Parque4"};


    private Lista_Entrada[] datos = new Lista_Entrada[] {
            new Lista_Entrada(R.drawable.parque1, "Plaza de la libertad", "Parque principal de la ciudad", "Cra 50 Cll 50"),
            new Lista_Entrada(R.drawable.parque2, "Parque Tutucan", "Escenario para la recreación y el deporte", "Cra 55A #35-229"),
            new Lista_Entrada(R.drawable.parque3, "Parque San Francisco", "Patrimonio cultural", "Cll 51 #48-02"),
            new Lista_Entrada(R.drawable.parque4, "Parque San Antonio", "Lugar para disfrutar los postres", "Cra 55A Cll 23")
    };

    ListView list;
    Intent intent;
    String username, correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        Bundle extras = getIntent().getExtras();    //Extrae los extras q vienen de Login
        username = extras.getString("username");
        correo = extras.getString("correo");

        list = (ListView) findViewById(R.id.List);

        Adapter adapter = new Adapter(this, datos);

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, parques);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data = ((Lista_Entrada)parent.getItemAtPosition(position)).getNombre();
                //Toast.makeText(getApplicationContext(), data,Toast.LENGTH_SHORT).show();

                int sel = (int) parent.getItemIdAtPosition(position);

                switch (sel) {
                    case 0:
                        Toast.makeText(getApplicationContext(), data,Toast.LENGTH_SHORT).show();
                        intent = new Intent(ListaActivity.this, ParqueUnoActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(), data,Toast.LENGTH_SHORT).show();
                        intent = new Intent(ListaActivity.this, ParqueDosActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(), data,Toast.LENGTH_SHORT).show();
                        intent = new Intent(ListaActivity.this, ParqueTresActivity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        Toast.makeText(getApplicationContext(), data,Toast.LENGTH_SHORT).show();
                        intent = new Intent(ListaActivity.this, ParqueCuatroActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });

    }

    class Adapter extends ArrayAdapter<Lista_Entrada>{  //Le pasamos q tpo de datos mandamos

        public Adapter(Context context, Lista_Entrada[] datos) {
            super(context, R.layout.list_item, datos);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.list_item, null);

            TextView nombre = (TextView) item.findViewById(R.id.tNombre);
            nombre.setText(datos[position].getNombre());

            TextView descrip = (TextView) item.findViewById(R.id.tDescrip);
            descrip.setText(datos[position].getDescrip());

            TextView direc = (TextView) item.findViewById(R.id.tDirec);
            direc.setText(datos[position].getDirec());

            ImageView imagen = (ImageView) item.findViewById(R.id.iFoto);
            imagen.setImageResource(datos[position].getIdImagen());

            return item;
        }
    }

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
                intent = new Intent(ListaActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.mHoteles:
                intent = new Intent(ListaActivity.this, HotelesActivity.class);
                intent.putExtra("username", username);  //Le mando el nombre y el correo
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                break;
            case R.id.mBares:
                intent = new Intent(ListaActivity.this, BaresActivity.class);
                intent.putExtra("username", username);  //Le mando el nombre y el correo
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                break;
            case R.id.mRestaurantes:
                intent = new Intent(ListaActivity.this, RestaurantesActivity.class);
                intent.putExtra("username", username);  //Le mando el nombre y el correo
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                break;
            case R.id.mPerfil:
                intent = new Intent(ListaActivity.this, PerfilActivity.class);
                intent.putExtra("username", username);  //Le mando el nombre y el correo
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
