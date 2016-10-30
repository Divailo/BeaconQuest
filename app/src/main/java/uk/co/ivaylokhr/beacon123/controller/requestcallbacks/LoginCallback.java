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

public class LoginCallback extends BaseCallback {

    JSONObject jsonObject;

    public LoginCallback(MainActivity activity) {
        super(activity);
    }

    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response){
        super.onResponse(call,response);
        Log.d("result",result);

        try {
            jsonObject = new JSONObject(result);

//            String text2 = (String) jsonObject.get("Error");
//            if(!(text2.isEmpty() || text2 == null)){
//                Log.d("result",text2);
//                String s = SharedPref.getString("keyy");
//                return;
//            }

            String text = (String) jsonObject.get("Success");
            Log.d("result",text);

            applicationContext.cache(text);
            //do something with text
        } catch (JSONException e) {
            Log.i(errorTag, "problem v LoginCallback JSON");
        }

    }

    @Override
    public void onFailure(Call<ResponseBody> call, Throwable t) {
        Log.i(errorTag, "problem v LoginCallback");
//        BaseActivity.showMessage(applicationContext, "Can't connect to server");
    }
}
