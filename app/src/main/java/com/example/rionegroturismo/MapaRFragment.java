package com.example.rionegroturismo;


import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapaRFragment extends Fragment implements OnMapReadyCallback {

    private MapView mapView;
    private GoogleMap mMap;

    public MapaRFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mapa_h, container, false); //Ya no retorna si no q la almaceno en alguna parte para poderla manejar, por eso se hace en objeto tipo View

        mapView = (MapView) view.findViewById(R.id.map); //Con este ya puedo acceder a la info q yo quiero, en este caso el mapa
        mapView.onCreate(savedInstanceState);

        mapView.getMapAsync(this);     //Sincronizamos para cargar el mapa...

        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        if (ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);    //Activa la geolocalización

        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID); //Cambia el tipo de mapa q estoy usando

        // Add a marker in Sydney and move the camera
        LatLng Ranch = new LatLng(6.1782836,-75.4435592);
        mMap.addMarker(new MarkerOptions().position(Ranch).title("El Rancherito"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Ranch,11));

        LatLng Pizza = new LatLng(6.1305238,-75.3826907);
        mMap.addMarker(new MarkerOptions().position(Pizza).title("Raffaello's Pizza"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Pizza,11));

        LatLng DiVino = new LatLng(6.1294464,-75.3821869);
        mMap.addMarker(new MarkerOptions().position(DiVino).title("Di Vino"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(DiVino,11));

        /*LatLng udea = new LatLng(6.266953, -75.569111);
        mMap.addMarker(new MarkerOptions().position(udea).title("Universidad de Antioquia").icon(BitmapDescriptorFactory.fromResource(R.drawable.icono)).snippet("Nuestra Alma Mater"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(udea, 15));*/
    }

    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        mapView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        mapView.onLowMemory();
        super.onLowMemory();
    }
}