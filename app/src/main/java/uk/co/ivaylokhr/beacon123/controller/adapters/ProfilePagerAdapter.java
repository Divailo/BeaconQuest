package uk.co.ivaylokhr.beacon123.controller.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.ViewGroup;

import uk.co.ivaylokhr.beacon123.view.fragment.FragmentProfileQuests;
import uk.co.ivaylokhr.beacon123.view.fragment.FragmentSignIn;

/**
 * Created by Ivaylo on 29/10/2016.
 */

public class ProfilePagerAdapter extends FragmentStatePagerAdapter {

    private Context context;

    public ProfilePagerAdapter(Context context, FragmentManager fm) {
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
                fragment = FragmentProfileQuests.newInstance(position);
                break;
            //TODO
            case 1:
                fragment = FragmentSignIn.newInstance(position);
                break;
            //TODO
            case 2:
                fragment = FragmentSignIn.newInstance(position);
                break;
            default:
                fragment = FragmentProfileQuests.newInstance(position);
        }

        return fragment;
    }

    @Override
    public int getCount()
    {
        return 3;
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