package com.example.hzzhoulong.materialdesingcomponents;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private NavigationView mNavigationView;
    private FloatingActionButton mActionButton;
    private CoordinatorLayout mMainLayout;

    public static void MainActivityStart(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        initViews();

    }


    private void initViews() {
        mMainLayout = (CoordinatorLayout) findViewById(R.id.main_container);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this,
                mDrawerLayout,
                mToolbar,
                R.string.open_string,
                R.string.close_string);
        mDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_layout);
        setupDrawerClick(mNavigationView);
        setupFAB();


    }

    private void setupFAB() {
        mActionButton = (FloatingActionButton) findViewById(R.id.FAB_main);
        mActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(mMainLayout, "FAB FBA", Snackbar.LENGTH_SHORT)
                        .setAction("TODO", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "Nothing", Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        });
    }

    private void setupDrawerClick(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem item) {

                        switch (item.getItemId()) {

                            case R.id.Item_1:
                                break;
                            case R.id.Item_2:
                                SecondActivity.SecondActivityStart(MainActivity.this);
                                break;
                            case R.id.Item_3:
                                ThirdActivity.ThirdActivityStart(MainActivity.this);
                                break;
                            case R.id.Item_4:

                                break;

                        }

                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                }
        );
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
