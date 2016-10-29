package uk.co.ivaylokhr.beacon123.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import uk.co.ivaylokhr.beacon123.view.callbackinterface.Callbacks;

public abstract class BaseFragment extends Fragment
{
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        mCallbacks.onLayoutLoaded();
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        // Activities containing this fragment must implement its callbacks.
        if (!(context instanceof Callbacks))
        {
            throw new IllegalStateException("Activity must implement fragment's callbacks.");
        }

        mCallbacks = (Callbacks) context;
    }

    @Override
    public void onDetach()
    {
        super.onDetach();

        // Reset the active callbacks interface to the dummy implementation.
        mCallbacks = sDummyCallbacks;
    }

    /**
     * The fragment's current callback object, which is notified of list item
     * clicks.
     */
    protected Callbacks mCallbacks = sDummyCallbacks;

    /**
     * A dummy implementation of the {@link Callbacks} interface that does
     * nothing. Used only when this fragment is not attached to an activity.
     */
    private static Callbacks sDummyCallbacks = new Callbacks()
    {
        @Override
        public void onLayoutLoaded(){}

        @Override
        public void onChangeFragment(Class fragment, Bundle args, boolean shouldAddToBackstack){}
    };
}
