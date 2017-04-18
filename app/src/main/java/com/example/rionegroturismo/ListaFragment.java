package com.example.rionegroturismo;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.ListView;

import static android.R.id.list;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListaFragment extends Fragment {

    Intent intent;

    private Lista_Entrada[] datos = new Lista_Entrada[] {
            new Lista_Entrada(R.drawable.parque1, "Plaza de la libertad", "Parque principal de la ciudad", "Cra 50 Cll 50"),
            new Lista_Entrada(R.drawable.parque2, "Parque Tutucan", "Escenario para la recreación y el deporte", "Cra 55A #35-229"),
            new Lista_Entrada(R.drawable.parque3, "Parque San Francisco", "Patrimonio cultural", "Cll 51 #48-02"),
            new Lista_Entrada(R.drawable.parque4, "Parque San Antonio", "Lugar para disfrutar los postres", "Cra 55A Cll 23")
    };

    public ListaFragment() {

    }

    ListView list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_lista,container,false);

        list = (ListView) view.findViewById(R.id.Lista);

        Adapter adapter = new Adapter(getContext(),datos);
        list.setAdapter(adapter);

        return view;
    }

    public class Adapter extends ArrayAdapter<Lista_Entrada>{

        public Adapter(Context context, Lista_Entrada[] datos) {
            super(context, R.layout.list_item,datos);
        }
    }

}
