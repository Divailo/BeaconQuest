package uk.co.ivaylokhr.beacon123.controller.requestcallbacks;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.ivaylokhr.beacon123.view.activity.MainActivity;

/**
 * Created by Ivaylo on 30/10/2016.
 */

public abstract class BaseCallback implements Callback<ResponseBody> {

    protected MainActivity contextActivity;

    protected String result;

    protected String errorTag = "callbackfail";

    public BaseCallback(MainActivity activity){
        contextActivity = activity;
    }

    @Override
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        int statusCode = response.code();
        Log.i("statuscode", String.valueOf(statusCode));

        BufferedReader reader = null;
        StringBuilder sb = new StringBuilder();
        if (response.body().byteStream() != null) {
            reader = new BufferedReader(
                    new InputStreamReader(response.body().byteStream()));
            String line;
            try {
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            result = sb.toString();
            Log.i("result", result);

        }
    }

    @Override
    public void onFailure(Call<ResponseBody> call, Throwable t) {
        Log.i(errorTag, "problemcheta");
//        BaseActivity.showMessage(contextActivity, "Can't connect to server");
    }


}
