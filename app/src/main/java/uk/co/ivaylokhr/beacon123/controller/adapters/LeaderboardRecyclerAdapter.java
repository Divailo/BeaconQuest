package uk.co.ivaylokhr.beacon123.controller.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.ButterKnife;
import uk.co.ivaylokhr.beacon123.R;
import uk.co.ivaylokhr.beacon123.model.LeaderboardItem;

/**
 * Created by Ivaylo on 29/10/2016.
 */

public class LeaderboardRecyclerAdapter extends BaseRecyclerAdapter {

    private ArrayList<LeaderboardItem> leaderboardElements;

    public LeaderboardRecyclerAdapter(Context context, ArrayList<LeaderboardItem> elements) {
        super(context);
        leaderboardElements = elements;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater
                .inflate(
                        R.layout.leaderboard_item,
                        parent,
                        false);

        LeaderboardViewHolder holder = new LeaderboardViewHolder(v);

        return holder;
    }

    @Override
    //TODO
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        LeaderboardViewHolder actualHolder = (LeaderboardViewHolder) holder;
        LeaderboardItem currentQuest = leaderboardElements.get(position);

        //put model into view by actualHolder.someview.set......

    }

    @Override
    public int getItemCount() {
        return leaderboardElements == null ? 0 : leaderboardElements.size();
    }

    class LeaderboardViewHolder extends RecyclerView.ViewHolder {

        public LeaderboardViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}