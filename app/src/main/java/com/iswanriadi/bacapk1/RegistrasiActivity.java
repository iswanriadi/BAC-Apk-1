package com.iswanriadi.bacapk1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrasiActivity extends AppCompatActivity {

    private EditText mEdtUsername, mEdtEmail, mEdtPassword;
    private TextView mTvLogin;
    private Button mBtnRegistrasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);

        mEdtUsername = findViewById(R.id.edt_username);
        mEdtEmail = findViewById(R.id.edt_email);
        mEdtPassword = findViewById(R.id.edt_password);
        mTvLogin = findViewById(R.id.tv_login);
        mBtnRegistrasi = findViewById(R.id.btn_registrasi);

        mTvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mBtnRegistrasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username, email, password;
                Boolean validasi = true;

                username = mEdtUsername.getText().toString();
                email = mEdtEmail.getText().toString();
                password = mEdtPassword.getText().toString();

                if (username.isEmpty()) {
                    mEdtUsername.setError("Tidak boleh kosong");
                    validasi = false;
                }
                if (email.isEmpty()) {
                    mEdtEmail.setError("Tidak boleh kosong");
                    validasi = false;
                } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    mEdtEmail.setError("Email tidak valid");
                    validasi = false;
                }
                if (password.isEmpty()) {
                    mEdtPassword.setError("Tidak boleh kosong");
                    validasi = false;
                }

                if (validasi) {
                    Toast.makeText(RegistrasiActivity.this, "Registrasi berhasil...", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
