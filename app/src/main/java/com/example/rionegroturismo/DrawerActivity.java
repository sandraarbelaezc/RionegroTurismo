package com.example.rionegroturismo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class DrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Intent intent;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);      //Método q está obsoleto, pero si funciona
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


/*
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        HotelUnoFragment fragment = new HotelUnoFragment();
        ft.add(R.id.contenedorFragment, fragment).commit();

        HotelDosFragment fragment1 = new HotelDosFragment();
        ft.add(R.id.contenedorFragment, fragment1).commit();

        HotelTresFragment fragment2 = new HotelTresFragment();
        ft.add(R.id.contenedorFragment, fragment2).commit();*/
        
    }

   /* public class SectionsPagerAdapter extends FragmentPagerAdapter { //Adaptar fragmentos a una pagina (Clase)

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) { //Coloqueme ta fragmentos---Recibe posicion y retorna fragmento
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            //return PlaceholderFragment.newInstance(position + 1);

            switch (position) {
                case 0:
                    HotelUnoFragment tab1 = new HotelUnoFragment();
                    return tab1;
                case 1:
                    HotelDosFragment tab2 = new HotelDosFragment();
                    return tab2;
                case 2:
                    HotelTresFragment tab3 = new HotelTresFragment();
                    return tab3;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() { //Retorna la cantidad de fragmentos a utiizar
            // Show 3 total pages.
            return 3; //Retorna los tres fragmentos q usamos
        }

        @Override
        public CharSequence getPageTitle(int position) {    //Titulo de los fragmentos
            switch (position) {
                case 0:
                    return "Santiago de Arma";
                case 1:
                    return "Boutique el Cortijo de la Riviera";
                case 2:
                    return "Bosques del Llano";
                //return getResources().getString(R.string.hotel2);
            }
            return null;
        }
    }*/

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_hotel) {

            intent = new Intent(DrawerActivity.this, HotelesActivity.class);
            startActivity(intent);

            // Handle the camera action
        } else if (id == R.id.nav_bar) {

            intent = new Intent(DrawerActivity.this, BaresActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_resta) {

            intent = new Intent(DrawerActivity.this, RestaurantesActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_parque) {

            intent = new Intent(DrawerActivity.this, ListaActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_perfil) {

            intent = new Intent(DrawerActivity.this, PerfilActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_salir) {

            intent = new Intent(DrawerActivity.this, LoginActivity.class);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
