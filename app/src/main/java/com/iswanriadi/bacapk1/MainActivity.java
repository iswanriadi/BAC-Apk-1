package com.iswanriadi.bacapk1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String username, pesan;
    private TextView mTvUsername, mTvPesan;
    private Button mBtnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvUsername = findViewById(R.id.tv_username);
        mTvPesan = findViewById(R.id.tv_pesan);
        mBtnLogout = findViewById(R.id.btn_logout);

        if (getIntent().getStringExtra("username") != null && getIntent().getStringExtra("pesan") != null) {
            username = getIntent().getStringExtra("username");
            pesan = getIntent().getStringExtra("pesan");

            mTvUsername.setText(username);
            if (pesan.isEmpty()) {
                mTvPesan.append("-");
            } else {
                mTvPesan.append(pesan);
            }
        } else {
            mTvUsername.setText("Tidak ada intent extra");
            mTvPesan.setText("Tidak ada intent extra");
        }

        mBtnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
    }
}
