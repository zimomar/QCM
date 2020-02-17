package com.androiddev.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class qcm extends Activity {
    final String EXTRA_LOGIN = "user_login";
    final String EXTRA_PASSWORD = "user_password";
    TextView login;
    TextView mdp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_display);
        Intent intent = getIntent();
        login = (TextView) findViewById(R.id.email_display);
        mdp = (TextView) findViewById(R.id.password_display);
        if(intent!=null){
            login.setText(intent.getStringExtra(EXTRA_LOGIN));
            mdp.setText(intent.getStringExtra(EXTRA_PASSWORD));
        }
    }
}
