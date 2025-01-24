package vn.iostar.handmade;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Currency;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();
    ApiService apiService = new Retrofit.Builder()
            .baseUrl("http://localhost:8080/api/auth")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);

    Call<ResponseBody> login(@Body RequestBody body);

    @POST("/register")
    Call<ResponseBody> register(@Body RequestBody body);

    @POST("/verify-otp")
    Call<ResponseBody> verifyOtp(@Body RequestBody body);

    @POST("/forgot-password")
    Call<ResponseBody> forgotPassword(@Body RequestBody body);
}
