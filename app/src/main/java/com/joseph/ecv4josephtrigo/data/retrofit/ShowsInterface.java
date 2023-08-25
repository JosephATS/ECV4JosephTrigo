package com.joseph.ecv4josephtrigo.data.retrofit;

import com.joseph.ecv4josephtrigo.data.response.ShowResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ShowsInterface {
    @GET("cf10fbd8-685e-4c35-84bf-d7ccc24264fb")
    Call<ShowResponse> getShows();
}
