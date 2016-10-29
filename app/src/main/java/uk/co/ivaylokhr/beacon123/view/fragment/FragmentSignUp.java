package uk.co.ivaylokhr.beacon123.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.ivaylokhr.beacon123.R;

/**
 * Created by Ivaylo on 29/10/2016.
 */

public class FragmentSignUp extends BaseFragment {

    @BindView(R.id.signup_button) Button signUpButton;

    public FragmentSignUp() {
    }

    public static FragmentSignUp newInstance(int pos) {
        FragmentSignUp fragmentMyProfile = new FragmentSignUp();

        Bundle args = new Bundle();
        args.putInt("pos", pos);
        fragmentMyProfile.setArguments(args);

        return fragmentMyProfile;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_signup, container, false);
        ButterKnife.bind(this, rootView);

        setListeners();

        return rootView;
    }

    private void setListeners(){
        final Fragment f = this;
//        signInButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //TODO: retrofit
//                ((MainActivity)f.getActivity()).onChangeFragment(FragmenHomeScreen.class, new Bundle(), false);
//            }
//        });
    }
}