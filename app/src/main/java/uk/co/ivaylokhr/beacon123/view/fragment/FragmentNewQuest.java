package uk.co.ivaylokhr.beacon123.view.fragment;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import uk.co.ivaylokhr.beacon123.R;
import uk.co.ivaylokhr.beacon123.controller.requestcallbacks.ChallengeAnswerCallback;
import uk.co.ivaylokhr.beacon123.controller.util.SharedPref;
import uk.co.ivaylokhr.beacon123.model.services.BeaconQuestService;
import uk.co.ivaylokhr.beacon123.view.activity.MainActivity;

/**
 * Created by Ivaylo on 30/10/2016.
 */

public class FragmentNewQuest extends BaseFragment {

    @BindView(R.id.newquest_description) TextView descr;
    @BindView(R.id.finishquest_answer_box) TextInputEditText answerBox;
    @BindView(R.id.submit_button) Button bs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_new_quest, container, false);

        final Fragment selfRef = this;

        ButterKnife.bind(this, rootView);
        descr.setText(SharedPref.getString("keyy"));

        bs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                BeaconQuestService bqs = ((MainActivity)getActivity()).getRetrofit().create(BeaconQuestService.class);
                Call<ResponseBody> call = bqs.challengeAnswer("6", "b1", String.valueOf(answerBox.getText()));
                call.enqueue(new ChallengeAnswerCallback((MainActivity)getActivity()));

                ((MainActivity)getActivity()).onChangeFragment(FragmentProfilePaged.class, new Bundle(), false);

            }
        });

        return rootView;
    }




}
