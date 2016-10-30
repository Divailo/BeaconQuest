package uk.co.ivaylokhr.beacon123.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.ivaylokhr.beacon123.R;
import uk.co.ivaylokhr.beacon123.controller.adapters.QuestRecyclerAdapter;
import uk.co.ivaylokhr.beacon123.model.Quest;

/**
 * Created by Ivaylo on 29/10/2016.
 */

public class FragmentProfileQuests extends BaseFragment {

    @BindView(R.id.profile_some_list) RecyclerView questList;

    public FragmentProfileQuests() {
    }

    public static FragmentProfileQuests newInstance(int pos) {
        FragmentProfileQuests fragmentMyProfile = new FragmentProfileQuests();

        Bundle args = new Bundle();
        args.putInt("pos", pos);
        fragmentMyProfile.setArguments(args);

        return fragmentMyProfile;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_profile_quests, container, false);
        ButterKnife.bind(this, rootView);

        setUpRecycler();

        return rootView;
    }

    private void setUpRecycler(){
        ArrayList<Quest> adsList = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            adsList.add(new Quest("ADIDAS TRACKSUIT", "Sofia, Bulgaria", "40 £"));
            adsList.add(new Quest("ADIBAS TRACKSUIT", "534, California", "10 €" ));
            adsList.add(new Quest("ODIBOS TRACKSUIT", "Top Ad", "50 £"));
        }

        questList.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        questList.setAdapter(new QuestRecyclerAdapter(this.getActivity(), adsList));

    }

}
