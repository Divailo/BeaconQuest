package uk.co.ivaylokhr.beacon123.controller.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Ivaylo on 30/10/2016.
 */

public class SharedPref {

    static SharedPreferences sp;

    public SharedPref(Context con){
        sp = PreferenceManager.getDefaultSharedPreferences(con);
    }

    public static void putString(String key, String info){
        android.content.SharedPreferences.Editor editor = sp.edit();
        String actualKey = key.toLowerCase();
        editor.putString(actualKey, info);
        editor.apply();
}

    public static String getString(String key){
        String actualKey = key.toLowerCase();
        return sp.getString(actualKey, null);
    }

}
