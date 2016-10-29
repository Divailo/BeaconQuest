package uk.co.ivaylokhr.beacon123.view.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.ivaylokhr.beacon123.R;
import uk.co.ivaylokhr.beacon123.controller.adapters.SignInUpPagerAdapter;
import uk.co.ivaylokhr.beacon123.controller.listeners.SignInUpTabListener;
import uk.co.ivaylokhr.beacon123.controller.util.ViewPagerTransformer;

/**
 * Created by Ivaylo on 29/10/2016.
 */

public class FragmentSignInUpPaged extends BaseFragment {

    @BindView(R.id.sigin_up_container) ViewPager viewPager;
    @BindView(R.id.sigin_up_bottomtablayout) TabLayout tabLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_signin_up_paged, container, false);

        ButterKnife.bind(this, rootView);

        setUpViewPager();
        setUpTabLayout();

        return rootView;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new SignInUpPagerAdapter(getActivity(), getChildFragmentManager()));

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

        //hardcode stuff
        tabLayout.getTabAt(0).setText("Sign In");
        tabLayout.getTabAt(1).setText("Sign Up");


        tabLayout.addOnTabSelectedListener(new SignInUpTabListener(viewPager));

    }

}
