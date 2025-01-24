package vn.iostar.handmade;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class RetrofitClient {
    // URL cơ bản của API
    private static final String BASE_URL = "http://localhost:8080/api/auth/register"; // Thay đổi URL của bạn

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())  // Sử dụng Gson để phân tích cú pháp JSON
                    .build();
        }
        return retrofit;
    }
}
