package com.example.rionegroturismo;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

public class RestaurantesActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    Intent intent;
    String username, correo;

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurantes);

        Bundle extras = getIntent().getExtras();    //Extraigo datos
        username = extras.getString("username");
        correo = extras.getString("correo");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);      //Método q está obsoleto, pero si funciona
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }

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

            intent = new Intent(RestaurantesActivity.this, HotelesActivity.class);
            intent.putExtra("username", username);  //Le mando el nombre y el correo
            intent.putExtra("correo", correo);
            startActivity(intent);

            // Handle the camera action
        } else if (id == R.id.nav_bar) {

            intent = new Intent(RestaurantesActivity.this, BaresActivity.class);
            intent.putExtra("username", username);  //Le mando el nombre y el correo
            intent.putExtra("correo", correo);
            startActivity(intent);

        } else if (id == R.id.nav_resta) {

            intent = new Intent(RestaurantesActivity.this, RestaurantesActivity.class);
            intent.putExtra("username", username);  //Le mando el nombre y el correo
            intent.putExtra("correo", correo);
            startActivity(intent);

        } else if (id == R.id.nav_parque) {

            intent = new Intent(RestaurantesActivity.this, ListaActivity.class);
            intent.putExtra("username", username);  //Le mando el nombre y el correo
            intent.putExtra("correo", correo);
            startActivity(intent);

        } else if (id == R.id.nav_perfil) {

            intent = new Intent(RestaurantesActivity.this, PerfilActivity.class);
            intent.putExtra("username", username);  //Le mando el nombre y el correo
            intent.putExtra("correo", correo);
            startActivity(intent);

        } else if (id == R.id.nav_salir) {

            intent = new Intent(RestaurantesActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id){
            case R.id.mCerrar:
                intent = new Intent(RestaurantesActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.mHoteles:
                intent = new Intent(RestaurantesActivity.this, HotelesActivity.class);
                intent.putExtra("username", username);  //Le mando el nombre y el correo
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                break;
            case R.id.mBares:
                intent = new Intent(RestaurantesActivity.this, BaresActivity.class);
                intent.putExtra("username", username);  //Le mando el nombre y el correo
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                break;
            case R.id.mRestaurantes:
                intent = new Intent(RestaurantesActivity.this, RestaurantesActivity.class);
                intent.putExtra("username", username);  //Le mando el nombre y el correo
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                break;
            case R.id.mPerfil:
                intent = new Intent(RestaurantesActivity.this, PerfilActivity.class);
                intent.putExtra("username", username);  //Le mando el nombre y el correo
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
*/

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            //return PlaceholderFragment.newInstance(position + 1);
            switch (position){
                case 0:
                    RestauranteUnoFragment tab1 = new RestauranteUnoFragment();
                    return tab1;
                case 1:
                    RestauranteDosFragment tab2 = new RestauranteDosFragment();
                    return tab2;
                case 2:
                    RestauranteTresFragment tab3 = new RestauranteTresFragment();
                    return tab3;
                case 3:
                    MapaRFragment tab4 = new MapaRFragment();
                    return tab4;
                default: return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "El Rancherito";
                case 1:
                    return "Raffaello's pizza";
                case 2:
                    return "Di Vino";
                case 3:
                    return "Mapas";
            }
            return null;
        }
    }
}
