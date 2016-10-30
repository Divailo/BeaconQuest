package uk.co.ivaylokhr.beacon123.model.services;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Ivaylo on 30/10/2016.
 */

public interface BeaconQuestService {

    @GET("/beaconQuest/index/takeChallenge/{accountId}/{beaconId}")
    Call<ResponseBody> takeChallenge (@Path("accountId") String accountId,
                                      @Path("beaconId") String beaconId
    );

    @GET("beaconQuest/index//challengeAnswer/{accountId}/{beaconId}/{answer}")
    Call<ResponseBody> challengeAnswer(@Path("accountId") String userid,
                                      @Path("beaconId") String beaconid,
                                       @Path("answer") String answer
    );

    @GET("beaconQuest/index//challengeCancel/{accountId}/{beaconId}")
    Call<ResponseBody> challengeAnswer(@Path("accountId") String userid,
                                       @Path("beaconId") String beaconid
    );

    @GET("beaconQuest/index//register/{username}/{password}")
    Call<ResponseBody> registerAccount(@Path("username") String username,
                                       @Path("password") String password
    );

    @GET("beaconQuest/index//login/{username}/{password}/")
    Call<ResponseBody> login(@Path("username") String username,
                             @Path("password") String password
    );
}
