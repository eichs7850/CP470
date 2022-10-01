package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class ListItemsActivity extends AppCompatActivity {
    public Uri globalUri;
    protected static final String ACTIVITY_NAME = "ListItemsActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);
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
    public void ClickCameraButton(View v) throws IOException {
        Intent cameraIntent = new Intent( "android.media.action.IMAGE_CAPTURE");
        String fn = "picture_";
        File store = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File pic = File.createTempFile( fn, ".jpg", store );
        Uri photoURI = FileProvider.getUriForFile(this,
                "com.mydomain.fileprovider",
                pic);
        globalUri = photoURI;
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
        Log.i("camera", "worked til here");
        startActivityForResult(cameraIntent, 0);
    }
    public void Print(String s){
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();

    }
    public void onCheckChanged(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(ListItemsActivity.this);
        // 2. Chain together various setter methods to set the dialog characteristics
        builder.setMessage(R.string.dialog_message) //Add a dialog message to strings.xml

                .setTitle(R.string.dialog_title)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        Intent resultIntent = new Intent(  );
                        resultIntent.putExtra("Response", "Here is my response");
                        setResult(Activity.RESULT_OK, resultIntent);
                        finish();
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                })
                .show();


    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        getContentResolver().notifyChange(globalUri, null);
        ImageButton ib = (ImageButton) findViewById(R.id.CameraButton);
        try{
            Bitmap bm = MediaStore.Images.Media.getBitmap(this.getContentResolver(), globalUri);
            ib.setImageBitmap(Bitmap.createScaledBitmap(bm, 70,70, false));
        }catch (Exception e){
            Log.e("liftItemError","An error has occurred!");
        }

    }
    public void setOnCheckedChanged(View v){
        Switch s = (Switch) findViewById(R.id.ActivitySwitchID);
        if(!s.isChecked()){
            Toast.makeText(this, "Switch is Off", Toast.LENGTH_SHORT)
                    .show();
        }
        else{
            Toast.makeText(this, "Switch is On", Toast.LENGTH_SHORT)
                    .show();
        }


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