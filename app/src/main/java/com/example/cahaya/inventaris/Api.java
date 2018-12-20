package com.example.cahaya.inventaris;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("api/model_inventaris")
    Call<List<Inventaris>> getInventaris();
}
