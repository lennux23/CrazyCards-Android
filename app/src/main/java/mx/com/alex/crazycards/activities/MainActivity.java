package mx.com.alex.crazycards.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import mx.com.alex.crazycards.database.AndroidDatabaseManager;
import mx.com.alex.crazycards.fragments.GameFragment;
import mx.com.alex.crazycards.fragments.NavigationDrawerFragment;
import mx.com.alex.crazycards.R;


public class MainActivity extends ActionBarActivity
    implements NavigationDrawerFragment.NavigationDrawerCallbacks{


    private NavigationDrawerFragment mNavigationDrawerFragment;
    private CharSequence mTitle;
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fm = getSupportFragmentManager();
        setContentView(R.layout.activity_main);


        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();


        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {

        switch (position) {
            case 0:
                mTitle = getString(R.string.title_section1);
                break;
            case 1:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,new GameFragment()).commit();

                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                break;
        }

    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        int id = item.getItemId();

        switch (item.getItemId()) {

            case R.id.action_settings:
                Intent intent = new Intent(this, AndroidDatabaseManager.class);
                startActivity(intent);
                break;
        }
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*   @Override
    public void onStartSelected(Verb word) {
        getSupportFragmentManager().beginTransaction().addToBackStack(null)
                .replace(R.id.container, CityFragment.newInstance(word))
                .commit();

    }*/
}

