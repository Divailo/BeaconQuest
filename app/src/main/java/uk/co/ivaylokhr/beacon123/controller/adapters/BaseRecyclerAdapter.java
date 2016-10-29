package uk.co.ivaylokhr.beacon123.controller.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

/**
 * Created by Ivaylo on 29/10/2016.
 */

public abstract class BaseRecyclerAdapter extends RecyclerView.Adapter {

    protected Context context;
    protected LayoutInflater inflater;

    protected BaseRecyclerAdapter(Context context) {
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
}