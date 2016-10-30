package uk.co.ivaylokhr.beacon123.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.ivaylokhr.beacon123.R;
import uk.co.ivaylokhr.beacon123.controller.util.SharedPref;
import uk.co.ivaylokhr.beacon123.view.activity.MainActivity;

/**
 * Created by Ivaylo on 29/10/2016.
 */

public class FragmentSignIn extends BaseFragment {

    @BindView(R.id.signin_button) Button signInButton;

    public FragmentSignIn() {
    }

    public static FragmentSignIn newInstance(int pos) {
        FragmentSignIn fragmentMyProfile = new FragmentSignIn();

        Bundle args = new Bundle();
        args.putInt("pos", pos);
        fragmentMyProfile.setArguments(args);

        return fragmentMyProfile;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_signin, container, false);
        ButterKnife.bind(this, rootView);

        setListeners();

        Log.d("sharedpref", SharedPref.getString("key1"));
        Log.d("sharedpref", SharedPref.getString("key2"));

        return rootView;
    }

    private void setListeners(){
        final Fragment f = this;
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: retrofit

                ((MainActivity)f.getActivity()).onChangeFragment(FragmentHomeScreen.class, new Bundle(), false);
            }
        });
    }
}