package tw.radiation;

import tw.radiation.R;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

public class MainActivity extends Activity {
    private DrawerLayout mLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private ListView mDrawerList;

    private CharSequence mTitle;
    private String[] mNames;

    private static int IDX_FRAG_MAIN = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        mTitle = getTitle();
        mLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList =  (ListView) findViewById(R.id.left_menu);

        mNames = new String[2];
        mNames[IDX_FRAG_MAIN] = getString(R.string.list_name_main);
        mNames[1] = getString(R.string.list_name_about);

        mDrawerList.setAdapter(new ArrayAdapter<CharSequence>(this,
                    R.layout.drawer_list_item, mNames));
        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mLayout,
                R.drawable.ic_drawer,
                R.string.drawer_open,
                R.string.drawer_close
                ){

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getActionBar().setTitle(mTitle);
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActionBar().setTitle(mTitle);
            }
        };

        mLayout.setDrawerListener(mDrawerToggle);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        if (savedInstanceState == null) {
            switchFragment(IDX_FRAG_MAIN);
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void switchFragment(int position) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        Fragment fragment = null;
        if (position == IDX_FRAG_MAIN) {
            fragment = new MainFrag();
        }
        if (fragment != null) {
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }
    }
}

