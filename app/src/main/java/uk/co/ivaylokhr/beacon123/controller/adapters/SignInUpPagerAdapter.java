package uk.co.ivaylokhr.beacon123.controller.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.ViewGroup;

import uk.co.ivaylokhr.beacon123.view.fragment.FragmentSignIn;
import uk.co.ivaylokhr.beacon123.view.fragment.FragmentSignUp;

/**
 * Created by Ivaylo on 29/10/2016.
 */

public class SignInUpPagerAdapter extends FragmentStatePagerAdapter {

    private Context context;

    public SignInUpPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position)
    {
        Fragment fragment;
        switch (position)
        {
            case 0:
                fragment = FragmentSignIn.newInstance(position);
                break;
            case 1:
                fragment = FragmentSignUp.newInstance(position);
                break;
            default:
                fragment = FragmentSignIn.newInstance(position);
        }

        return fragment;
    }

    @Override
    public int getCount()
    {
        return 2;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object o)
    {
        super.destroyItem(container, position, o);

        if (position <= getCount())
        {
            Fragment fragment = (Fragment) o;

            FragmentManager manager = (fragment).getFragmentManager();
            FragmentTransaction trans = manager.beginTransaction();
            trans.remove(fragment);
            trans.commitAllowingStateLoss();
        }
    }
}