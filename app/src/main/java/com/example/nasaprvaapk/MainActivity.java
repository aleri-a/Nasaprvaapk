package com.example.nasaprvaapk;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("aktivnost1", "Pozvala se event onCreate");
        setContentView(R.layout.activity_main);

       Sleep_StartSecondActivity();


    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("aktivnost1", "OnPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("aktivnost1", "OnResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("aktivnost1", "OnRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("aktivnost1", "onDestroy");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("aktivnost1", "OnStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("aktivnost1", "OnStop");
    }
    private void Sleep_StartSecondActivity() {

        try {
            Thread.sleep(3000);
            Intent intent =new Intent(MainActivity.this, SecondActivity.class); //tako prebacujem na sledecu aktivnost xD
            startActivity(intent);
            finish(); //stavili smo samo da kad idemo da dugme na telefonu back, da nas ne vraca na ono welcome bzv je nego mu bude activity2 pocetna i to je to


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
