package uk.co.ivaylokhr.beacon123.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.estimote.sdk.SystemRequirementsChecker;

import retrofit2.Retrofit;
import uk.co.ivaylokhr.beacon123.R;
import uk.co.ivaylokhr.beacon123.controller.util.SharedPref;
import uk.co.ivaylokhr.beacon123.view.callbackinterface.Callbacks;
import uk.co.ivaylokhr.beacon123.view.fragment.FragmentSignInUpPaged;

public class MainActivity extends AppCompatActivity implements Callbacks {

    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPref sp = new SharedPref(this);
        SharedPref.putString("key1", "value1");
        SharedPref.putString("key2", "value2");
        initRetrofit();
        onChangeFragment(FragmentSignInUpPaged.class, new Bundle(), false);
    }

    private void initRetrofit(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://untitled-danchoqkiqmanqk.c9users.io/")
                .build();
    }

    public Retrofit getRetrofit(){
        return retrofit;
    }

    @Override
    protected void onResume() {
        super.onResume();

        SystemRequirementsChecker.checkWithDefaultDialogs(this);
    }

    @Override
    public void onChangeFragment(Class fragment, Bundle args, boolean shouldAddToBackstack)
    {
        try
        {
            Fragment f = (Fragment) (Class.forName(fragment.getName()).newInstance());
            f.setArguments(args);

            Fragment old_fragment = (Fragment) getSupportFragmentManager().findFragmentById(R.id.container);

            if(shouldAddToBackstack){
                getSupportFragmentManager().beginTransaction().replace(R.id.container, f).addToBackStack(fragment.getSimpleName()).commit();
            }
            else{
                getSupportFragmentManager().beginTransaction().replace(R.id.container, f).commit();
            }

        }catch(ClassNotFoundException e)
        {
            e.printStackTrace();
            Log.e("REFLECTION", "ClassNotFoundException", e);
        }catch(InstantiationException e)
        {
            e.printStackTrace();
            Log.e("REFLECTION", "InstantiationException", e);
        }catch(IllegalAccessException e)
        {
            e.printStackTrace();
            Log.e("REFLECTION", "IllegalAccessException", e);
        }
    }

    @Override
    public void onLayoutLoaded()
    {

    }

    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
