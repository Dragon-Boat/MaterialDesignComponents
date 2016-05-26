package com.example.hzzhoulong.materialdesingcomponents;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * @author hzzhoulong
 * @date 2016/5/26.
 */
public class AdapterViewPager extends FragmentPagerAdapter{
    private String[] tabTitle = {"TAB1", "TAB2", "TAB3"};

    private Context mContext;
    public AdapterViewPager(FragmentManager fm, Context context) {
        super(fm);
        this.mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        return ItemFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return tabTitle.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitle[position];
    }
}
