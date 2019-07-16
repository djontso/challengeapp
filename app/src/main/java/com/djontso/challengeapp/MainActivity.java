package com.djontso.challengeapp;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Intent intent;

    Button btn, btn3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn = (Button) findViewById(R.id.btn1);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn1:
                        Intent intent = new Intent(MainActivity.this, AboutAlc.class);
                        startActivity(intent);
                        break;

                }

            }
        });
            Button btn3 = (Button) findViewById(R.id.btn2);

            btn3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    switch (v.getId()) {
                        case R.id.btn2:
                            Intent intent = new Intent(MainActivity.this, MyProfile.class);
                            startActivity(intent);
                            break;

                    }

                }
            });

    }

}
