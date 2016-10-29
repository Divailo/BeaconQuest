package uk.co.ivaylokhr.beacon123.controller.util;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ivaylo on 29/10/2016.
 */

public class ViewPagerTransformer implements ViewPager.PageTransformer
{
    public void transformPage(View view, float position)
    {
        try
        {
            @SuppressWarnings("unused")
            int pageWidth = view.getWidth();

            if(position < -1)
            {
                view.setAlpha(1);

            }else if(position <= 1)
            {
                float factor = 2f;
                @SuppressWarnings("unused")
                float step = 0.25f;
                ArrayList<View> view_arr = new ArrayList<View>();
                getFields((ViewGroup) view, view_arr);

                for(int i = 0; i < view_arr.size(); i++)
                {
                    View child = view_arr.get(i);

                    if(child instanceof Button || child instanceof ImageButton)
                    {
                        child.setScaleX(1-position/factor);
                        child.setScaleY(1-position/factor);
                    }

                    if(child instanceof TextView)
                    {
                        child.setAlpha((1 - Math.abs(position)));
                    }
                }

            }else
            {
                view.setAlpha(1);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void getFields(ViewGroup container, ArrayList<View> et_arr)
    {
        final int children = container.getChildCount();

        for(int i = 0; i < children; i++)
        {
            View child = container.getChildAt(i);

            if(child instanceof EditText || child instanceof Spinner || child instanceof Button || child instanceof ImageButton || child instanceof TextView)
            {
                et_arr.add(child);
            }else if(child instanceof ViewGroup)
            {
                getFields((ViewGroup) child, et_arr);
            }
        }
    }
}
