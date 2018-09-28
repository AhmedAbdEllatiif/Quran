package com.example.ahmedd.quraan.API;

import com.example.ahmedd.quraan.API.Model.RadioResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Services {

    @GET("radio/radio_ar.json")
    Call<RadioResponse> getRadioChannels();

}
