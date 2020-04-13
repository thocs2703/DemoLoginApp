package com.thotrinh.startactivityforresult;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnVerify;
    private EditText edtUser;
    private EditText edtPw;

    public static final String LOGIN_SUCCESS = "login_success";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnVerify = this.findViewById(R.id.btn_verify);
        edtUser = this.findViewById(R.id.edt_user);
        edtPw = this.findViewById(R.id.edt_pw);

        btnVerify.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String user = edtUser.getText().toString();
        String pw = edtPw.getText().toString();
        if(user.equals("tho") && pw.equals("123456")){
            Intent intent = new Intent();
            intent.putExtra(LOGIN_SUCCESS, user);
            setResult(Activity.RESULT_OK, intent);
            finish();
        }
        else{
            Intent intent = new Intent();
            setResult(Activity.RESULT_CANCELED, intent);
            finish();
        }
    }
}
