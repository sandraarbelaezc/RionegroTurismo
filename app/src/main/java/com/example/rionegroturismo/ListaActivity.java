package com.example.rionegroturismo;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ListaActivity extends AppCompatActivity {

    //String[] parques = new String[] {"San Antonio", "Parque2", "Parque3", "Parque4"};

    private Lista_Entrada[] datos = new Lista_Entrada[] {
            new Lista_Entrada(R.drawable.parque1, "Parque San Antonio", "Parque principal de la ciudad", "Cra 34 cll21"),
            new Lista_Entrada(R.drawable.resta1, "Parque2", "Descrip parque2", "Direc parqu2"),
            new Lista_Entrada(R.drawable.resta2, "PArque3", "Descrip parque3", "Direc parque3"),
            new Lista_Entrada(R.drawable.resta3, "Parque4", "Descr", "Dire")
    };

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        list = (ListView) findViewById(R.id.List);

        Adapter adapter = new Adapter(this, datos);

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, parques);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data = ((Lista_Entrada)parent.getItemAtPosition(position)).getNombre();
                Toast.makeText(getApplicationContext(), data,Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(ListaActivity.this, HotelesActivity.class);
                startActivity(intent);
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
}
