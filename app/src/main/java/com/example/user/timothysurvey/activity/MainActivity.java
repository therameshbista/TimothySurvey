package com.example.user.timothysurvey.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.timothysurvey.R;

import java.util.ArrayList;
import java.util.List;

import fragment.Ongoing;
import fragment.Result;
import fragment.Upcomming;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private Toolbar toolbar;
    TextView deadLine;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] tabIcons = {
            R.mipmap.ongoing,
            R.mipmap.upcoming,
            R.mipmap.results
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        deadLine= (TextView) findViewById(R.id.deadline);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setPadding(0, getStatusBarHeight(), 0, 0);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setSelectedTabIndicatorHeight(0);

        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();


    }

    private void setupTabIcons() {
        LayoutInflater inflater = LayoutInflater.from(this);

        View view1 = inflater.inflate(R.layout.custom_tabs, null, false);
        ((TextView) view1.findViewById(R.id.text)).setText("Ongoing");
        ((ImageView) view1.findViewById(R.id.image)).setImageResource(tabIcons[0]);


        View view2 = inflater.inflate(R.layout.custom_tabs, null, false);
        ((TextView) view2.findViewById(R.id.text)).setText("Upcomming");
        ((ImageView) view2.findViewById(R.id.image)).setImageResource(tabIcons[1]);

        View view3 = inflater.inflate(R.layout.custom_tabs, null, false);
        ((TextView) view3.findViewById(R.id.text)).setText("Results");
        ((ImageView) view3.findViewById(R.id.image)).setImageResource(tabIcons[2]);

        tabLayout.getTabAt(0).setCustomView(view1);
        tabLayout.getTabAt(1).setCustomView(view2);
        tabLayout.getTabAt(2).setCustomView(view3);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new Ongoing(), "Ongoing");
        adapter.addFrag(new Upcomming(), "Upcomming");
        adapter.addFrag(new Result(), "Result");
        viewPager.setAdapter(adapter);
    }





    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPageSelected(int position) {

        if( position == 0){
            deadLine.setVisibility(View.VISIBLE);
        }
        else if(position == 1){
            deadLine.setText("The Next Survey Opens at Dec 31,2016 at 2:00pm GMT");
        }
        else if(position == 2){
            deadLine.setVisibility(View.GONE);
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
