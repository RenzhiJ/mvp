package baishun.com.mvp.utils;


import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {

    public static final String BASE_URL="http://if.snssdk.com/neihan/";
    private static volatile RetrofitUtils instace;
    private OkHttpClient client;
    private static ApiService apiService;




    private RetrofitUtils (){
        client = new OkHttpClient.Builder().addInterceptor(new Intercept()).build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(Api.ANOTHER_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    public static RetrofitUtils getInstance () {
        if (instace == null) {
            synchronized (RetrofitUtils.class) {
                if (null == instace) {
                    instace = new RetrofitUtils();
                }
            }
        }
        return instace;
    }
    public ApiService getApiService () {
        return apiService;
    }
}
