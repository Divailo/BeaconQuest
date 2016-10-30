package uk.co.ivaylokhr.beacon123.controller.requestcallbacks;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import uk.co.ivaylokhr.beacon123.view.activity.MainActivity;

/**
 * Created by Ivaylo on 30/10/2016.
 */

public class ChallengeCreateCallback extends BaseCallback {

    JSONObject jsonObject;

    public ChallengeCreateCallback(MainActivity activity) {
        super(activity);
    }

    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response){
        super.onResponse(call,response);
        Log.d("result",result);

        try {
            jsonObject = new JSONObject(result);
            String text = (String) jsonObject.get("ChallengeText");
            //do something with text
        } catch (JSONException e) {
            Log.i(errorTag, "problem v ChallengeNew JSON");
        }

    }

    @Override
    public void onFailure(Call<ResponseBody> call, Throwable t) {
        Log.i(errorTag, "problem v ChallengeNew");
//        BaseActivity.showMessage(contextActivity, "Can't connect to server");
    }
}
