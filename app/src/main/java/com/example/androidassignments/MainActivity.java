package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    protected static final String ACTIVITY_NAME = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Chat(View v){
        Log.i(ACTIVITY_NAME, "User clicked Chat");
        Intent next_page = new Intent(MainActivity.this, ChatWindow.class);
        startActivity(next_page);
    }
    public void Print(String s){
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();

    }
    public void ListViewOpen(View v){
        int timer = 10;
        Intent next_page = new Intent(this, ListItemsActivity.class);
        startActivityForResult(next_page, timer);
    }
    @Override
    public void onActivityResult(int requestCode, int responseCode, Intent Data) {
        super.onActivityResult(requestCode, responseCode, Data);
        String mes = Data.getStringExtra("Response");
        if(requestCode==10 && responseCode== Activity.RESULT_OK) {
            String messagePassed = Data.getStringExtra("Response");
            Print(messagePassed);
            Log.i(ACTIVITY_NAME, "Returned to MainActivity.onActivityResult");
        }else{
            Log.i(ACTIVITY_NAME, "Code isn't right");
        }


    }

    public void onClick(View v){
        Log.i(ACTIVITY_NAME,"User clicked Start Chat");
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