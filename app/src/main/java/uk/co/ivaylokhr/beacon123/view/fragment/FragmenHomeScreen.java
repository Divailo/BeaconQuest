package uk.co.ivaylokhr.beacon123.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.bclogic.pulsator4droid.library.PulsatorLayout;
import uk.co.ivaylokhr.beacon123.R;
import uk.co.ivaylokhr.beacon123.view.activity.MainActivity;

/**
 * Created by Ivaylo on 29/10/2016.
 */

public class FragmenHomeScreen extends BaseFragment {

    @BindView(R.id.homescreen_profile_button) View profileButton;
    @BindView(R.id.homescreen_magic_button) View magicButton;
    @BindView(R.id.shano) PulsatorLayout pulsatorLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_homescreen, container, false);

        ButterKnife.bind(this, rootView);

        setListeners();

        return rootView;
    }

    private void setListeners(){
        final Fragment selfRef = this;
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)selfRef.getActivity()).onChangeFragment(FragmentProfilePaged.class, new Bundle(), true);
            }
        });

        magicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pulsatorLayout.start();
            }
        });

    }
}
