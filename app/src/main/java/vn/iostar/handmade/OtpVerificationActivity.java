package vn.iostar.handmade;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OtpVerificationActivity extends AppCompatActivity {

    private EditText etOtpCode;
    private Button btnVerifyOtp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);

        etOtpCode = findViewById(R.id.etOtpCode);
        btnVerifyOtp = findViewById(R.id.btnVerifyOtp);

        btnVerifyOtp.setOnClickListener(v -> verifyOtp());
    }

    private void verifyOtp() {
        String otp = etOtpCode.getText().toString();

        if (otp.isEmpty()) {
            Toast.makeText(this, "Please enter the OTP", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO: Call backend verify OTP API
    }
}
