package uk.co.ivaylokhr.beacon123.controller.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
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

        //put model into view by actualHolder.someview.set......
        actualHolder.tv1.setText(currentQuest.getString1());
        actualHolder.tv2.setText(currentQuest.getString2());
        actualHolder.tv3.setText(currentQuest.getString3());

    }

    @Override
    public int getItemCount() {
        return questList== null ? 0 : questList.size();
    }

    class QuestViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.quest_string1) TextView tv1;
        @BindView(R.id.quest_string2) TextView tv2;
        @BindView(R.id.quest_string3) TextView tv3;

        public QuestViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
