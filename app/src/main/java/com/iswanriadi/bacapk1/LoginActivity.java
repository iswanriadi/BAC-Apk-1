package com.iswanriadi.bacapk1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText mEdtUsername, mEdtPassword, mEdtPesan;
    private TextView mTvRegistrasi;
    private Button mBtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEdtUsername = findViewById(R.id.edt_username);
        mEdtPassword = findViewById(R.id.edt_password);
        mEdtPesan = findViewById(R.id.edt_pesan);
        mTvRegistrasi = findViewById(R.id.tv_registrasi);
        mBtnLogin = findViewById(R.id.btn_login);

        mTvRegistrasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistrasiActivity.class);
                startActivity(intent);
            }
        });

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username, password, pesan;
                Boolean validasi = true;

                username = mEdtUsername.getText().toString();
                password = mEdtPassword.getText().toString();
                pesan = mEdtPesan.getText().toString();

                if (username.isEmpty()) {
                    mEdtUsername.setError("Tidak boleh kosong");
                    validasi = false;
                }
                if (password.isEmpty()) {
                    mEdtPassword.setError("Tidak boleh kosong");
                    validasi = false;
                }

                if (validasi) {
                    cekLogin(username, password, pesan);
                }
            }
        });
    }

    private void cekLogin(final String username, final String password, final String pesan) {
        if ((username.equals("user") && password.equals("12345")) || (username.equals("admin") && password.equals("54321"))) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            if (username.equals("user")) {
                intent.putExtra("username", "User");
            } else if (username.equals("admin")) {
                intent.putExtra("username", "Admin");
            }
            intent.putExtra("pesan", pesan);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(LoginActivity.this, "Login gagal", Toast.LENGTH_SHORT).show();
        }
    }
}
