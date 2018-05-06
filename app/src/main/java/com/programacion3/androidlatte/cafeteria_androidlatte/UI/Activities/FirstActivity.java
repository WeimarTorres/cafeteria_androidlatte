package com.programacion3.androidlatte.cafeteria_androidlatte.UI.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.programacion3.androidlatte.cafeteria_androidlatte.R;

public class FirstActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

    static final String SHARED_PREFERENCES = "sharedPreferences";
    static final String KEY_REMEMBER = "rememberOneTimeLogin";
    static final String KEY_IS_ADMINISTRATIVE = "rememberIsAdministrative";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms
                boolean rememberOneTimeLogin = sharedPreferences.getBoolean(KEY_REMEMBER, false);
                boolean rememberIsAdministrative = sharedPreferences.getBoolean(KEY_IS_ADMINISTRATIVE, false);
                if (rememberOneTimeLogin && !rememberIsAdministrative) {
                    Intent intent = new Intent(FirstActivity.this, MenuActivity.class);
                    startActivity(intent);
                } else if (rememberOneTimeLogin && rememberIsAdministrative) {
                    Intent intent = new Intent(FirstActivity.this, MenuCaseActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(FirstActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        }, 3000);
    }
}
