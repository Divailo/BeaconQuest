package uk.co.ivaylokhr.beacon123.view.customviews;

/**
 * Created by Ivaylo on 30/10/2016.
 */

public interface ItemTouchHelperViewHolder {

    /**
     * Called when the  ItemTouchHelper first registers an
     * item as being moved or swiped.
     * Implementations should update the item view to indicate
     * it's active state.
     */
    void onItemSelected();


    /**
     * Called when the ItemTouchHelper has completed the
     * move or swipe, and the active item state should be cleared.
     */
    void onItemClear();
}
