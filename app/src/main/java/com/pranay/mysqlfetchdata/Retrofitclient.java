package com.pranay.mysqlfetchdata;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofitclient
{
    private static Retrofit retrofit=null;
    private static Retrofitclient retrofitclient;

    public  Retrofitclient()
    {

        if (retrofit==null)
        {
            retrofit=new Retrofit.Builder()
                    .baseUrl("Your link or localhost address")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }

    }

    public static synchronized Retrofitclient getInstance()
    {
        if (retrofitclient==null)
        {
            retrofitclient=new Retrofitclient();
        }
        return retrofitclient;
    }

    public Api getapi()
    {
        return retrofit.create(Api.class);
    }
}
