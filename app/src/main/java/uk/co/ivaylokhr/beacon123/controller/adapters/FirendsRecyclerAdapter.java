package uk.co.ivaylokhr.beacon123.controller.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.ButterKnife;
import uk.co.ivaylokhr.beacon123.R;
import uk.co.ivaylokhr.beacon123.model.Friend;

/**
 * Created by Ivaylo on 29/10/2016.
 */

public class FirendsRecyclerAdapter extends BaseRecyclerAdapter {

    private ArrayList<Friend> friendsList;

    public FirendsRecyclerAdapter(Context context, ArrayList<Friend> elements) {
        super(context);
        friendsList = elements;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater
                .inflate(
                        R.layout.friend_element,
                        parent,
                        false);

        FriendViewHolder holder = new FriendViewHolder(v);

        return holder;
    }

    @Override
    //TODO
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        FriendViewHolder actualHolder = (FriendViewHolder) holder;
        Friend currentQuest = friendsList.get(position);

        //put model into view by actualHolder.someview.set......

    }

    @Override
    public int getItemCount() {
        return friendsList == null ? 0 : friendsList.size();
    }

    class FriendViewHolder extends RecyclerView.ViewHolder {

        public FriendViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}