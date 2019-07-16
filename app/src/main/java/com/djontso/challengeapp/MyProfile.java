package com.djontso.challengeapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class MyProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profil);

        getSupportActionBar().setTitle("My Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
