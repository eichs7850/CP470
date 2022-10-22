package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class LoginActivity extends AppCompatActivity {
    protected static final String ACTIVITY_NAME = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(ACTIVITY_NAME, "In onCreate()");
        setContentView(R.layout.activity_login);
        SharedPreferences sharedPref = getPreferences( Context.MODE_PRIVATE);
        String email = sharedPref.getString("email", "email@domain.com");
        ((EditText) findViewById(R.id.EmailText)).setText(email);
    }
    public void OpenMain(View v){
        String email_text = ((TextView)findViewById(R.id.EmailText)).getText().toString();
        String p = ((TextView)findViewById(R.id.Password)).getText().toString();
        Log.i("login",email_text);

        Boolean test = !TextUtils.isEmpty(email_text) && Patterns.EMAIL_ADDRESS.matcher(email_text).matches();

        if(test && !p.isEmpty()){
            SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("email", ((EditText) findViewById(R.id.EmailText)).getText().toString());
            editor.apply();

            Intent next_page = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(next_page);
        }else{
            ((TextView)findViewById(R.id.loginText)).setText("Incorrect Password or Email!");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(ACTIVITY_NAME, "In onResume()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(ACTIVITY_NAME, "In onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(ACTIVITY_NAME, "In onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "In onDestroy()");
    }
}