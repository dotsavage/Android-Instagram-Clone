package com.example.android.instagram.Profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.support.v4.app.Fragment;

import com.example.android.instagram.R;
import com.example.android.instagram.Utils.BottomNavigationViewHelper;
import com.example.android.instagram.Utils.SectionStatePagerAdapter;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

/**
 * Created by sehajpalsingh on 31/03/18.
 */

public class OptionActivity extends AppCompatActivity {

    private final int ACTIVITY_NUM = 4;

    private static final String TAG = "OptionActivity";

    private SectionStatePagerAdapter mPagerAdapter;

    private ViewPager mViewPager;
    private RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts_setting);

        ImageView backArrow = findViewById(R.id.back_arrow);
        Log.d(TAG, "onCreate: started.");

        mViewPager =  findViewById(R.id.container);
        mRelativeLayout = findViewById(R.id.relLayout1);

        setupBottomNavigationView();
        setupFragment();

        setupSettings();


        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OptionActivity.this,ProfileActivity.class);
                startActivity(intent);
                Log.d(TAG, "onClick: navigating back to 'ProfileActivity'");
                finish();
            }
        });
    }

    private void setupFragment(){
        mPagerAdapter = new SectionStatePagerAdapter(getSupportFragmentManager());
        mPagerAdapter.addFragment(new EditProfileFragment(),getString(R.string.edit_profile));
        mPagerAdapter.addFragment(new SignOutFragment(),getString(R.string.sign_out));
    }

    private void setViewPager(int FragmnetNumber){
        mRelativeLayout.setVisibility(View.GONE);
        mViewPager.setAdapter(mPagerAdapter);

        Log.d(TAG, "setViewPager: navigating to fragment #: " + FragmnetNumber);

        mViewPager.setCurrentItem(FragmnetNumber);
    }

    private void setupBottomNavigationView(){
        Log.d(TAG, "setupBottomNavigationView: setting up Bottom navigation view");
        BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(OptionActivity.this,bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }

    private void setupSettings(){
        Log.d(TAG, "setupSettingsList: initializing 'Account Settings' list.");

        ListView listView = findViewById(R.id.ListViewAccountSetting);

        ArrayList<String> options = new ArrayList<>();
        options.add(getString(R.string.edit_profile));
        options.add(getString(R.string.sign_out));

        ArrayAdapter adapter = new ArrayAdapter(OptionActivity.this, android.R.layout.simple_list_item_1,options);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "onItemClick: navigating to fragment#: " + position);
                setViewPager(position);
            }
        });


    }

}
