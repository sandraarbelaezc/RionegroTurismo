package com.example.rionegroturismo;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {

    Intent intent;
    String username, correo;

    private SectionsPagerAdapter mSectionsPagerAdapter; //Instanciando el objeto de la clase Sec...

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       //Toast.makeText(this, "OnCreate", Toast.LENGTH_SHORT).show();

        Bundle extras = getIntent().getExtras();    //Extrae los extras q vienen de Login
        username = extras.getString("username");
        correo = extras.getString("correo");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); //Cofigurando el toolbar con librerias de soporte

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
        mViewPager.setAdapter(mSectionsPagerAdapter);   //Permite mover desde abajo

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);   //Se comunica con ViewPager para q quede en el mismo q selecciono en el tab

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

            intent = new Intent(MainActivity.this, HotelesActivity.class);
            intent.putExtra("username", username);  //Le mando el nombre y el correo
            intent.putExtra("correo", correo);
            startActivity(intent);

            // Handle the camera action
        } else if (id == R.id.nav_bar) {

            intent = new Intent(MainActivity.this, BaresActivity.class);
            intent.putExtra("username", username);  //Le mando el nombre y el correo
            intent.putExtra("correo", correo);
            startActivity(intent);

        } else if (id == R.id.nav_resta) {

            intent = new Intent(MainActivity.this, RestaurantesActivity.class);
            intent.putExtra("username", username);  //Le mando el nombre y el correo
            intent.putExtra("correo", correo);
            startActivity(intent);

        } else if (id == R.id.nav_parque) {

            intent = new Intent(MainActivity.this, MainActivity.class);
            intent.putExtra("username", username);  //Le mando el nombre y el correo
            intent.putExtra("correo", correo);
            startActivity(intent);

        } else if (id == R.id.nav_perfil) {

            intent = new Intent(MainActivity.this, PerfilActivity.class);
            intent.putExtra("username", username);  //Le mando el nombre y el correo
            intent.putExtra("correo", correo);
            startActivity(intent);

        } else if (id == R.id.nav_salir) {

            intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter { //Adaptar fragmentos a una pagina (Clase)

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) { //Coloqueme ta fragmentos---Recibe posicion y retorna fragmento
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            //return PlaceholderFragment.newInstance(position + 1);

            switch (position){
                case 0:
                    HotelUnoFragment tab1 = new HotelUnoFragment();
                    return tab1;
                case 1:
                    HotelDosFragment tab2 = new HotelDosFragment(); //MAPAS
                    return tab2;
                default: return null;
            }
        }

        @Override
        public int getCount() { //Retorna la cantidad de fragmentos a utiizar
            // Show 3 total pages.
            return 2; //Retorna los tres fragmentos q usamos
        }

        @Override
        public CharSequence getPageTitle(int position) {    //Titulo de los fragmentos
            switch (position) {
                case 0:
                    return "Parques";
                case 1:
                    return "Mapas";
            }
            return null;
        }
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

    /*@Override
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
    }*/
}
