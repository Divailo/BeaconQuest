package uk.co.ivaylokhr.beacon123.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import uk.co.ivaylokhr.beacon123.R;

/**
 * Created by Ivaylo on 30/10/2016.
 */

public class FragmentNewQuest extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_new_quest, container, false);

        ButterKnife.bind(this, rootView);

        return rootView;
    }


}
