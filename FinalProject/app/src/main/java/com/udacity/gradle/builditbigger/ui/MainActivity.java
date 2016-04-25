package com.udacity.gradle.builditbigger.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.udacity.gradle.builditbigger.R;
import com.udacity.gradle.builditbigger.rest.EndpointsAsyncTask;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tellJoke(View view) {
        new EndpointsAsyncTask().execute(this);
    }


}
