package com.thotrinh.startactivityforresult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import static com.thotrinh.startactivityforresult.LoginActivity.LOGIN_SUCCESS;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnLogin;
    private TextView txtWelcome;
    public static final int request_code = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = this.findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);
        txtWelcome = this.findViewById(R.id.txt_welcome);

        // remove title;
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // hide action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

    }

    @Override
    public void onClick(View v) {
        // do something
        Intent intent = new Intent(this, LoginActivity.class);
        startActivityForResult(intent, request_code);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == request_code){
            if(resultCode == RESULT_OK){
                btnLogin.setVisibility(View.INVISIBLE);
                String name = data.getStringExtra(LOGIN_SUCCESS);
                txtWelcome.setText("Welcome, " + name);
            }
            if(resultCode == RESULT_CANCELED){
                txtWelcome.setText("Fail to login, please try again!");
            }
        }
    }
}
