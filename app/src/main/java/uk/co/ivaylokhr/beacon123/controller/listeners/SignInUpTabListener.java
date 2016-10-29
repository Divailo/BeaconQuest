package uk.co.ivaylokhr.beacon123.controller.listeners;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

/**
 * Created by Ivaylo on 29/10/2016.
 */

public class SignInUpTabListener implements TabLayout.OnTabSelectedListener {

    private ViewPager vp;

    public SignInUpTabListener(ViewPager viewPager) {
        vp = viewPager;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        vp.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}