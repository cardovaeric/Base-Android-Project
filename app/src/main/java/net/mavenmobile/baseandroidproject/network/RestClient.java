package net.mavenmobile.baseandroidproject.network;


import net.mavenmobile.baseandroidproject.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Eric Cardova on 30-Aug-16.
 */
public class RestClient {


    public static MyAPI service;


    public static MyAPI getClient() {

        if (service == null) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);


            OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(logging).readTimeout(25, TimeUnit.SECONDS).build();
            Retrofit retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BuildConfig.BASE_URL)
                    .build();

            return retrofit.create(MyAPI.class);
        } else return service;

    }

    public interface MyAPI {

    }


}
