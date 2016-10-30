package uk.co.ivaylokhr.beacon123.view.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.ivaylokhr.beacon123.R;
import uk.co.ivaylokhr.beacon123.controller.adapters.ProfilePagerAdapter;
import uk.co.ivaylokhr.beacon123.controller.listeners.SignInUpTabListener;
import uk.co.ivaylokhr.beacon123.controller.util.ViewPagerTransformer;
import uk.co.ivaylokhr.beacon123.view.activity.MainActivity;

/**
 * Created by Ivaylo on 29/10/2016.
 */

public class FragmentProfilePaged extends BaseFragment {

    @BindView(R.id.profile_backbutton) View backButton;
    @BindView(R.id.profile_viewpager) ViewPager viewPager;
    @BindView(R.id.myprofile_tablayout_top) TabLayout tabLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile_paged, container, false);

        ButterKnife.bind(this, rootView);

        setListeners();
        setUpViewPager();
        setUpTabLayout();


        return rootView;
    }

    private void setListeners(){
        final Fragment selfRef = this;
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)selfRef.getActivity()).onChangeFragment(FragmentHomeScreen.class, new Bundle(), false);
            }
        });
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new ProfilePagerAdapter(getActivity(), getChildFragmentManager()));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int arg0) {}
            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {}
            @Override
            public void onPageScrollStateChanged(int arg0) {}
        });

        viewPager.setPageTransformer(true, new ViewPagerTransformer());

        viewPager.setOffscreenPageLimit(3);

    }

    private void setUpTabLayout(){
        tabLayout.getTabAt(0).select();
        tabLayout.setupWithViewPager(viewPager);

        //hardcoded stuff
        tabLayout.getTabAt(0).setText("Quests");
        tabLayout.getTabAt(1).setText("Friends");
        tabLayout.getTabAt(2).setText("Leaderboard");

        tabLayout.addOnTabSelectedListener(new SignInUpTabListener(viewPager));

    }


}
