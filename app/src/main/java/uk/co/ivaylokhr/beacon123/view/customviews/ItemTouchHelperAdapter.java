package uk.co.ivaylokhr.beacon123.view.customviews;

/**
 * Created by Ivaylo on 30/10/2016.
 */

public interface ItemTouchHelperAdapter {

    boolean onItemMove(int fromPosition, int toPosition);

    void onItemDismiss(int position);
}
