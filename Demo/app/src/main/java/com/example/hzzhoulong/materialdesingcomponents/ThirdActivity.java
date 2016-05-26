package com.example.hzzhoulong.materialdesingcomponents;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.hzzhoulong.materialdesingcomponents.dummy.DummyContent;

public class ThirdActivity extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener{
    private Toolbar mToolbar;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private FloatingActionButton mActionButton;
    private RecyclerView mRecyclerView;

    public static void ThirdActivityStart(Context context) {
        Intent intent = new Intent(context, ThirdActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        mToolbar = (Toolbar) findViewById(R.id.tooblar_third);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        initViews();


    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }

    private void initViews() {

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mTabLayout = (TabLayout) findViewById(R.id.tab_viewpager);
//        mActionButton = (FloatingActionButton) findViewById(R.id.FAB_third);


        final AdapterViewPager mAdapter = new AdapterViewPager(getSupportFragmentManager(), this);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

//        mRecyclerView = (RecyclerView) findViewById(R.id.list);
//
//
//        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
//                    mActionButton.show();
//                }
//                super.onScrollStateChanged(recyclerView,newState);
//            }
//
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                if (dy > 0 || dy < 0 && mActionButton.isShown()) {
//                    mActionButton.hide();
//                }
//            }
//        });


    }

}
