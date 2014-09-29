package com.iagl.newvlille.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.iagl.newvlille.fragment.AllFragment;
import com.iagl.newvlille.fragment.MapFragment;
 
public class TabsPagerAdapter extends FragmentPagerAdapter {
 
    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }
 
    @Override
    public Fragment getItem(int index) {
 
        switch (index) {
        case 0:
            // All station fragment activity
            return new AllFragment();
        case 1:
            // Map fragment activity
            return new MapFragment();
        }
 
        return null;
    }

    
    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 2;
    }
 
}