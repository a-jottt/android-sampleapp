package pl.neducatio.myapplication;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

public class RetrofitFactory {

    public static final String REST_ENDPOINT_URL = "http://ip.jsontest.com";
    public static Retrofit adapter;

    public static Retrofit getAdapter() {
        if (adapter != null) {
            return adapter;
        }

        adapter = new Retrofit.Builder()
                .baseUrl(REST_ENDPOINT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return adapter;
    }
}
