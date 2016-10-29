package uk.co.ivaylokhr.beacon123.view.callbackinterface;

import android.os.Bundle;

public interface Callbacks
{
    /**
     * Callback for when an item has been selected.
     */
    public void onChangeFragment(Class fragment, Bundle args, boolean shouldAddToBackstack);
    public void onLayoutLoaded();
}