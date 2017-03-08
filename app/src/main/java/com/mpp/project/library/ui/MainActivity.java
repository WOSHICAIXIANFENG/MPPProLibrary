package com.mpp.project.library.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.mpp.project.library.AppConfig;
import com.mpp.project.library.R;
import com.mpp.project.library.util.SPUtil;

import java.util.Set;

import static com.mpp.project.library.R.id.nav_checkout;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, INavigate {
    private Toolbar mToolbar;
    private Fragment mCurrentFragment;
    private NavigationView mNavigationView;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(this);

        // Get permission from SP
        initSelectedItemByPermit();
    }

    private void initSelectedItemByPermit() {
        Set<String> permits = SPUtil.getStringSetPreferences(this, AppConfig.KEY_SP_PERMISSION_LIST);
        if (permits != null) {
            if (permits.contains(AppConfig.PERMISSION_CHECKOUT)) {
                mNavigationView.setCheckedItem(R.id.nav_checkout);
            } else if (permits.contains(AppConfig.PERMISSION_ADD_BOOK)) {
                mNavigationView.setCheckedItem(R.id.nav_addBook);
            } else if (permits.contains(AppConfig.PERMISSION_ADD_MEMBER)) {
                mNavigationView.setCheckedItem(R.id.nav_editMember);
            }
        }
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

    public void toggleDrawer() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            drawer.openDrawer(GravityCompat.START);
        }
    }

    // done/save/submit item
    private MenuItem mDoneAction;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        // done/save/submit item
        mDoneAction = menu.getItem(0);
        mDoneAction.setVisible(false);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_down) {
            // todo
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == nav_checkout) {
            // Handle the check out action
            // use check out fragment to replace
            mCurrentFragment = new CheckoutFragment();
            getFragmentManager().beginTransaction().addToBackStack("CheckoutFragment").replace(R.id.frame_content, mCurrentFragment).commit();
            mToolbar.setTitle("Check Out");

        } else if (id == R.id.nav_editMember) {
            mCurrentFragment = new AddAMemberFragment();
            getFragmentManager().beginTransaction().addToBackStack("AddAMemberFragment").replace(R.id.frame_content, mCurrentFragment).commit();
            mToolbar.setTitle("Add new member");

        } else if (id == R.id.nav_addBook) {
            mCurrentFragment = new AddBookFragment();
            getFragmentManager().beginTransaction().addToBackStack("AddBookFragment").replace(R.id.frame_content, mCurrentFragment).commit();
            mToolbar.setTitle("Add New Book");

        } else if (id == R.id.nav_addCopy) {
            // todo by

        } else if (id == R.id.nav_logout) {
            // todo by

        } else if (id == R.id.nav_setting) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void openAddAuthorPage() {
        mCurrentFragment = new AddAuthorDialog();
        getFragmentManager().beginTransaction().addToBackStack("AddAuthorDialog").replace(R.id.frame_content, mCurrentFragment).commit();
        mToolbar.setTitle("Add one author");

        // show back icon
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        mDoneAction.setVisible(true);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCurrentFragment instanceof AddAuthorDialog) {
                    getFragmentManager().popBackStackImmediate();
                    mCurrentFragment = getFragmentManager().findFragmentById(R.id.frame_content);
                    mToolbar.setNavigationIcon(R.drawable.ic_menu_white_24dp);
                    mDoneAction.setVisible(false);
                } else {
                    // todo
                    toggleDrawer();
                }
            }
        });
    }

    @Override
    public void closeAddAuthorPage() {

    }
}
