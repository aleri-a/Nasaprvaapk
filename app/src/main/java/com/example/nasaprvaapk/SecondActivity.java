package com.example.nasaprvaapk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;


public class SecondActivity extends AppCompatActivity {

    CheckBox chbZivotinja, chbFamousPeople, chbFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        chbZivotinja = (CheckBox) findViewById(R.id.chbAnimals);
        chbFamousPeople = (CheckBox) findViewById(R.id.chbFamousPerson);
        chbFood = (CheckBox) findViewById(R.id.chbFruits);
    }



    public void onFindClicked(View v) {
        Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
        Bundle bundle = new Bundle();
        bundle.putBoolean(AppConstants.KEY_ANIMAL, chbZivotinja.isChecked());
        bundle.putBoolean(AppConstants.KEY_FAMOUSpERSONE, chbFamousPeople.isChecked());
        bundle.putBoolean(AppConstants.KEY_FOOD, chbFood.isChecked());

        Intent intent=new Intent(SecondActivity.this,ThridActivity.class);
        intent.putExtras(bundle); //saljem parametre drugoj aktivnosti koja je navedena u intent gde pise iz second salji thrid-u
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}

