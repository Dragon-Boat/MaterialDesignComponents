package com.example.hzzhoulong.materialdesingcomponents;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private FloatingActionButton mButton;
    private CollapsingToolbarLayout mCollapsLayout;

    public static void SecondActivityStart(Context context){
        Intent intent = new Intent(context, SecondActivity.class);
        context.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mToolbar = (Toolbar) findViewById(R.id.tooblar_second);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initViews();
    }

    private void initViews() {
        mButton = (FloatingActionButton) findViewById(R.id.FAB_sencond);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams) mCollapsLayout.getLayoutParams();
                int lp = layoutParams.getScrollFlags();
                layoutParams.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL| AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP);
                Toast.makeText(SecondActivity.this, "Done", Toast.LENGTH_SHORT).show();
            }
        });

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mCollapsLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbarlayout_second);
        mCollapsLayout.setTitle(getString(R.string.qyqx));
    }
}
