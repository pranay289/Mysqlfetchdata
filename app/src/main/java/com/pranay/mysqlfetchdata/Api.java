package com.pranay.mysqlfetchdata;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api
{

    @GET("yourfile.php")
    Call<List<Databaselist>> getdata();


}
