package com.example.rionegroturismo;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

public class HotelesActivity extends AppCompatActivity {

    Intent intent;
    String username, correo;

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter; //Instanciando el objeto de la clase Sec...

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoteles);

        Bundle extras = getIntent().getExtras();    //Extraigo datos
        username = extras.getString("username");
        correo = extras.getString("correo");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); //Cofigurando el toolbar con librerias de soporte
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);   //Permite mover desde abajo

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);   //Se comunica con ViewPager para q quede en el mismo q selecciono en el tab

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id){
            case R.id.mCerrar:
                intent = new Intent(HotelesActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.mHoteles:
                intent = new Intent(HotelesActivity.this, HotelesActivity.class);
                intent.putExtra("username", username);  //Le mando el nombre y el correo
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                break;
            case R.id.mBares:
                intent = new Intent(HotelesActivity.this, BaresActivity.class);
                intent.putExtra("username", username);  //Le mando el nombre y el correo
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                break;
            case R.id.mRestaurantes:
                intent = new Intent(HotelesActivity.this, RestaurantesActivity.class);
                intent.putExtra("username", username);  //Le mando el nombre y el correo
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                break;
            case R.id.mPerfil:
                intent = new Intent(HotelesActivity.this, PerfilActivity.class);
                intent.putExtra("username", username);  //Le mando el nombre y el correo
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */

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
                    HotelDosFragment tab2 = new HotelDosFragment();
                    return tab2;
                case 2:
                    HotelTresFragment tab3 = new HotelTresFragment();
                    return tab3;
                default: return null;
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
    }
}
