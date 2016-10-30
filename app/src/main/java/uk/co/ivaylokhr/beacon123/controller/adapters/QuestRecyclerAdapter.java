package uk.co.ivaylokhr.beacon123.controller.adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.ivaylokhr.beacon123.R;
import uk.co.ivaylokhr.beacon123.model.Quest;

/**
 * Created by Ivaylo on 29/10/2016.
 */

public class QuestRecyclerAdapter extends BaseRecyclerAdapter {

    private ArrayList<Quest> questList;

    public QuestRecyclerAdapter(Context context, ArrayList<Quest> elements) {
        super(context);
        questList = elements;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater
                .inflate(
                        R.layout.quest_element,
                        parent,
                        false);

        QuestViewHolder holder  = new QuestViewHolder(v);

        return holder;
    }

    @Override
    //TODO
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        QuestViewHolder actualHolder = (QuestViewHolder) holder;
        Quest currentQuest = questList.get(position);

        actualHolder.tv1.setText(currentQuest.getString1());
        actualHolder.tv2.setText(currentQuest.getString2());
        actualHolder.tv3.setText(currentQuest.getString3());

        if (currentQuest.getString3().equals("Completed") || currentQuest.getString3().equals("Cancelled")){
            actualHolder.cancelOption.setVisibility(View.GONE);
        } else {
            actualHolder.cancelOption.setVisibility(View.VISIBLE);

        }


        int resId;
        switch (currentQuest.getString3()){
            case "Completed":
                resId = R.drawable.ic_done_black_24dp;
                break;
            case "Pending":
                resId = R.drawable.ic_alarm_black_24dp;
                break;
            case "Cancelled":
                resId = R.drawable.ic_cancel_black_24dp;
                break;
            default:
                resId = R.drawable.ic_done_black_24dp;
                break;
        }

        actualHolder.questStatusIcon.setImageDrawable(ContextCompat.getDrawable(context, resId));


    }

    @Override
    public int getItemCount() {
        return questList== null ? 0 : questList.size();
    }

    class QuestViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.quest_status_icon) ImageView questStatusIcon;
        @BindView(R.id.quest_string1) TextView tv1;
        @BindView(R.id.quest_string2) TextView tv2;
        @BindView(R.id.quest_string3) TextView tv3;
        @BindView(R.id.quest_cancel_option_container) RelativeLayout cancelOption;

        public QuestViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
