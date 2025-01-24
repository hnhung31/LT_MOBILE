package vn.iostar.handmade;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForgotPasswordActivity extends AppCompatActivity {

    private EditText emailInput;
    private Button sendOtpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        emailInput = findViewById(R.id.etForgotPasswordEmail);
        sendOtpButton = findViewById(R.id.btnSendOtp);

        sendOtpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailInput.getText().toString();
                if (email.isEmpty()) {
                    Toast.makeText(ForgotPasswordActivity.this, "Vui lòng nhập email", Toast.LENGTH_SHORT).show();
                } else {
                    sendOtp(email);
                }
            }
        });
    }

    private void sendOtp(String email) {
        // Tạo đối tượng RequestBody cho email
        RequestBody requestBody = RequestBody.create(okhttp3.MultipartBody.FORM, email);

        // Gọi API để gửi OTP
        ApiService apiService = RetrofitClient.getClient().create(ApiService.class); // Đảm bảo gọi đúng RetrofitClient
        Call<ResponseBody> call = apiService.forgotPassword(requestBody);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(ForgotPasswordActivity.this, "OTP đã được gửi tới email của bạn", Toast.LENGTH_SHORT).show();
                    // Chuyển đến màn hình nhập OTP hoặc xác nhận
                } else {
                    Toast.makeText(ForgotPasswordActivity.this, "Đã xảy ra lỗi, vui lòng thử lại", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(ForgotPasswordActivity.this, "Lỗi mạng: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
