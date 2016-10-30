package uk.co.ivaylokhr.beacon123.model.services;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Ivaylo on 30/10/2016.
 */

public interface BeaconQuestService {

    @FormUrlEncoded
    @POST("/challengeNew")
    Call<ResponseBody> registerBeacon(@Field("accountId") String userid,
                                      @Field("beaconId") String beaconid
    );

    @FormUrlEncoded
    @POST("/challengeAnswer")
    Call<ResponseBody> challengeAnswer(@Field("accountId") String userid,
                                      @Field("beaconId") String beaconid,
                                       @Field("answer") String answer
    );

    @FormUrlEncoded
    @POST("/challengeCancel")
    Call<ResponseBody> challengeAnswer(@Field("accountId") String userid,
                                       @Field("beaconId") String beaconid
    );

    @FormUrlEncoded
    @POST("/registerAccount")
    Call<ResponseBody> registerAccount(@Field("username") String username,
                                       @Field("email") String mail,
                                       @Field("password") String password
    );

    @FormUrlEncoded
    @POST("/login")
    Call<ResponseBody> login(@Field("username") String username,
                             @Field("password") String password
    );
}
