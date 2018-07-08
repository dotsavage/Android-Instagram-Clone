package com.example.android.instagram.Utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sehajpalsingh on 30/03/18.
 */

public class SectionPagesAdapter extends FragmentPagerAdapter {
    private static final String TAG = "SectionPagesAdapter";

    private final List<Fragment> mFragmentList = new ArrayList<>();

    public SectionPagesAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }


    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFragment(Fragment fragment){
        mFragmentList.add(fragment);
    }


}
